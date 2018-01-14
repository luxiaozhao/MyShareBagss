package com.share.bag.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.share.bag.APP;
import com.share.bag.R;
import com.share.bag.utils.StatusBarUtil;


/**
 * Created by 54hk on 2017/12/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        APP.context = this;

        if (Build.VERSION.SDK_INT > 22) {
            if (hodeWindow()) {
                StatusBarUtil.setTranslucent(this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtil.setStatusBarDarkMode(this);
                    //  改变状态栏的颜色
                    StatusBarUtil.setColor(this, getResources().getColor(R.color.color_00BADB), 0);
                    StatusBarUtil.setStatusBarLightMode(this.getWindow());
                }
            }
        }

        setContentView(initLayout());
        initView();
        initData();
        init();
        initListener();

    }

    /**
     * 初始化布局
     */
    public abstract int initLayout();
    /**
     * 初始化一些的控件
     */
    public abstract void initView();
    /**
     * 初始化数据
     */
    protected abstract void initData();
    /**
     * 沉浸式状态栏
     */
    protected abstract boolean hodeWindow();

    public void initListener() {
    }

    public void init() {
    }

}
