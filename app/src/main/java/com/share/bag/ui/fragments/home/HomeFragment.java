package com.share.bag.ui.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.HomeFragmentBean;
import com.share.bag.ui.activitys.collection.TalentActivity;
import com.share.bag.ui.activitys.home.DetailsActivity;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.brand_img1;

/**
 * Created by Administrator on 2017/11/14.
 */
/*
* 首页
* */
public class HomeFragment extends BaseFragment {


    Unbinder unbinder;

    @BindView(R.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R.id.home_scrollview)
    ScrollView home_scrollview;


    //品牌专区
    @BindView(R.id.home_brandimg1)
    ImageView homeBrandimg1;
    @BindView(R.id.home_brandname1)
    TextView homeBrandname1;
    @BindView(R.id.brand_img1)
    RelativeLayout brandImg1;
    @BindView(R.id.home_brandimg2)
    ImageView homeBrandimg2;
    @BindView(R.id.home_brandname2)
    TextView homeBrandname2;
    @BindView(R.id.brand_img2)
    RelativeLayout brandImg2;
    @BindView(R.id.home_brandimg3)
    ImageView homeBrandimg3;
    @BindView(R.id.home_brandname3)
    TextView homeBrandname3;
    @BindView(R.id.brand_img3)
    RelativeLayout brandImg3;


//    @BindView(R.id.home_leisurename1)
//    TextView homeLeisurename1;
//    @BindView(R.id.home_leisurerent0)
//    TextView homeLeisurerent0;
//    @BindView(R.id.home_leisureoriginalH)
//    TextView home_leisureoriginalH;


    //每日精选——休闲度假

    @BindView(R.id.Relaxation1)
    TextView Relaxation1;
    @BindView(R.id.home_leisureoriginal2)
    TextView homeLeisureoriginal2;
    @BindView(R.id.home_leisure_img1)
    RelativeLayout home_leisure_img1;
    @BindView(R.id.home_leisure_img2)
    RelativeLayout home_leisure_img2;
    @BindView(R.id.home_leisure_img3)
    RelativeLayout home_leisure_img3;
    @BindView(R.id.home_leisureoriginal3)
    TextView homeLeisureoriginal3;
    @BindView(R.id.home_leisureoriginal1)
    TextView homeLeisureoriginal1;
    @BindView(R.id.home_leisureimg1)
    ImageView homeLeisureimg1;
    @BindView(R.id.home_leisurerent1)
    TextView homeLeisurerent1;
    @BindView(R.id.home_leisureimg2)
    ImageView homeLeisureimg2;
    @BindView(R.id.home_leisurerent2)
    TextView homeLeisurerent2;
    @BindView(R.id.home_leisureimg3)
    ImageView homeLeisureimg3;

    @BindView(R.id.home_leisurerent01111)
    TextView home_leisurerent01111;

    //每日精选——宴会轻奢
    @BindView(R.id.mFestname)
    TextView mFestname;
    @BindView(R.id.xiu_rent4)
    TextView xiuRent4;
    @BindView(R.id.xiu_original4)
    TextView xiuOriginal4;
    @BindView(R.id.mFestimg4)
    ImageView mFestimg4;
    @BindView(R.id.home_leisureoriginaJ)
    TextView home_leisureoriginaJ;
    @BindView(R.id.home_leisureoriginalH)
    TextView homeLeisureoriginalH;
    @BindView(R.id.mFerragename)
    TextView mFerragename;
    @BindView(R.id.mFestimg1)
    ImageView mFestimg1;
    @BindView(R.id.mFestimg2)
    ImageView mFestimg2;
    @BindView(R.id.mFestimg3)
    ImageView mFestimg3;
    @BindView(R.id.textView1111)
    TextView textView1111;
    @BindView(R.id.textView2222)
    TextView textView2222;
    @BindView(R.id.home_leisurename3)
    TextView homeLeisurename3;
    @BindView(R.id.home_leisurerent3)
    TextView homeLeisurerent3;
    @BindView(R.id.xiu_name4)
    TextView xiuName4;

