package com.share.bag.ument;
//import android.app.Activity;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import com.share.bag.MainActivity;
//import com.share.bag.R;
//import java.util.ArrayList;
//import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.share.bag.MainActivity;
import com.share.bag.R;
import java.util.ArrayList;
import java.util.List;

//-------------------------------

/*
*
* 分享界面的所有方法
*
* */


public class UmentActivity extends AppCompatActivity {
    private ViewPager mIn_vp;
    private LinearLayout mIn_ll;
    private List<View> mViewList;
    private ImageView mLight_dots;
    private int mDistance;
    private ImageView mOne_dot;
    private ImageView mTwo_dot;
    private ImageView mThree_dot;
    private Button mBtn_next;
    private Button bt_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ument);
        initView();
        initData();
        mIn_vp.setAdapter(new ViewPagerAdatper(mViewList));
        addDots();
        moveDots();
        mIn_vp.setPageTransformer(true,new com.share.bag.ument.DepthPageTransformer());
    }
    private void moveDots() {
        mLight_dots.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //获得两个圆点之间的距离
                mDistance = mIn_ll.getChildAt(1).getLeft() - mIn_ll.getChildAt(0).getLeft();
                mLight_dots.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
            }
        });
        mIn_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滚动时小白点移动的距离，并通过setLayoutParams(params)不断更新其位置
                float leftMargin = mDistance * (position + positionOffset);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
                if(position==2){
                    mBtn_next.setVisibility(View.VISIBLE);
                }
                if(position!=2&&mBtn_next.getVisibility()==View.VISIBLE){
                    mBtn_next.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                //页面跳转时，设置小圆点的margin
                float leftMargin = mDistance * position;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
                if(position==2){
                    mBtn_next.setVisibility(View.VISIBLE);
                }
                if(position!=2&&mBtn_next.getVisibility()==View.VISIBLE){
                    mBtn_next.setVisibility(View.GONE);
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void addDots() {
        mOne_dot = new ImageView(this);
        mOne_dot.setImageResource(R.drawable.gray_dot);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 40, 0);
        mIn_ll.addView(mOne_dot, layoutParams);
        mTwo_dot = new ImageView(this);
        mTwo_dot.setImageResource(R.drawable.gray_dot);
        mIn_ll.addView(mTwo_dot, layoutParams);
        mThree_dot = new ImageView(this);
        mThree_dot.setImageResource(R.drawable.gray_dot);
        mIn_ll.addView(mThree_dot, layoutParams);
        setClickListener();

    }

    private void setClickListener() {
        mOne_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(0);
            }
        });
        mTwo_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(1);
            }
        });
        mThree_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(2);
            }
        });
    }


    private void initData() {
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedUser = getSharedPreferences("welcome",  Activity.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedUser.edit();
                edit.putString("YinDao","22");
                edit.commit();
                startActivity(new Intent(UmentActivity.this,MainActivity.class));
                finish();
            }
        });
        mViewList = new ArrayList<View>();
        LayoutInflater lf = getLayoutInflater().from(UmentActivity.this);
        View view1 = lf.inflate(R.layout.we_indicator1, null);
        View view2 = lf.inflate(R.layout.we_indicator2, null);
        View view3 = lf.inflate(R.layout.we_indicator3, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
    }

    private void initView() {
        mIn_vp = (ViewPager) findViewById(R.id.in_viewpager);
        mIn_ll = (LinearLayout) findViewById(R.id.in_ll);
        mLight_dots = (ImageView) findViewById(R.id.iv_light_dots);
        mBtn_next = (Button) findViewById(R.id.bt_next);
        SharedPreferences welcome = getSharedPreferences("welcome", Activity.MODE_PRIVATE);
        String yinDao = welcome.getString("YinDao", "");
        if (yinDao.equals("22")){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

}


//
//    @BindView(R.id.qq_share)
//    ImageView qqShare;
//    @BindView(R.id.weixin_share)
//    ImageView weixinShare;
//    @BindView(R.id.jinru)
//    Button jinru;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ument);
//        ButterKnife.bind(this);
//    }
//
//    @OnClick({R.id.qq_share, R.id.weixin_share, R.id.jinru})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.qq_share:
//
//                UMShareAPI umShareAPI = UMShareAPI.get(UmentActivity.this);
//
//                umShareAPI.doOauthVerify(UmentActivity.this, SHARE_MEDIA.QQ, shareList);
//                break;
//            case R.id.weixin_share:
//                ToastUtils.show(UmentActivity.this, "weixin");
//
//                new ShareAction(UmentActivity.this)
//                        .setPlatform(SHARE_MEDIA.WEIXIN).setCallback(shareListener).withText("hello").share();
//                break;
////            case R.id.sina_share:
////                ToastUtils.show(UmentActivity.this, "sing");
////                UMWeb web3 = new UMWeb("www.baidu.com");
////                web3.setTitle("This is music title");//标题
////                // web.setThumb(thumb);  //缩略图
////                web3.setDescription("my description");//描述
////                new ShareAction(UmentActivity.this)
////                        .withMedia(web3)
////                        .setPlatform(SHARE_MEDIA.SINA)
////                        .setCallback(shareListener)
////                        .share();
////                break;
//
//            case R.id.jinru:
//
//                Intent intent = new Intent(this, MainActivity.class);
//                startActivity(intent);
//
//                break;
//        }
//    }
//
//    private UMShareListener shareListener = new UMShareListener() {
//        /**
//         * @descrption 分享开始的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onStart(SHARE_MEDIA platform) {
//
//        }
//
//        /**
//         * @descrption 分享成功的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
//            Toast.makeText(UmentActivity.this, "成功了", Toast.LENGTH_LONG).show();
//        }
//
//        /**
//         * @descrption 分享失败的回调
//         * @param platform 平台类型
//         * @param t 错误原因
//         */
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(UmentActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
//        /**
//         * @descrption 分享取消的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
//            Toast.makeText(UmentActivity.this, "取消了", Toast.LENGTH_LONG).show();
//
//        }
//    };
//
//    private UMAuthListener shareList = new UMAuthListener() {
//        @Override
//        public void onStart(SHARE_MEDIA share_media) {
//            Toast.makeText(UmentActivity.this, "开始", Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//            Toast.makeText(UmentActivity.this, "成功", Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//            Toast.makeText(UmentActivity.this, "error", Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onCancel(SHARE_MEDIA share_media, int i) {
//
//        }
//    };
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
//
//    @OnClick(R.id.jinru)
//    public void onViewClicked() {
//    }