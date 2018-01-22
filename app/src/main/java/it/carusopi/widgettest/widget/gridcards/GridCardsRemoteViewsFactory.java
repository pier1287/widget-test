package it.carusopi.widgettest.widget.gridcards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.LinkedList;
import java.util.List;

import it.carusopi.widgettest.R;
import it.carusopi.widgettest.model.CartaFedeltaModel;
import it.carusopi.widgettest.model.NegozioModel;

/**
 * Created by carusopi on 22/01/2018.
 */

public class GridCardsRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
    private List<CartaFedeltaModel> mFidelityCards;

    public GridCardsRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        mFidelityCards = getMockedData();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return  mFidelityCards == null ? 0 : mFidelityCards.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        if (position == AdapterView.INVALID_POSITION ||
                mFidelityCards == null || mFidelityCards.size() <= position) {
            return null;
        }


            CartaFedeltaModel card = mFidelityCards.get(position);

        RemoteViews rv =  new RemoteViews(mContext.getPackageName(), R.layout.grid_cards_widget_item);
//        rv.setTextViewText(R.id.text_view_card, card.getNegozio().getNome());
            rv.setImageViewResource(R.id.image_view_card, R.drawable.logodimeglio);

            // Next, set a fill-intent, which will be used to fill in the pending intent template
            // that is set on the collection view in StackWidgetProvider.
            Bundle extras = new Bundle();
            extras.putSerializable(GridCardsWidgetProvider.GRID_ITEM_UUID, card.getId());
            Intent fillInIntent = new Intent();
            fillInIntent.putExtras(extras);
            // Make it possible to distinguish the individual on-click
            // action of a given item
            rv.setOnClickFillInIntent(R.id.layout_grid_item_container, fillInIntent);



        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //TODO: delete
    private List<CartaFedeltaModel> getMockedData() {

        String[] fidelityCardsName = {"Coop", "Esselunga", "Carrefour", "Coin", "KFC", "Caprese"};

        List<CartaFedeltaModel> fidelityCardsModels = new LinkedList<>();

        for (String cardName : fidelityCardsName) {
            CartaFedeltaModel card = new CartaFedeltaModel();
            NegozioModel shop = new NegozioModel(cardName, "", "");
            card.setNegozio(shop);

            fidelityCardsModels.add(card);
        }
        return fidelityCardsModels;
    }
}
