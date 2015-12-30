package chailei.com.new_homeqiushi.fragments;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chailei.com.new_homeqiushi.R;
import chailei.com.new_homeqiushi.adapters.QiuShiAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiuShiFragment extends Fragment {

    private List<String> list;
    private ViewPager pager;
    private QiuShiAdapter adapter;
    private TabLayout tab;
//    private
    public QiuShiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qiu_shi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pager = (ViewPager) view.findViewById(R.id.pager_qiushi);
        tab = (TabLayout) view.findViewById(R.id.tab);
        list  = new ArrayList<String>();
        list.add("专享");
        list.add("视频");
        list.add("纯文");
        list.add("纯图");
        list.add("精华");
        list.add("最新");
        adapter = new QiuShiAdapter(getChildFragmentManager(),list);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
    }
}
