package com.honam.kyyeto.hfarmers.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.honam.kyyeto.hfarmers.Fragment.HomeFragment;
import com.honam.kyyeto.hfarmers.Fragment.StoreFragment;
import com.honam.kyyeto.hfarmers.Fragment.StoryFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public FragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new StoryFragment();
            case 2:
                return new StoreFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}