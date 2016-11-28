package com.hhzmy.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by a on 2016/11/11.
 */
public class MyAdapter extends FragmentPagerAdapter{
    private List<Fragment> flist;

    public MyAdapter(FragmentManager fm,List<Fragment> flist) {
        super(fm);
        this.flist=flist;
        // TODO Auto-generated constructor stub
    }
//    private List<Data.DataBean> list;
//    public MyAdapter(List<Data.DataBean> list) {
//        super((FragmentManager) list);
//
//
//    }

    @Override
    public Fragment getItem(int position) {

        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }
}
