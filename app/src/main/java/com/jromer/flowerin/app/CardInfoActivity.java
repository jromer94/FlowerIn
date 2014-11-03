package com.jromer.flowerin.app;

import android.support.v4.app.Fragment;

/**
 * Created by josh on 10/12/14.
 */
public class CardInfoActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CardInfoFragment();
    }
}
