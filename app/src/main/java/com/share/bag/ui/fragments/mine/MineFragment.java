package com.share.bag.ui.fragments.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.Constant;
import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.base.BaseFragment;
import com.share.bag.ui.activitys.mine.LoginActivity;
import com.share.bag.ui.activitys.mine.MySetActivity;
import com.share.bag.ui.activitys.mine.PersonalActivity;
import com.share.bag.ui.activitys.mine.WalletActivity;
import com.share.bag.ui.share.ShareActivity;
import com.share.bag.utils.SharePreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.mine_cabinets;
import static com.share.bag.R.id.mine_data;
/*
* 我的
* */
public class MineFragment extends BaseFragment {

    @BindView(R.id.mine_avatar)
    ImageView mineAvatar;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.mine_data)
    LinearLayout mineData;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.home_leisurerent0)
    TextView xiuRent1;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.mine_cabinets)
    RelativeLayout mineCabinets;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.home_leisurename1)
    TextView xiuName1;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.mine_shared)
    RelativeLayout mineShared;
    @BindView(R.id.mine_Pay)
    LinearLayout minePay;
    @BindView(R.id.mine_Sign)
    LinearLayout mineSign;
    @BindView(R.id.mine_ship)
    LinearLayout mineShip;
    @BindView(R.id.mine_return)
    LinearLayout mineReturn;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.mine_wallet)
    RelativeLayout mineWallet;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.mine_invite)
    RelativeLayout mineInvite;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.mine_address)
    RelativeLayout mineAddress;
    @BindView(R.id.text4)
    TextView text4;
    @BindView(R.id.mine_contact)
    RelativeLayout mineContact;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.mine_problem)
    RelativeLayout mineProblem;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.mine_Complaints)
    RelativeLayout mineComplaints;
    @BindView(R.id.text7)
    TextView text7;
    @BindView(R.id.mine_cooperation)
    RelativeLayout mineCooperation;
    @BindView(R.id.text8)
    TextView text8;
    @BindView(R.id.mine_name)
    TextView mine_name;
    @BindView(R.id.mine_set)
    RelativeLayout mineSet;
    Unbinder unbinder;
    private Intent loginintent;
    private Intent loginintent1;
    private Intent myset;
    private String s;

    @Override
    public int initLayout() {
        return R.layout.china_fragment;

    }

    @Override
    public void initView(View view) {


    }

    @Override
    protected void initData() {

        FileUtil.MinereadFromPre(getActivity(),mine_name,mineAvatar);
        if (mine_name.getText().equals("")){
            Glide.with(getContext()).load(R.mipmap.ic_launcher).into(mineAvatar);
            mine_name.setText("请登录");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&resultCode==0){

            if (data!=null){
                String name = data.getStringExtra("name");
                String img = data.getStringExtra("img");
                Glide.with(getContext()).load("http://baobaoapi.ldlchat.com"+img).into(mineAvatar);
//            Glide.with(getActivity()).load("http://baobaoapi.ldlchat.com "+img).error(R.mipmap.ic_launcher).into(mineAvatar);
                Log.e("2222222222222","http://baobaoapi.ldlchat.com "+img);
//            Toast.makeText(getContext(), "http://baobaoapi.ldlchat.com "+img, Toast.LENGTH_SHORT).show();
                mine_name.setText(name);
            }


        }
    }

    @OnClick({ R.id.mine_data,R.id.mine_cabinets,R.id.mine_wallet,R.id.mine_shared,
            R.id.mine_Pay, R.id.mine_Sign,R.id.mine_ship, R.id.mine_return,
            R.id.mine_invite, R.id.mine_address,R.id.mine_contact, R.id.mine_problem,
            R.id.mine_Complaints,R.id.mine_cooperation, R.id.mine_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case mine_data://我的主页
                s = mine_name.getText().toString();
                if (s.toString().equals("请登录")){//登录
                    loginintent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(loginintent,0);
                }else {//个人中心
                    loginintent=new Intent(getActivity(), PersonalActivity.class);
                    startActivity(loginintent);
                }

                break;
            case mine_cabinets://我的包柜
                Toast.makeText(getActivity(), "我的包柜", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_wallet://我的钱包
                if(SharePreUtils.getString(Constant.COOKIE , "").isEmpty()){
                    //登录
                    loginintent1 = new Intent(getActivity(), LoginActivity.class);
                }else{
                    //我的钱包
                    loginintent1=new Intent(getActivity(), WalletActivity.class);
                }
                startActivity(loginintent1);
                break;
            case R.id.mine_shared://正在共享
                Toast.makeText(getActivity(), "点击了正在共享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_Pay://代付款
                Toast.makeText(getActivity(), "点击了代付款", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_Sign://待签收
                Toast.makeText(getActivity(), "点击了待签收", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_ship://代发货
                Toast.makeText(getActivity(), "点击了代发货", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_return://代归还

                Toast.makeText(getActivity(), "点击了代归还", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mine_invite://邀请好友

                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } else {//分享界面
//
                    Intent rentloginintent = new Intent(getActivity(), ShareActivity.class);
                    startActivity(rentloginintent);
                }
                break;
            case R.id.mine_address://我的地址
                Toast.makeText(getActivity(), "点击了我的地址", Toast.LENGTH_SHORT).show();

                break;

            case R.id.mine_contact://联系客服
                Toast.makeText(getActivity(), "点击了联系客服", Toast.LENGTH_SHORT).show();

                break;

            case R.id.mine_problem://常见问题
                Toast.makeText(getActivity(), "点击了常见问题", Toast.LENGTH_SHORT).show();
                break;
//
            case R.id.mine_Complaints://投诉建议
                Toast.makeText(getActivity(), "点击了投诉建议", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mine_cooperation://商务合作
                Toast.makeText(getActivity(), "退出", Toast.LENGTH_SHORT).show();
                FileUtil.shanchu(getActivity());//清空
                Glide.with(getContext()).load(R.mipmap.ic_launcher).into(mineAvatar);
                 mine_name.setText("请登录");

                break;
            case R.id.mine_set://设置
                if (mine_name.getText().equals("请登录")) {//登录
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } else {//分享界面
//
                    Intent rentloginintent = new Intent(getActivity(), MySetActivity.class);
                    startActivity(rentloginintent);
                }
                break;
        }
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){

        }
    }
}
