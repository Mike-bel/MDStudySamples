package com.yifeng.mdstudysamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

/**
 * Created by yifeng on 16/8/10.
 *
 */
public class FabActivity extends BaseActivity {

    private FloatingActionButton mAddFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        mAddFab = (FloatingActionButton) findViewById(R.id.fab_add);
    }
}
