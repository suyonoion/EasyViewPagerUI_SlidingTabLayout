package com.suyonoion.easystlviewpagerui;

/**
 * Created by Suyono on 6/16/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;


public class PhoneStatusBar extends Activity {

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }

    ViewPager pager;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Notifications","Profile","Others"};
    int JumlahTab =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResource("status_bar_expanded","layout"));
        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI(Titles);
        pager = (ViewPager) findViewById(setResource("pager","id"));
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        pager.setPageTransformer(true, new CubeOutTransformer());
        pager.setCurrentItem(1);
        tabs = (SlidingTabLayout) findViewById(setResource("tabs","id"));
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(pager);
    }

    public class AdapterExpandedViewpagerUI extends PagerAdapter {
        CharSequence Titles[];
        public AdapterExpandedViewpagerUI(CharSequence mTitles[]) {
            this.Titles = mTitles;
        }
        @Override
        public int getCount () {
            return JumlahTab;
        }

        @Override
        public Object instantiateItem (ViewGroup container,int position){
            int tampilkanMenurutId = 0;
            switch (position) {
                case 0:
                    tampilkanMenurutId = setResource("id_halaman_1","id");
                    break;
                case 1:
                    tampilkanMenurutId = setResource("id_halaman_2","id");
                    break;
                case 2:
                    tampilkanMenurutId = setResource("id_halaman_3","id");
                    break;
            }
            return findViewById(tampilkanMenurutId);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }

        @Override
        public Parcelable saveState () {
            return null;
        }
    }

}