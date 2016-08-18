package com.yifeng.mdstudysamples;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by yifeng on 16/8/4.
 *
 */
public class BaseActivity extends AppCompatActivity {

    public Toolbar mToolbarTb;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        mToolbarTb = (Toolbar) findViewById(R.id.tb_toolbar);
        setSupportActionBar(mToolbarTb);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