    //每日精选——商务办公
    @BindView(R.id.mBusinessname)
    TextView mBusinessname;
    @BindView(R.id.bussnies_name5)
    TextView bussniesName5;
    @BindView(R.id.bussnies_name6)
    TextView bussniesName6;
    @BindView(R.id.bussnies_name7)
    TextView bussniesName7;
    @BindView(R.id.bussnies_name8)
    TextView bussniesName8;
    @BindView(R.id.bussnies_name)
    TextView bussniesName;
    @BindView(R.id.bussnies_name2)
    TextView bussniesName2;
    @BindView(R.id.bussnies_name3)
    TextView bussniesName3;
    @BindView(R.id.bussnies_name4)
    TextView bussniesName4;
    @BindView(R.id.mBuss_img1)
    ImageView mBuss_img1;
    @BindView(R.id.mBuss_img2)
    ImageView mBuss_img2;
    @BindView(R.id.mBuss_img3)
    ImageView mBuss_img3;
    @BindView(R.id.mBuss_img4)
    ImageView mBuss_img4;
    @BindView(R.id.home_leisurename2)
    TextView homeLeisurename2;
    //包包达人
    @BindView(R.id.mLinearBaoBao)
    LinearLayout mLinearBaoBao;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;



    //社会轻宴
    @BindView(R.id.home_banquet_img1)
    RelativeLayout home_banquet_img1;

    @BindView(R.id.home_banquet_img2)
    RelativeLayout home_banquet_img2;

    @BindView(R.id.home_banquet_img3)
    RelativeLayout home_banquet_img3;

    @BindView(R.id.home_banquet_img4)
    RelativeLayout home_banquet_img4;

    //商务办公  R.id.home_business_img4
    @BindView(R.id.home_business_img1)
    RelativeLayout home_business_img1;


    @BindView(R.id.home_business_img2)
    RelativeLayout home_business_img2;


    @BindView(R.id.home_business_img3)
    RelativeLayout home_business_img3;

    @BindView(R.id.home_business_img4)
    RelativeLayout home_business_img4;


    //分享图片
    @BindView(R.id.home_share)
    ImageView homeShare;





    private Context context;

    private MZBannerView mzBannerView;

    private List<HomeFragmentBean.HeaderimgBean> headerimg;

    private String homeBrandimg1id1, homeBrandimg1id2, homeBrandimg1id3;

    @Override
    public int initLayout() {
        return R.layout.home_fragment;
//        brand_img1
    }

    @Override
    public void initView(View view) {
        context = getActivity().getApplicationContext();
//        context
        mzBannerView = view.findViewById(R.id.first_vp);
//        homeBrandimg1


    }



