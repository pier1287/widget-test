package it.carusopi.widgettest.widget.gridcards;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by carusopi on 22/01/2018.
 */

public class GridCardRemoteViewService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new GridCardsRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}
