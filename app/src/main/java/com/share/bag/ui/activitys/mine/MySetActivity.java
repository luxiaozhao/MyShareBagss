package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 设置
* */
public class MySetActivity extends BaseActivity {
    @BindView(R.id.myset_return)
    ImageView mysetReturn;
    @BindView(R.id.myset_safety)
    RelativeLayout mysetSafety;
    @BindView(R.id.myset_updated)
    RelativeLayout mysetUpdated;
    @BindView(R.id.myset_clear)
    RelativeLayout mysetClear;
    @BindView(R.id.myset_on)
    RelativeLayout mysetOn;
    @BindView(R.id.myset_dropout)
    Button mysetDropout;

    @Override
    public int initLayout() {
        return R.layout.activity_my_set;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.myset_return,  R.id.myset_safety, R.id.myset_updated, R.id.myset_clear, R.id.myset_on, R.id.myset_dropout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myset_return:
                finish();
                break;
            case R.id.myset_safety:
                Toast.makeText(MySetActivity.this, "帐号安全", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myset_updated:
                Toast.makeText(MySetActivity.this, "版本更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myset_clear:
                Toast.makeText(MySetActivity.this, "清除缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myset_on:
                Toast.makeText(MySetActivity.this, "关于共享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myset_dropout:
                Toast.makeText(MySetActivity.this, "确认退出", Toast.LENGTH_SHORT).show();
                FileUtil.shanchu(MySetActivity.this);//清空

//                Intent intent=new Intent();
//                intent.setClass(LoginActivity.this, MainActivity.class);
//                String name= (String) loginBean.getMsg().getName();
//                intent.putExtra("name",name);
//                String img= (String) loginBean.getMsg().getIconurl();
//                intent.putExtra("img",img);
//                setResult(0,intent);
                finish();


//                Glide.with(MySetActivity.this).load(R.mipmap.ic_launcher).into(mineAvatar);
//                mine_name.setText("请登录");

                break;
        }
    }

}
