package com.yifeng.mdstudysamples.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.yifeng.mdstudysamples.R;
import com.yifeng.mdstudysamples.fragment.TabListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yifeng on 16/8/10.
 *
 */
public class FabActivity extends BaseActivity {

    private DrawerLayout mRootDl;
    private LinearLayout mMenuLl;
    private TabLayout mIndicatorTl;
    private ViewPager mContentVp;

    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        mIndicatorTl = (TabLayout) findViewById(R.id.tl_indicator);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);

        initDrawer();
        initContent();
        initTab();
    }

    private void initDrawer() {
        mRootDl = (DrawerLayout) findViewById(R.id.dl_root);
        drawerToggle = new ActionBarDrawerToggle(this, mRootDl, R.string.app_name, R.string.app_name);
        mRootDl.setDrawerListener(drawerToggle);

        mMenuLl = (LinearLayout) findViewById(R.id.ll_menu);
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) mMenuLl.getLayoutParams();
        layoutParams.width = getScreenSize()[0]/4*3;

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public int[] getScreenSize(){
        int screenSize[] = new int[2];
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenSize[0] = displayMetrics.widthPixels;
        screenSize[1] = displayMetrics.heightPixels;
        return screenSize;
    }

    public void onClickFab(View v){
        Snackbar.make(findViewById(R.id.fab_add), "Show The Snackbar", Snackbar.LENGTH_SHORT).show();
    }

    private void initTab(){
        mIndicatorTl.setTabMode(TabLayout.MODE_FIXED);
        mIndicatorTl.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        mIndicatorTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(mIndicatorTl, 10);
        mIndicatorTl.setupWithViewPager(mContentVp);
    }

    private void initContent(){
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabIndicators.add("Tab " + i);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(TabListFragment.newInstance(s));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_samples, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }

    }

}
