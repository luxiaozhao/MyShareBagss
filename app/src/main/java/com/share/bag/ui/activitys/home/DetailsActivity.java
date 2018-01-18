package com.share.bag.ui.activitys.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.adapter.CosTomPageAdapter;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.CollectionBean;
import com.share.bag.entity.DeailsBean;
import com.share.bag.ui.activitys.mine.LoginActivity;
import com.share.bag.ui.fragments.page.CommentsFragment;
import com.share.bag.ui.fragments.page.DetalisFragment;
import com.share.bag.ui.pay.BuyActivity;
import com.share.bag.ui.pay.RentActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhouwei.mzbanner.CustomViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.Details_return)
    ImageView DetailsReturn;
    @BindView(R.id.Details_shared)
    ImageView DetailsShared;
    @BindView(R.id.tab)
    TabLayout tab;

    @BindView(R.id.Details_banner)
    Banner DetailsBanner;
    @BindView(R.id.pager)
    CustomViewPager pager;
    @BindView(R.id.details_button_collection)
    Button detailsButtonCollection;
    @BindView(R.id.details_button_rent)
    Button detailsButtonRent;
    @BindView(R.id.details_button_buy)
    Button detailsButtonBuy;
    @BindView(R.id.details__user)
    TextView details__user;

    private String tmp;
    //             Banner   List
    private List<String> heardimg = new ArrayList<>();
    //             review  Number
    int NUM = 0;

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();

    private String DETAILS = "详情";
    private String COMMENTS = "评论";

    private CosTomPageAdapter mCosTomPageAdapter;

    private FragmentManager fragmentManager;

    @Override
//    Details_return
    public int initLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        //      得到传过来的ID  通过id来取值
        tmp = intent.getStringExtra("details");
        Log.e("sss", "initView: " + tmp);
        fragmentManager = getSupportFragmentManager();

    }

    @Override
    protected void initData() {

        Map<String, String> map = new HashMap<>();
        map.put("id", tmp);
        //请求网络
        OkHttpUtils.getInstance().post(SBUrls.DETAILSURL, map, new MyNetWorkCallback<DeailsBean>() {
            @Override
            public void onSuccess(DeailsBean deailsBean) {
                List<String> img = deailsBean.getImg();

                for (int i = 0; i < img.size(); i++) {
                    String s = "http://" + img.get(i);
                    heardimg.add(s);
                }

                //         BannerHeader Show
                bannerHeaderShow();
                TabPageShow();

            }

            private void TabPageShow() {

                //           Voluation  Tab
                tab.addTab(tab.newTab().setText(DETAILS));
                tab.addTab(tab.newTab().setText(COMMENTS + "(+" + NUM + "+)"));

                stringList.add(DETAILS);
                stringList.add(COMMENTS);


                //     Add  Fragment  to fragmentList.
                fragmentList.add(new DetalisFragment());
                fragmentList.add(new CommentsFragment());

                //     Associate ViewPage and Fragment

                tab.setupWithViewPager(pager);

                //        Show  Adapter
                mCosTomPageAdapter = new CosTomPageAdapter(fragmentManager, stringList, fragmentList);
                pager.setAdapter(mCosTomPageAdapter);
                pager.setCurrentItem(0);
                pager.setCurrentItem(1);

            }

            private void bannerHeaderShow() {

                DetailsBanner.setImages(heardimg)//添加图片集合或图片url集合
                        .setDelayTime(2000)//设置轮播时间
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                        .setImageLoader(new GlideImage())//加载图片
                        .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                        .start();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(DetailsActivity.this, "Request unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @OnClick(R.id.Details_return)
    public void onViewClicked() {
        finish();
    }

    @OnClick({R.id.details_button_collection, R.id.details_button_rent, R.id.details_button_buy})
    public void onViewClicked(View view) {
        FileUtil.SelectedreadFromPre(DetailsActivity.this,details__user);
        switch (view.getId()) {
            case R.id.details_button_collection:
//                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                if (details__user.getText().equals("")){
                    Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    getselect();
                }
                break;
            case R.id.details_button_rent://租下
                if (details__user.getText().equals("")){
//                    Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DetailsActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Intent rentloginintent = new Intent(DetailsActivity.this, RentActivity.class);
                    startActivity(rentloginintent);
                }
                break;
            case R.id.details_button_buy://买下

                if (details__user.getText().equals("")){
//                    Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DetailsActivity.this,LoginActivity.class);
                    startActivity(intent);


                }else {

                    Intent rentloginintent = new Intent(DetailsActivity.this, BuyActivity.class);
                    startActivity(rentloginintent);
                }

                break;
        }
    }

    //点击收藏
    public void getselect() {

        Map<String ,String> collection=new HashMap();
        collection.put("baglist_id","1");
        OkHttpUtils.getInstance().post(SBUrls.COLLECTION, collection, new MyNetWorkCallback<CollectionBean>() {
            @Override
            public void onSuccess(CollectionBean collectionBean) {
                String status = collectionBean.getInfo();
                if (status.toString().equals("收藏成功")){

                    Toast.makeText(DetailsActivity.this, ""+status, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(DetailsActivity.this, ""+status, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }


    //                      Banner Volder
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}



