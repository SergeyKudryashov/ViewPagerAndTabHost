package com.ss.viewpagertabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ss.viewpagertabs.fragment.AboutFragment;
import com.ss.viewpagertabs.fragment.FavoriteFragment;
import com.ss.viewpagertabs.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class PageViewFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public PageViewFragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        createFragmentsList();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    private void createFragmentsList() {
        mFragments.add(new HomeFragment());
        mFragments.add(new FavoriteFragment());
        mFragments.add(new AboutFragment());
    }
}
