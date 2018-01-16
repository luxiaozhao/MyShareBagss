package com.share.bag.ui.activitys.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.LoginBean;
import com.share.bag.entity.SMSBean;
import com.share.bag.utils.TimeCountUtils;
import com.share.bag.utils.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.share.bag.R.id.registered_obtain;
/*
* 新用户注册
*
* */
public class RegisteredActivity extends BaseActivity {

    @BindView(R.id.registered_return)
    ImageView registeredReturn;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.registered_phone)
    EditText registered_phone;
    @BindView(R.id.linearLayout6)
    LinearLayout linearLayout6;
    @BindView(R.id.registered_verification)
    EditText registeredVerification;
    @BindView(registered_obtain)
    TextView registeredObtain;
    @BindView(R.id.linearLayout7)
    LinearLayout linearLayout7;
    @BindView(R.id.registered_password)
    EditText registeredPassword;
    @BindView(R.id.linearLayout8)
    LinearLayout linearLayout8;
    @BindView(R.id.registered_login)
    Button registeredLogin;
    private Context context;
    private TimeCountUtils timeCountUtils;
//    registered_obtain
    @Override
    public int initLayout() {
        return R.layout.activity_registered2;

    }

    @Override
    public void initView() {
        context = RegisteredActivity.this;

    }

    @Override
    protected void initData() {
//        初始化 倒计时
//        timeCountUtils = new TimeCountUtils(60000,1000,registeredObtain);
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

    @OnClick({R.id.registered_return, R.id.relativeLayout, R.id.registered_phone, R.id.linearLayout6, R.id.registered_verification, registered_obtain, R.id.linearLayout7, R.id.registered_password, R.id.linearLayout8, R.id.registered_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.registered_return://返回
                finish();
                break;
            case registered_obtain://获取验证码
//                timeCountUtils.start();
                goSMS();
                break;
            case R.id.registered_login://注册登录
                goRegistered();
                break;
        }
    }

    // 获取验证码
    private void goSMS() {
        Map<String, String> map = new HashMap<>();
        String phoneNumber = registered_phone.getText().toString().trim();
        if (phoneNumber!=null&&phoneNumber.length()>0&&phoneNumber.length()<=11){
            map.put("username", registered_phone.getText().toString().trim());
            OkHttpUtils.getInstance().post(SBUrls.SMSURL, map, new MyNetWorkCallback<SMSBean>() {
            @Override
            public void onSuccess(SMSBean loginBean) {
//                TODO ---------- Message
                Toast.makeText(context, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(context, "失败"+errorMsg.toString()+errorCode, Toast.LENGTH_SHORT).show();
                Log.e("TAG",errorMsg.toString()+errorCode);
//                ToastUtils.show(context, context.getClass().getSimpleName() + errorMsg);
            }
        });
        }else {
            Toast.makeText(RegisteredActivity.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
        }
    }

    //  注册--登录
    private void goRegistered() {
        Map<String, String> map = new HashMap<>();
        map.put("username", registered_phone.getText().toString().trim());
        map.put("code", registeredVerification.getText().toString().trim());
        map.put("password", registeredPassword.getText().toString().trim());
//        username   用户名    password 密码     code手机验证码
        OkHttpUtils.getInstance().post(SBUrls.REGISTEREDURL, map, new MyNetWorkCallback<LoginBean>() {

            @Override
            public void onSuccess(LoginBean loginBean) {
                Log.e("TGA",loginBean.getStatus()+loginBean.getInfo());
                Toast.makeText(context, loginBean.getStatus()+"-------"+loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                if(loginBean.getStatus().equals("0")){
                    Toast.makeText(RegisteredActivity.this,loginBean.getInfo(),Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(RegisteredActivity.this, LoginActivity.class));
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                ToastUtils.show(context, context.getClass().getSimpleName() + errorMsg);
            }
        });
    }

}
