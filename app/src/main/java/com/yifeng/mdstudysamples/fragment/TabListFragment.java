package com.yifeng.mdstudysamples.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.yifeng.mdstudysamples.R;

/**
 * Created by yifeng on 16/8/3.
 *
 */
public class TabListFragment extends Fragment {

    private static final String EXTRA_CONTENT = "content";

    private ListView mContentLv;

    public static TabListFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        TabListFragment tabContentFragment = new TabListFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_tab_list, null);

        mContentLv = (ListView) contentView.findViewById(R.id.lv_content);
        ViewCompat.setNestedScrollingEnabled(mContentLv, true);
        mContentLv.setAdapter(new ContentAdapter());

        return contentView;
    }

    private class ContentAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return LayoutInflater.from(getActivity()).inflate(R.layout.item_simple_list_2, null);
        }
    }

}
