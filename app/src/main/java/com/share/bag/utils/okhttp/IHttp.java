package com.share.bag.utils.okhttp;


import android.widget.ImageView;

import com.share.bag.utils.okhttp.callback.ByteCallBack;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public interface IHttp {

    <T> void get(String url, MyNetWorkCallback<T> callback);
    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void get(String url, Map<String, String> params, Map<String, String> headers, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void postByte(String url, Map<String, String> params, ByteCallBack callback);
    void upload();
    void download();
    void loadImage(String url, ImageView imageView);

}
