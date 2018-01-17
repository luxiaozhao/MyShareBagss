package com.share.bag.ui.activitys.mine;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.FileUtil;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.base.BaseActivity;
import com.share.bag.entity.selected.HeadImgBean;
import com.share.bag.ui.activitys.mine.avatar.PhotoUtils;
import com.share.bag.ui.activitys.mine.avatar.ToastUtils;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;

import butterknife.ButterKnife;
import butterknife.OnClick;


/*
*
* 个人中心
*
* */
public class PersonalActivity extends BaseActivity {
//    @BindView(R.id.personal_return)
//    ImageView personalReturn;
//    @BindView(R.id.personal_avatar)
//    RelativeLayout personalAvatar;
//    @BindView(R.id.personal_phone)
//    RelativeLayout personalPhone;
//    @BindView(R.id.personal_nickname)
//    RelativeLayout personalNickname;
//    @BindView(R.id.personal_signature)
//    RelativeLayout personalSignature;
//    @BindView(R.id.personal_avatar1)
//    CircleImageView personal_avatar1;
//    @BindView(R.id.personal_name1)
//    TextView personalName1;
//    @BindView(R.id.personal_number)
//    TextView personalNumber;
//
//    @BindView(R.id.imgurl)
//    TextView imgurl;


//    @BindView(R.id.personal_number)
//    TextView personal_number;

    //    @BindView(R.id.personal_name1)
//    TextView personal_name1;
    private int width;
    private int height;
    private PopupWindow window1;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private ImageView personal_return;
    private ImageView imageView8;
    private RelativeLayout personal_avatar;
    private TextView personal_number;
    private ImageView imageView9;
    private RelativeLayout personal_phone;
    private TextView personal_name1;
    private ImageView imageView11;
    private RelativeLayout personal_nickname;
    private TextView textView17;
    private TextView textView15;
    private TextView textView16;
    private ImageView imageView12;
    private RelativeLayout personal_signature;
    private ImageView imgview;


    @Override
    public int initLayout() {
        return R.layout.activity_personal2;
    }

    @Override
    public void initView() {
        Toast.makeText(this, "222222222222", Toast.LENGTH_SHORT).show();
//        Log.e("TAG","-----------");
//        FileUtil.MinereadFromPre(this,personalName1,personal_avatar1);
//        String s = personalName1.getText().toString();
//        Toast.makeText(this, "---------"+s, Toast.LENGTH_SHORT).show();
//        Log.e("TAG","-----------");

        personal_return = (ImageView) findViewById(R.id.personal_return);
        imgview = (ImageView) findViewById(R.id.personal_avatar1);
        imageView8 = (ImageView) findViewById(R.id.imageView8);

        personal_avatar = (RelativeLayout) findViewById(R.id.personal_avatar);

        personal_number = (TextView) findViewById(R.id.personal_number);

        imageView9 = (ImageView) findViewById(R.id.imageView9);

        personal_phone = (RelativeLayout) findViewById(R.id.personal_phone);

        personal_name1 = (TextView) findViewById(R.id.personal_name1);
        String s = personal_name1.getText().toString();
        Toast.makeText(this, "3333333333333333", Toast.LENGTH_SHORT).show();
        imageView11 = (ImageView) findViewById(R.id.imageView11);

        personal_nickname = (RelativeLayout) findViewById(R.id.personal_nickname);

        textView17 = (TextView) findViewById(R.id.textView17);

        textView15 = (TextView) findViewById(R.id.textView15);

        textView16 = (TextView) findViewById(R.id.textView16);

        imageView12 = (ImageView) findViewById(R.id.imageView12);

        personal_signature = (RelativeLayout) findViewById(R.id.personal_signature);
        Toast.makeText(this,personal_name1.getText().toString()+personal_number.getText().toString(), Toast.LENGTH_SHORT).show();
        FileUtil.Homepage(this,personal_name1,imgview,personal_number);
    }

