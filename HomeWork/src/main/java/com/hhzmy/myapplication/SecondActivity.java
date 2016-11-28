package com.hhzmy.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private List<TextView> tvlist;
    private List<Fragment> flist;
    private String[] name=new String[]{"舍内要闻","本社介绍","履行职能","自身建设","社员风采","历史回眸"};
    private HorizontalScrollView horizontalScrollView;
    private int width;
    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private FragmentManager fm;
    private String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.hsv);
        linearLayout = (LinearLayout) findViewById(R.id.ll);

        fm = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //viewpager监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                //当前显示textview页
                TextView textView1 = tvlist.get(arg0);
                for (int i = 0; i < tvlist.size(); i++) {
                    //将当前显示的textview放到中间
                    TextView text=tvlist.get(arg0);
                    int k = text.getMeasuredWidth();
                    int l = text.getLeft();
                    int s = k / 2 + l - width / 2;
                    horizontalScrollView.smoothScrollTo(s, 0);
				//得到所有textview
				TextView t = tvlist.get(i);
				//给当前显示页面的textview页变色
                if (!t.equals(textView1)) {

                    t.setTextColor(Color.BLACK);
                } else {
                    t.setTextColor(Color.BLUE);
                }
            }
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
        //获取屏幕的宽度
        width=getWindowManager().getDefaultDisplay().getWidth();
        //加载viewpager的页面
        setData();
        viewPager.setAdapter(new MyAdapter(fm,flist));
        //导航
        upTextView();
    }
    private void setData() {
        flist=new ArrayList<Fragment>();
        for (int i = 0; i <name.length; i++) {
            MyFragment fragment=new MyFragment(name[i]);
            flist.add(fragment);
        }
    }
    private void upTextView() {
        // TODO Auto-generated method stub
        tvlist=new ArrayList<TextView>();
        for (int i = 0; i < name.length; i++) {
            //每个textview的宽度
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(width/4, ViewPager.LayoutParams.WRAP_CONTENT);

            final TextView tv=new TextView(this);
            tv.setPadding(20, 20, 20, 20);
            tv.setText(name[i]);
            //添加集合
            tvlist.add(tv);
            //绑定
            tv.setTag(i);
            //加到布局中
            linearLayout.addView(tv, i, params);
            //textview监听  点到那的滑动页
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int textview=(Integer) tv.getTag();
                    viewPager.setCurrentItem(textview);
                }
            });
        }

    }

}