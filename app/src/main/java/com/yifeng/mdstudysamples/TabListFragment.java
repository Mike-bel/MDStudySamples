package com.yifeng.mdstudysamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by yifeng on 16/8/3.
 *
 */
public class TabListFragment extends Fragment {

    private static final String EXTRA_CONTENT = "content";

    private ListView mContentLv;

    private String[] contentArray = new String[20];

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
        for (int i = 0; i < contentArray.length; i++) {
            contentArray[i] = "This is item " + i + " in " + getArguments().getString(EXTRA_CONTENT);
        }
        mContentLv.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, contentArray));

        return contentView;
    }
}
