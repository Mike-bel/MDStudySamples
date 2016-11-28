package com.yifeng.mdstudysamples.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yifeng.mdstudysamples.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void onClickTabLayoutTop(View v){
        startActivity(new Intent(this, TabLayoutTopActivity.class));
    }

    public void onClickTabLayoutBottom(View v){
        startActivity(new Intent(this, TabLayoutBottomActivity.class));
    }

    public void onClickSnackbar(View v){
        startActivity(new Intent(this, SnackbarActivity.class));
    }

    public void onClickFab(View v){
        startActivity(new Intent(this, FabActivity.class));
    }

    public void onClickAbl(View v){
        startActivity(new Intent(this, AppBarLayoutActivity.class));
    }

    public void onClickBehaviorDependent(View v){
        startActivity(new Intent(this, BehaviorDependentActivity.class));
    }

    public void onClickBehaviorNested(View v){
        startActivity(new Intent(this, BehaviorNestedActivity.class));
    }

    public void onClickBehaviorExpand(View v){
        startActivity(new Intent(this, BehaviorNestedExpandActivity.class));
    }

    public void onClickTextInput(View v){
        startActivity(new Intent(this, TextInputActivity.class));
    }

}
