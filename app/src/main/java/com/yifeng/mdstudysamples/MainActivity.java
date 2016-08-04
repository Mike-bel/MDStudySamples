package com.yifeng.mdstudysamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickTabLayout(View v){
        startActivity(new Intent(this, TabLayoutActivity.class));
    }

}
