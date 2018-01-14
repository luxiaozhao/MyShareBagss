package com.share.bag.utils.okhttp.callback;

/**
 * Created by Administrator on 2017/12/30.
 */

public interface ByteCallBack {
    void onSuccess(String json);
    void onError(int errorCode, String errorMsg);
}
