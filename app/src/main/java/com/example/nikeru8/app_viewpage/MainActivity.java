package com.example.nikeru8.app_viewpage;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View view1, view2, view3;//滑動的頁面
    private ViewPager viewPager;//viewpager
    private PagerTitleStrip pagerTitleStrip;//viewpager的標題
    private PagerTabStrip pagerTabStrip;//一個viewpager的指示器，效果就是一個橫的粗下滑線
    private List<View> viewList;
    private List<String> titleList;
    private Button webio_button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

     //取消ActionBar
        getSupportActionBar().hide();
    }

    private void init() {

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);

        //橫粗下滑線 顏色
        pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.colorPrimary));

        //?
        pagerTabStrip.setDrawFullUnderline(false);

        //背景顏色
        pagerTabStrip.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        pagerTabStrip.setTextSpacing(100);


        /*精華處*/
        //設定inflater,並把view(layout)裝入inflater
        LayoutInflater lf = getLayoutInflater().from(this);

        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        view3 = lf.inflate(R.layout.layout3, null);

        //將要顯示的view裝入陣列
        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        //每個介面的Title數據
        titleList = new ArrayList<String>();
        titleList.add("page One");
        titleList.add("page Two");
        titleList.add("page Three");

        /*精華處*/
        //viewpager的  adapter轉接器 /*Important things 精華*/

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override//要使用pagerAdapter必須要有的
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override//ViewList數量
            public int getCount() {

                return viewList.size();
            }

            @Override//消滅View
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));

            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }

            @Override //Titlelist塞入
            public CharSequence getPageTitle(int position) {

                return titleList.get(position);

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));

                return viewList.get(position);
            }

        };
        viewPager.setAdapter(pagerAdapter);
    }





}
