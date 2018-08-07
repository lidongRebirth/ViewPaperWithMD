package com.example.asustp.viewpagerdemo02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;

    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    private Fragment3 fragment3 = null;
    private Fragment4 fragment4 = null;



    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

    }

//-------------------------------------------------------------
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    /**
     *     将给定位置的view添加到ViewGroup(容器)中,创建并显示出来
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
    //------------------------------------------
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case MainActivity.PAGE_ONE:
            fragment = fragment1;
            break;
            case MainActivity.PAGE_TWO:
                fragment = fragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = fragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = fragment4;
                break;
        }
        return fragment;

    }


}