        @Override
    protected void initData() {

        headerimg = new ArrayList<>();
        final Map<String, String> map = new HashMap<>();
        OkHttpUtils.getInstance().post(SBUrls.HOMEURL, map, new MyNetWorkCallback<HomeFragmentBean>() {
            @Override
            public void onSuccess(HomeFragmentBean homeFragmentBean) {

                headerimg.addAll(homeFragmentBean.getHeaderimg());

                for (int i = 0; i < homeFragmentBean.getList().size(); i++) {

                    HomeFragmentBean.ListBean listBean = homeFragmentBean.getList().get(i);

                    if (listBean != null) {
                        forEashs(homeFragmentBean, i, listBean);
                    }

                }



                //                  轮播图赋值
                mzBannerView.setPages(headerimg, new MZHolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });


                List<HomeFragmentBean.ListBean.ChildBean> child = homeFragmentBean.getList().get(1).get_child();

                for (int i = 0; i < child.size(); i++) {
//                      休闲假日
//                     休闲假日文字
                    String title = child.get(0).getTitle();
//                     宴会轻奢文字
                    String title2 = child.get(1).getTitle();

                    Relaxation1.setText(title);
                    mFestname.setText(title2);

                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks = child.get(0).getBagthinks();
                    for (int j = 0; j < bagthinks.size(); j++) {
//                        Log.e("TAG======",bagthinks.get(j).getId());
                        String img1 = bagthinks.get(0).getImg();
                        String img2 = bagthinks.get(1).getImg();
                        String img3 = bagthinks.get(2).getImg();
//                       休闲假日里面的所有图片
                        Glide.with(context).load(img1).into(homeLeisureimg1);
                        Glide.with(context).load(img2).into(homeLeisureimg2);
                        Glide.with(context).load(img3).into(homeLeisureimg3);

//                        休闲假日里面的Money和Days

                        //days
                        String days1 = bagthinks.get(0).getDays();
                        String days2 = bagthinks.get(1).getDays();
                        String days3 = bagthinks.get(2).getDays();


                        //moneys
                        String money1 = bagthinks.get(0).getDays_money();
                        String money2 = bagthinks.get(1).getDays_money();
                        String money3 = bagthinks.get(2).getDays_money();

                        //original Money

                        String original1 = bagthinks.get(0).getOriginalprice();
                        String original2 = bagthinks.get(1).getOriginalprice();
                        String original3 = bagthinks.get(2).getOriginalprice();


                        homeLeisurerent1.setText("￥" + money1 + "/" + days1 + "天");
                        homeLeisurerent2.setText("￥" + money2 + "/" + days2 + "天");
                        homeLeisurerent3.setText("￥" + money3 + "/" + days3 + "天");


                        homeLeisureoriginal1.setText("原价" + original1);
                        homeLeisureoriginal2.setText("原价" + original2);
                        homeLeisureoriginal3.setText("原价" + original3);

                    }
                    //             宴会轻奢信息
                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks1 = child.get(1).getBagthinks();
                    for (int j = 0; j < bagthinks1.size(); j++) {
                        String title1 = bagthinks1.get(0).getTitle();
//                        Log.e("TAG_Title---------", title1);

                        //         宴会轻奢 Days with Money;

                        String days = bagthinks1.get(0).getDays();
//                        Log.e("TAG_Title---------0", days);
                        String days1 = bagthinks1.get(1).getDays();
//                        Log.e("TAG_Title---------1", days1);
                        String days2 = bagthinks1.get(2).getDays();
//                        Log.e("TAG_Title---------2", days2);
                        String days3 = bagthinks1.get(3).getDays();
//                        Log.e("TAG_Title---------3", days3);

                        String days_money = bagthinks1.get(0).getDays_money();
                        String days_money1 = bagthinks1.get(1).getDays_money();
                        String days_money2 = bagthinks1.get(2).getDays_money();
                        String days_money3 = bagthinks1.get(3).getDays_money();

                        //original Money

                        String originalprice = bagthinks1.get(0).getOriginalprice();
                        String originalprice1 = bagthinks1.get(1).getOriginalprice();
                        String originalprice2 = bagthinks1.get(2).getOriginalprice();
                        String originalprice3 = bagthinks1.get(3).getOriginalprice();

                        //feast Img

                        String img = bagthinks1.get(0).getImg();
                        String img1 = bagthinks1.get(1).getImg();
                        String img2 = bagthinks1.get(2).getImg();
                        String img3 = bagthinks1.get(3).getImg();

                        Glide.with(context).load(img).into(mFestimg1);
                        Glide.with(context).load(img1).into(mFestimg2);
                        Glide.with(context).load(img2).into(mFestimg3);
                        Glide.with(context).load(img3).into(mFestimg4);

                        homeLeisureoriginalH.setText("原价" + originalprice);
                        xiuOriginal4.setText("原价" + originalprice1);
                        home_leisureoriginaJ.setText("原价" + originalprice2);
                        mFerragename.setText("原价" + originalprice3);


                        home_leisurerent01111.setText("￥"+days_money+"/"+days);
                        homeLeisurerent1.setText("￥" + days_money1 + "/" + days1);
                        homeLeisurerent2.setText("￥" + days_money2 + "/" + days2);
                        homeLeisurerent3.setText("￥" + days_money3 + "/" + days3);


                    }

                    //                 商务办公信息

                    //             Business       Header
                    String title1 = child.get(2).getTitle();
//                    Log.e("TAG", title1);
                    mBusinessname.setText(title1);

                    List<HomeFragmentBean.ListBean.ChildBean.BagthinksBeanX> bagthinks2 = child.get(2).getBagthinks();
                    //            Business   image  and  Money  with days
                    for (int j = 0; j < bagthinks2.size(); j++) {

                        String img = bagthinks2.get(0).getImg();
                        String img1 = bagthinks2.get(1).getImg();
                        String img2 = bagthinks2.get(2).getImg();
                        String img3 = bagthinks2.get(3).getImg();

                        String days = bagthinks2.get(0).getDays();
                        String days1 = bagthinks2.get(1).getDays();
                        String days2 = bagthinks2.get(2).getDays();
                        String days3 = bagthinks2.get(3).getDays();

                        String days_money = bagthinks2.get(0).getDays_money();
                        String days_money1 = bagthinks2.get(1).getDays_money();
                        String days_money2 = bagthinks2.get(2).getDays_money();
                        String days_money3 = bagthinks2.get(3).getDays_money();

                        String originalprice = bagthinks2.get(0).getOriginalprice();
                        String originalprice1 = bagthinks2.get(1).getOriginalprice();
                        String originalprice2 = bagthinks2.get(2).getOriginalprice();
                        String originalprice3 = bagthinks2.get(3).getOriginalprice();

                        //                        achieve

                        Glide.with(context).load(img).into(mBuss_img1);
                        Glide.with(context).load(img1).into(mBuss_img2);
                        Glide.with(context).load(img2).into(mBuss_img3);
                        Glide.with(context).load(img3).into(mBuss_img4);


                        bussniesName.setText("￥" + days_money + "/" + days);
                        bussniesName3.setText("￥" + days_money1 + "/" + days1);
                        bussniesName5.setText("￥" + days_money2 + "/" + days2);
                        bussniesName7.setText("￥" + days_money3 + "/" + days3);


                        bussniesName2.setText("原价" + originalprice);
                        bussniesName4.setText("原价" + originalprice1);
                        bussniesName6.setText("原价" + originalprice2);
                        bussniesName8.setText("原价" + originalprice3);
                    }
                }

                homeBrandimg1id1 = homeFragmentBean.getList().get(0).getBagthinks().get(0).getId();

                homeBrandimg1id2 = homeFragmentBean.getList().get(0).getBagthinks().get(1).getId();

                homeBrandimg1id3 = homeFragmentBean.getList().get(0).getBagthinks().get(2).getId();

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });


//        getmonitor();
    }

