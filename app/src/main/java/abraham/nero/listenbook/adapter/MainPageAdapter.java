package abraham.nero.listenbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import abraham.nero.listenbook.fragment.FileFragment;
import abraham.nero.listenbook.fragment.FolderFragment;

/**
 * Created by Abraham on 2017/12/26.
 */

public class MainPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<>();
        mList.add(new FolderFragment());
        mList.add(new FileFragment());
    }

    @Override
    public Fragment getItem(int position) {
        if(null == mList || position < 0 && position >= mList.size()){
            return null;
        }
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return null == mList ? 0 : mList.size();
    }
}
