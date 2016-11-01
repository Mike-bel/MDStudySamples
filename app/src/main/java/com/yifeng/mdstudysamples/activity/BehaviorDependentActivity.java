package com.yifeng.mdstudysamples.activity;

import android.app.SearchManager;
import android.app.Service;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import com.yifeng.mdstudysamples.R;

/**
 * Created by yifeng on 16/8/10.
 *
 */
public class BehaviorDependentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior_dependent);

    }

    public void onClickFab(View v){
        Snackbar.make(findViewById(R.id.fab_add), "Show The Snackbar", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Service.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchResultActivity.class)));

        return true;
    }

}
