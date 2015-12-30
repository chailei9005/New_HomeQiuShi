package chailei.com.new_homeqiushi.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import chailei.com.new_homeqiushi.R;
import chailei.com.new_homeqiushi.fragments.BlankFragment;

/**
 * Created by Administrator on 15-12-29.
 */
public class QiuShiAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public QiuShiAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
