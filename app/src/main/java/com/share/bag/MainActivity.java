package com.share.bag;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import com.share.bag.base.BaseActivity;
import com.share.bag.ui.activitys.collection.TalentActivity;
import com.share.bag.ui.activitys.collection.UploadActivity;
import com.share.bag.ui.fragments.collection.CollectionFragment;
import com.share.bag.ui.fragments.home.HomeFragment;
import com.share.bag.ui.fragments.mine.MineFragment;
import com.share.bag.ui.fragments.selected.SelectedFragment;
import com.share.bag.ui.fragments.upload.UploadFragment;
import com.share.bag.utils.Netwoke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //网络状态工具类
    private Netwoke netwoke;
    //退出时的时间
    private long mExitTime;
    private RadioButton home_radiobt;
    private RadioButton live_radiobt;
    private RadioButton video_radiobt;
    private RadioButton eye_radiobt;
    private RadioButton china_radiobt;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tags = new String[]{"home", "live", "video", "eye", "china"};
    private Fragment fhome, flive, fvideo, feye, fchina, mfragment;
    private FragmentManager fm;
    // 所需的全部权限
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.VIBRATE
    };
    PopupWindow window;

    @Override
    public int initLayout() {
        return R.layout.activity_mainone;
    }

    @Override
    public void initView() {
        // 友盟屏幕适配
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }

        setPermissions();

        home_radiobt = (RadioButton) findViewById(R.id.home_radiobt);
        live_radiobt = (RadioButton) findViewById(R.id.live_radiobt);
        video_radiobt = (RadioButton) findViewById(R.id.video_radiobt);
        eye_radiobt = (RadioButton) findViewById(R.id.eye_radiobt);
        china_radiobt = (RadioButton) findViewById(R.id.china_radiobt);

        home_radiobt.setOnClickListener(this);
        live_radiobt.setOnClickListener(this);
        video_radiobt.setOnClickListener(this);
        eye_radiobt.setOnClickListener(this);
        china_radiobt.setOnClickListener(this);

        initFragment();
    }

    @Override
    protected void initData() {
        getnetwoke();
    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }


    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("AEG", "方法进去了");
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {

        Log.e("AEG", "到这里了");

        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }


    //判断网络状态
    private void getnetwoke() {

      /*  if (netwoke == null) {
            netwoke = new Netwoke();
        }

        String getnetwoke = netwoke.getnetwoke(MainActivity.this);

        Toast.makeText(MainActivity.this, getnetwoke, Toast.LENGTH_SHORT).show();

        if (getnetwoke.equals("网络无连接")) {
            setNetwork();
        }*/
    }

    private void setNetwork() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("无法连接网络");

        builder.setMessage("网络不可用，如果继续，请先设置网络！");

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = null;

                /**

                 * 判断手机系统的版本！如果API大于10 就是3.0+

                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同

                 */

                if (Build.VERSION.SDK_INT > 10) {

                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);

                } else {

                    intent = new Intent();

                    ComponentName component = new ComponentName(

                            "com.android.settings",

                            "com.android.settings.WirelessSettings");

                    intent.setComponent(component);

                    intent.setAction("android.intent.action.VIEW");

                }

                startActivity(intent);

            }

        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {


            }

        });

        builder.create();

        builder.show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.home_radiobt:

                switchfragment(mfragment, fragments.get(0), 0);
                break;
            case R.id.live_radiobt:

                switchfragment(mfragment, fragments.get(1), 1);
                break;
            case R.id.video_radiobt:
                //上传
                initPop();
                break;
            case R.id.eye_radiobt:
                switchfragment(mfragment, fragments.get(2), 2);
                break;
            case R.id.china_radiobt:
                switchfragment(mfragment, fragments.get(3), 3);
                break;
        }
    }

    private void initFragment() {

        fm = getSupportFragmentManager();
        //首页
        fhome = new HomeFragment();
        //选包
        flive = new SelectedFragment();
        //上传
        fvideo = new UploadFragment();
        //收藏
        feye = new CollectionFragment();
        //我的
        fchina = new MineFragment();
        fragments.add(fhome);
        fragments.add(flive);
//        fragments.add(fvideo);
        fragments.add(feye);
        fragments.add(fchina);
        mfragment = fhome;
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fm_show, mfragment);
        ft.commitAllowingStateLoss();
        home_radiobt.setChecked(true);
    }

    //切换碎片的方法
    private void switchfragment(Fragment from, Fragment to, int position) {

        if (mfragment != to) {
            mfragment = to;
            FragmentTransaction ft = fm.beginTransaction();

            if (!to.isAdded()) {
                ft.hide(from).add(R.id.fm_show, to, tags[position]).commitAllowingStateLoss();
            } else {
                ft.hide(from).show(to).commitAllowingStateLoss();
            }
        }
    }

    private void setPermissions() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.VIBRATE) != PackageManager.PERMISSION_GRANTED
                ) {
            //Android 6.0权限申请
            ActivityCompat.requestPermissions(this, PERMISSION, 1);
            ActivityCompat.requestPermissions(this, PERMISSION, 2);
        } else {

        }
    }


    public void initPop() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop, null);
        //获取PopupWindow中View的宽高
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        LinearLayout hongbao = (LinearLayout) view.findViewById(R.id.pop_one);
        LinearLayout close = (LinearLayout) view.findViewById(R.id.pop_two);
        window.setFocusable(true);
        ColorDrawable drawable = new ColorDrawable(this.getResources().getColor(R.color.transparent));
        window.setBackgroundDrawable(drawable);
        window.setOutsideTouchable(true);
        int[] location = new int[2];
        RadioButton v = (RadioButton) findViewById(R.id.video_radiobt);
        v.getLocationOnScreen(location);
        //  window.showAtLocation(v,Gravity.NO_GRAVITY,location[0]+v.getWidth()/2,location[1]-measuredHeight);
        window.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - measuredWidth / 2, location[1] - measuredHeight);
        //window.showAsDropDown(((FrameLayout) findViewById(R.id.fm_show)));
        LinearLayout pop_one = (LinearLayout) view.findViewById(R.id.pop_one);
        LinearLayout pop_two = (LinearLayout) view.findViewById(R.id.pop_two);

        pop_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "点击了上传", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);

            }
        });
        pop_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "点击了包包达人", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TalentActivity.class);
                startActivity(intent);
            }
        });

    }

    // Ument做响应的回调
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }
}
