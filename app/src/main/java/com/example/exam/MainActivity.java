package com.example.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.exam.fragment.FenLeiFragment;
import com.example.exam.fragment.MeFragment;
import com.example.exam.fragment.MySelfFragment;
import com.example.exam.fragment.ShopCarFragment;
import com.example.exam.fragment.ShouYeFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fragment)
    BottomTabBar fragment;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        fragment.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.home, ShouYeFragment.class)
                .addTabItem("觅Me",R.drawable.circle, FenLeiFragment.class)
                .addTabItem("购物车",R.drawable.shop,MeFragment.class)
                .addTabItem("分类",R.drawable.list, ShopCarFragment.class)
                .addTabItem("我的",R.drawable.my, MySelfFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }
                });

    }
}
