package com.jromer.flowerin.app;

import android.content.Context;

/**
 * Created by josh on 9/26/14.
 */
public class MenuHoldr {

    private static MenuHoldr sMenuHoldr;
    private static final String TAG = "MenuHoldr";
    private Context mAppContext;
    private Menu mMenu = null;

    private MenuHoldr(Context appContext){

        mAppContext = appContext;

    }

    public static MenuHoldr get(Context c){

        if(sMenuHoldr == null){

            sMenuHoldr = new MenuHoldr(c.getApplicationContext());

        }

        return sMenuHoldr;

    }

    public Menu getMenu() {
        return mMenu;
    }

    public void setMenu(Menu menu) {
        mMenu = menu;
    }
}
