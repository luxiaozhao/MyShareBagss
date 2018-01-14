package com.share.bag.ui.fragments.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.share.bag.Constant;
import com.share.bag.R;
import com.share.bag.base.BaseFragment;
import com.share.bag.ui.activitys.mine.LoginActivity;
import com.share.bag.ui.activitys.mine.PersonalActivity;
import com.share.bag.ui.activitys.mine.WalletActivity;
import com.share.bag.utils.SharePreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.mine_data;
/*
* 我的
* */
public class MineFragment extends BaseFragment {

    @BindView(R.id.mine_avatar)
    ImageView mineAvatar;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(mine_data)
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
    @BindView(R.id.mine_set)
    RelativeLayout mineSet;
    Unbinder unbinder;
    private Intent loginintent;

    @Override
    public int initLayout() {
        return R.layout.china_fragment;

    }

    @Override
    public void initView(View view) {


    }

    @Override
    protected void initData() {

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

    @OnClick({R.id.mine_avatar, R.id.textView3, mine_data, R.id.imageView2, R.id.home_leisurerent0, R.id.textView, R.id.mine_cabinets, R.id.imageView1, R.id.home_leisurename1, R.id.textView4, R.id.mine_shared, R.id.mine_Pay, R.id.mine_Sign, R.id.mine_ship, R.id.mine_return, R.id.textView7, R.id.mine_wallet, R.id.text2, R.id.mine_invite, R.id.text3, R.id.mine_address, R.id.text4, R.id.mine_contact, R.id.text5, R.id.mine_problem, R.id.text6, R.id.mine_Complaints, R.id.text7, R.id.mine_cooperation, R.id.text8, R.id.mine_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_avatar:
                break;
            case R.id.textView3:
                break;
            case mine_data://我的主页

                if(SharePreUtils.getString(Constant.COOKIE , "").isEmpty()){
                    //登录
                    loginintent = new Intent(getActivity(), LoginActivity.class);
                }else{
                    //个人中心
                    loginintent=new Intent(getActivity(), PersonalActivity.class);
                }
                startActivity(loginintent);

                break;
            case R.id.imageView2:

                break;
            case R.id.home_leisurerent0:
                break;
            case R.id.textView:
                break;
            case R.id.mine_cabinets:
                break;
            case R.id.imageView1:
                break;
            case R.id.home_leisurename1:
                break;
            case R.id.textView4:
                break;
            case R.id.mine_shared:
                break;
            case R.id.mine_Pay:
                break;
            case R.id.mine_Sign:
                break;
            case R.id.mine_ship:
                break;
            case R.id.mine_return:
                break;
            case R.id.textView7:
                break;
            case R.id.mine_wallet:

             startActivity(new Intent(getActivity(), WalletActivity.class));

                break;
            case R.id.text2:
                break;
            case R.id.mine_invite:
                break;
            case R.id.text3:
                break;
            case R.id.mine_address:
                break;
            case R.id.text4:
                break;
            case R.id.mine_contact:
                break;
            case R.id.text5:
                break;
            case R.id.mine_problem:
                break;
            case R.id.text6:
                break;
            case R.id.mine_Complaints:
                break;
            case R.id.text7:
                break;
            case R.id.mine_cooperation:
                break;
            case R.id.text8:
                break;
            case R.id.mine_set:
                break;
        }
    }
}
