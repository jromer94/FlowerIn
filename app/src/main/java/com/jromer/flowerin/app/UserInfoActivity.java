package com.jromer.flowerin.app;

import android.support.v4.app.Fragment;

import com.jromer.flowerin.app.SingleFragmentActivity;

/**
 * Created by josh on 10/12/14.
 */
public class UserInfoActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new UserInfoFragment();
    }
}