    @Override
    protected void initData() {
//        昵称    头像  手机号

//            FileUtil.Homepage(this,personalName1,personal_avatar1,personalNumber);
//        Toast.makeText(this, "1111111111111", Toast.LENGTH_SHORT).show();
//        Log.e("TAG","=====");
//            FileUtil.MinereadFromPre(this,personalName1,personal_avatar1);

//        String s = personalName1.getText().toString();
//        Toast.makeText(this, "---------", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected boolean hodeWindow() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

//
        ButterKnife.bind(this);
    }

    @OnClick({R.id.personal_return, R.id.personal_avatar, R.id.personal_phone, R.id.personal_nickname, R.id.personal_signature})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_return://返回
                finish();

                break;
            case R.id.personal_avatar://修改头像

                getPopupWindow();
                break;
            case R.id.personal_phone://手机号

                startActivity(new Intent(PersonalActivity.this, PhoneActivity.class));

                break;
            case R.id.personal_nickname://昵称
                Log.e("TAG======", "点击了4");
                Toast.makeText(this, "444444444", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_signature://个性签名

                break;
        }
    }

    public void getPopupWindow() {
        WindowManager wm = (WindowManager) getApplication()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_avatar, null);
        window1 = new PopupWindow(contentView,
                width, height);
        window1.setContentView(contentView);
        //设置各个控件的点击响应
        LinearLayout popupwindow_avatar_shoot = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_shoot);
        LinearLayout popupwindow_avatar_album = (LinearLayout) contentView.findViewById(R.id.popupwindow_avatar_album);

        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_personal2, null);
        window1.showAtLocation(rootview, Gravity.CENTER, 0, 0);
        popupwindow_avatar_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoObtainStoragePermission();
                window1.dismiss();
//                finish();
            }
        });
        popupwindow_avatar_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoObtainCameraPermission();
                window1.dismiss();


//                finish();
            }
        });

    }

    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                default:
            }
        }
    }

    //    展示图片 进行网络请求
    private void showImages(Bitmap bitmap) {
        //personal_avatar1.setImageBitmap(bitmap);


//        String url, Map<String, String> params, final ByteCallBack callback) {
//      压缩图片
        ByteArrayOutputStream onputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, onputStream);
        final byte[] bytes = onputStream.toByteArray();


//           final Map<String, String> map = new HashMap<>();
//            final Map<String, String> stringObserverMap=new HashMap<>();
//        stringObserverMap.put("uploadAvatar",""+bytes);

//        OkHttpUtils.getInstance().post(SBUrls.UPDATA_IMG, stringObserverMap, new MyNetWorkCallback<HeadImgBean>() {
//            @Override
//            public void onSuccess(HeadImgBean headImgBean) {
//                Toast.makeText(PersonalActivity.this, "图片的二进制"+bytes.toString(), Toast.LENGTH_SHORT).show();
//
//                Log.e("TAG--------","图片的二进制"+bytes.toString());
//                com.share.bag.utils.ToastUtils.show(PersonalActivity.this , headImgBean.getInfo()+"返回值"+headImgBean.getStatus());
//
//
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });
        OkHttpUtils.getInstance().updataImg(SBUrls.UPDATA_IMG, bytes, new MyNetWorkCallback<HeadImgBean>() {
            @Override
            public void onSuccess(HeadImgBean headImgBean) {

                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, bytes.toString() + "" + headImgBean.getInfo() + "-----" + headImgBean.getStatus());

                Log.e("TAG", bytes.toString() + "" + headImgBean.getInfo() + "-----" + headImgBean.getStatus());


            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                com.share.bag.utils.ToastUtils.show(PersonalActivity.this, "失败" + errorMsg);
            }
        });

    }

    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
//-----------------------------------
//            Log.e("TAG","-------"+fileUri);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }


    private void autoObtainStoragePermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(PersonalActivity.this, "com.zz.fileprovider", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);

//------------------------------------
//                Log.e("TAG","========"+fileCropUri);

            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }

    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

}
