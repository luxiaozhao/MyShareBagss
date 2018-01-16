package com.share.bag.ui.activitys.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 修改手机号
* */
public class PhoneActivity extends BaseActivity {
    @BindView(R.id.phone_return)
    ImageView phoneReturn;
    @BindView(R.id.phone_confirm)
    Button phoneConfirm;
    @BindView(R.id.phone_phone)
    EditText phone_phone;
    @BindView(R.id.phonre_verification)
    EditText phonre_verification;
    @Override
    public int initLayout() {
        return R.layout.activity_phone;
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

    @OnClick({R.id.phone_return, R.id.phone_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_return:
                finish();
                break;
            case R.id.phone_confirm://确认
                submit_phone();

                break;
        }
    }

    private void submit_phone() {
        // validate
        String edittextString = phone_phone.getText().toString().trim();
        if (TextUtils.isEmpty(edittextString)) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String  verification= phonre_verification.getText().toString().trim();
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something


    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phone);
//    }
}
