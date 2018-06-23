package com.ss.viewpagertabs;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.ss.viewpagertabs.adapter.PageViewFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private final String TAG1 = "home";
    private final String TAG2 = "favorite";
    private final String TAG3 = "about";

    private ViewPager mViewPager;
    private TabHost mTabHost;
    private Drawable bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = findViewById(R.id.tab_host_main);
        mViewPager = findViewById(R.id.view_pager_main);

        createTabHost();

        mViewPager.setAdapter(new PageViewFragmentAdapter(getSupportFragmentManager()));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position;
                switch (tabId) {
                    case TAG1:
                        position = 0;
                        changeTabColor(position);
                        break;
                    case TAG2:
                        position = 1;
                        changeTabColor(position);
                        break;
                    case TAG3:
                        position = 2;
                        changeTabColor(position);
                        break;
                    default:
                        throw new IllegalArgumentException("Tag not founded");
                }
                mViewPager.setCurrentItem(position);
            }
        });
    }

    private void createTabHost() {
        mTabHost.setup();

        TabHost.TabSpec tabSpec = mTabHost.newTabSpec(TAG1);
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator(getString(R.string.tab_home));
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec(TAG2);
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator(getString(R.string.tab_favorite));
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec(TAG3);
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator(getString(R.string.tab_about));
        mTabHost.addTab(tabSpec);

        mTabHost.getTabWidget().getChildTabViewAt(0).setBackgroundColor(getResources().getColor(R.color.colorAccent));
        ((TextView) ((ViewGroup) mTabHost.getTabWidget().getChildTabViewAt(0)).getChildAt(1))
                .setTextColor(getResources().getColor(android.R.color.white));
    }

    private void changeTabColor(int position) {
        mTabHost.getTabWidget().getChildTabViewAt(position)
                .setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mTabHost.getTabWidget().getChildTabViewAt((position + 1) % 3)
                .setBackgroundColor(getResources().getColor(android.R.color.transparent));
        mTabHost.getTabWidget().getChildTabViewAt((position + 2) % 3)
                .setBackgroundColor(getResources().getColor(android.R.color.transparent));

        ((TextView) ((ViewGroup) mTabHost.getTabWidget().getChildTabViewAt(position)).getChildAt(1))
                .setTextColor(getResources().getColor(android.R.color.white));
        ((TextView) ((ViewGroup) mTabHost.getTabWidget().getChildTabViewAt((position + 1) % 3)).getChildAt(1))
                .setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
        ((TextView) ((ViewGroup) mTabHost.getTabWidget().getChildTabViewAt((position + 2) % 3)).getChildAt(1))
                .setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
    }
}
