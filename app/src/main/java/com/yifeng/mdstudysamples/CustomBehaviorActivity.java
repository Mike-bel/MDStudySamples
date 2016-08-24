package com.yifeng.mdstudysamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yifeng on 16/8/10.
 *
 */
public class CustomBehaviorActivity extends BaseActivity {

    private RecyclerView mContentRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior);

        mContentRv = (RecyclerView) findViewById(R.id.rv_content);
        mContentRv.setLayoutManager(new LinearLayoutManager(this));
        mContentRv.setAdapter(new ContentAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_samples, menu);
        return true;
    }

    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder>{

        @Override
        public ContentAdapter.ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ContentHolder(LayoutInflater.from(CustomBehaviorActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ContentHolder holder, int position) {
            holder.itemTv.setText("Item 00");
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ContentHolder extends RecyclerView.ViewHolder{

            private TextView itemTv;

            public ContentHolder(View itemView) {
                super(itemView);
                itemTv = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }

    }

}