    private void forEashs(HomeFragmentBean homeFragmentBean, int i, HomeFragmentBean.ListBean listBean) {
        for (int j = 0; j < listBean.getBagthinks().size(); j++) {
            HomeFragmentBean.ListBean.BagthinksBean bagthinksBean = listBean.getBagthinks().get(j);
            String id = bagthinksBean.getId();
            String id2= bagthinksBean.getId();
            String id3 = bagthinksBean.getId();

//            http://baobaoapi.ldlchat.com/Uploads/20180106/5a5069d43caaa.png,/Uploads/20180106/5a5069fc9c6af.png"

            //这个是第一个的所有图片
            String img1 = bagthinksBean.getImg();
            String img2 = bagthinksBean.getImg();
            String img3 = bagthinksBean.getImg();

            Glide.with(HomeFragment.this).load(img1).into(homeBrandimg1);//品牌专区1
            Glide.with(HomeFragment.this).load(img2).into(homeBrandimg2);//品牌专区2
            Glide.with(HomeFragment.this).load(img3).into(homeBrandimg3);//品牌专区3


        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        //设置banner
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
//             轮播图 监听
//                ToastUtils.show(APP.context, "wo是" + position);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();
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


    @OnClick({brand_img1, R.id.brand_img2, R.id.brand_img3,R.id.home_leisure_img1,R.id.home_leisure_img2,R.id.home_leisure_img3,
            R.id.home_banquet_img1,R.id.home_banquet_img2,R.id.home_banquet_img3,R.id.home_banquet_img4,
            R.id.home_business_img1,R.id.home_business_img2,R.id.home_business_img3,R.id.home_business_img4
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case brand_img1://品牌专区图片1 
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(context, DetailsActivity.class);

                intent1.putExtra("details", homeBrandimg1id2);
                startActivity(intent1);
//                Log.e("TAG","---------"+homeBrandimg1id);

//                Intent intent1 = new Intent(context, DetailsActivity.class);
//
//                intent1.putExtra("details", homeBrandimg1id1);
//
////                Log.e("sss", "initView: " + homeBrandimg1id1);
//
//                startActivity(intent1);

                break;
            case R.id.brand_img2://品牌专区图片2
                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, DetailsActivity.class);

                intent2.putExtra("details", homeBrandimg1id2);

//                Log.e("sss", "initView: " + homeBrandimg1id2);

                startActivity(intent2);
                break;
            case R.id.brand_img3://品牌专区图片3
                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(context, DetailsActivity.class);

                intent3.putExtra("details", homeBrandimg1id3);

//                Log.e("sss", "initView: " + homeBrandimg1id3);

                startActivity(intent3);
                break;

//           每日精选——休闲度假
            case R.id.home_leisure_img1://休闲度假1
                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(context, DetailsActivity.class);

                intent4.putExtra("details", homeBrandimg1id3);

//                Log.e("sss", "initView: " + homeBrandimg1id3);

                startActivity(intent4);
                break;

            case R.id.home_leisure_img2://休闲度假2
                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(context, DetailsActivity.class);

                intent5.putExtra("details", homeBrandimg1id3);

//                Log.e("sss", "initView: " + homeBrandimg1id3);

                startActivity(intent5);
                break;


            case R.id.home_leisure_img3://休闲度假3
                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(context, DetailsActivity.class);

                intent6.putExtra("details", homeBrandimg1id3);

//                Log.e("sss", "initView: " + homeBrandimg1id3);

                startActivity(intent6);
                break;
//            home_banquet_img1每日精选——宴会轻奢
//
            case R.id.home_banquet_img1://休闲度假3
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(context, DetailsActivity.class);

                intent7.putExtra("details", homeBrandimg1id3);

                startActivity(intent7);
                break;


            case R.id.home_banquet_img2://休闲度假3
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent8 = new Intent(context, DetailsActivity.class);

                intent8.putExtra("details", homeBrandimg1id3);

                startActivity(intent8);
                break;

            case R.id.home_banquet_img3://休闲度假3
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent9 = new Intent(context, DetailsActivity.class);

                intent9.putExtra("details", homeBrandimg1id3);

                startActivity(intent9);
                break;


            case R.id.home_banquet_img4://休闲度假3
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent0 = new Intent(context, DetailsActivity.class);

                intent0.putExtra("details", homeBrandimg1id3);

                startActivity(intent0);
                break;

//            android:id="@+id/home_business_img1"
//            每日精选——商务办公
            case R.id.home_business_img1://商务办公1
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent11 = new Intent(context, DetailsActivity.class);

                intent11.putExtra("details", homeBrandimg1id3);

                startActivity(intent11);
                break;

            case R.id.home_business_img2://商务办公2
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent12 = new Intent(context, DetailsActivity.class);

                intent12.putExtra("details", homeBrandimg1id3);

                startActivity(intent12);
                break;

            case R.id.home_business_img3://商务办公3
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent13 = new Intent(context, DetailsActivity.class);

                intent13.putExtra("details", homeBrandimg1id3);

                startActivity(intent13);
                break;

            case R.id.home_business_img4://商务办公4
//                Toast.makeText(context, "点击了图片", Toast.LENGTH_SHORT).show();
                Intent intent14 = new Intent(context, DetailsActivity.class);

                intent14.putExtra("details", homeBrandimg1id3);

                startActivity(intent14);
                break;




        }
    }

    @OnClick(R.id.home_share)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "点击了分享", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.mLinearBaoBao)
    public void onViewLinear() {
        Intent intent = new Intent(context, TalentActivity.class);
        startActivity(intent);
    }


    //    轮播图 ViewHolder         实体类 FreshGoodThingDean.ResultBean.PictureBean
    public class BannerViewHolder implements MZViewHolder<HomeFragmentBean.HeaderimgBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int i, HomeFragmentBean.HeaderimgBean headerimgBean) {
            // 数据绑定
            Glide.with(context).load(headerimg.get(i).getImg()).into(mImageView);
        }
    }
}

