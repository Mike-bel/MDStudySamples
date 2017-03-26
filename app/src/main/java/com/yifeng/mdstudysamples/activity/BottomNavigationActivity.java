package com.yifeng.mdstudysamples.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yifeng.mdstudysamples.R;

/**
 * Created by yifeng on 17/3/26.
 *
 */

public class BottomNavigationActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

//        BottomNavigationView view = (BottomNavigationView) findViewById(R.id.bnv_menu);
//        view.findViewById(R.id.action_explore).performClick();
    }
}
