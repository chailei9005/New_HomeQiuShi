package chailei.com.new_homeqiushi.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import chailei.com.new_homeqiushi.entity.Information;
import chailei.com.new_homeqiushi.fragments.InfoFragment;

/**
 * Created by Administrator on 15-12-30.
 */
public class InfoCommentAdapter extends FragmentPagerAdapter{

    private List<String> list;
    private Information info;
    public InfoCommentAdapter(FragmentManager fm, List<String> list,Information info) {
        super(fm);
        this.list = list;
        this.info = info;
    }

    @Override
    public Fragment getItem(int position) {
        return InfoFragment.newInstance(list.get(position),info);
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
