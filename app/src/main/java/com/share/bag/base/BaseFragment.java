package com.share.bag.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 54hk on 2017/12/3.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
        initListener();
    }

    /**
     * 初始化布局
     */
    public abstract int initLayout();

    /**
     * 初始化一些的控件
     */
    public abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    protected void initListener() {

    }


    public void refreshData(){

    }

}
