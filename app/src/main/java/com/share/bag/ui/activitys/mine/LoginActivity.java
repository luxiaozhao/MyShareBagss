package com.share.bag.ui.activitys.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.LoginBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
* 登录界面
* */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.linearLayout4)
    LinearLayout linearLayout4;
    @BindView(R.id.login_login)
    Button loginLogin;
    @BindView(R.id.login_registered)
    TextView loginRegistered;
    @BindView(R.id.login_forget)
    TextView loginForget;
    @BindView(R.id.linearLayout5)
    LinearLayout linearLayout5;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_weixin)
    ImageView loginWeixin;

    @Override
    public int initLayout() {
        return R.layout.activity_login2;

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

    @OnClick({R.id.imageView6, R.id.login_phone, R.id.linearLayout3, R.id.login_password, R.id.linearLayout4, R.id.login_login, R.id.login_registered, R.id.login_forget, R.id.linearLayout5, R.id.login_qq, R.id.login_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_login://登录
               goLogin();
                break;
            case R.id.login_registered://注册
                Intent intent=new Intent(LoginActivity.this,RegisteredActivity.class);
                startActivity(intent);
                break;
            case R.id.login_forget://忘记密码
                break;
            case R.id.login_qq://QQ登录
                Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();

//                UMShareAPI umShareAPI = UMShareAPI.get(LoginActivity.this);
//                umShareAPI.doOauthVerify(LoginActivity.this , SHARE_MEDIA.QQ , shareList);
                break;
            case R.id.login_weixin://微信登录
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void goLogin() {
        Map<String, String> map = new HashMap<>();
        map.put("username", loginPhone.getText().toString().trim());
        map.put("password", loginPassword.getText().toString().trim());
        map.put("type", "3");
        OkHttpUtils.getInstance().post(SBUrls.LOGINURL, map, new MyNetWorkCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {

                String info = loginBean.getStatus();

                if (info.equals("1")){
                    Toast.makeText(LoginActivity.this, "登录成功"+loginBean.getMsg().getUsername(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this, MineFragment.class));
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, loginBean.getInfo(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

/*
            @Override
            public void onSuccess(LoginBean loginBean) {
//                SharePreUtils.setString(SBUrls.TOKEN,"");
//                SharePreUtils.getString(SBUrls.TOKEN,"")
                Toast.makeText(LoginActivity.this, loginBean.getInfo()+"--"+loginBean.getStatus(), Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });*/

    }

    private UMAuthListener shareList = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
//            Toast.makeText(LoginActivity.this, "开始", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//            Toast.makeText(LoginActivity.this, "成功", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//            Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };


}
