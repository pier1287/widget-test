package it.carusopi.widgettest.widget.gridcards;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.UUID;

import it.carusopi.widgettest.R;

/**
 * Created by carusopi on 22/01/2018.
 */

public class GridCardsWidgetProvider extends AppWidgetProvider {

    public static final String GRID_ITEM_CLICK = "it.nttdata.android.gridwidget.GRID_ITEM_CLICK";
    public static final String GRID_ITEM_UUID = "it.nttdata.android.gridwidget.GRID_ITEM_UUID";

    @Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);
        if (intent.getAction().equals(GRID_ITEM_CLICK)) {
            int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            UUID itemUUID =  (UUID) intent.getSerializableExtra(GRID_ITEM_UUID);
            Toast.makeText(context, "Touched view " + itemUUID.toString(), Toast.LENGTH_SHORT).show();
        }
        super.onReceive(context, intent);
    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        // update each of the app widgets with the remote adapter
        for (int i = 0; i < appWidgetIds.length; ++i) {

            // Sets up the intent that points to the StackViewService that will
            // provide the views for this collection.
            Intent intent = new Intent(context, GridCardRemoteViewService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
//            // When intents are compared, the extras are ignored, so we need to embed the extras
//            // into the data so that the extras will not be ignored.
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.grid_cards_widget);
            rv.setRemoteAdapter(R.id.grid_view_fidelity_cards, intent);

            // The empty view is displayed when the collection has no items. It should be a sibling
            // of the collection view.
//            rv.setEmptyView(R.id.stack_view, R.id.empty_view);

            // This section makes it possible for items to have individualized behavior.
            // It does this by setting up a pending intent template. Individuals items of a collection
            // cannot set up their own pending intents. Instead, the collection as a whole sets
            // up a pending intent template, and the individual items set a fillInIntent
            // to create unique behavior on an item-by-item basis.
            Intent launchCardActivity = new Intent(context, GridCardsWidgetProvider.class);
            // Set the action for the intent.
            // When the user touches a particular view, it will have the effect of
            // broadcasting TOAST_ACTION.
            launchCardActivity.setAction(GridCardsWidgetProvider.GRID_ITEM_CLICK);
            launchCardActivity.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);

            PendingIntent toastPendingIntent = PendingIntent.getBroadcast(context, 0, launchCardActivity,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            rv.setPendingIntentTemplate(R.id.grid_view_fidelity_cards, toastPendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }


}
