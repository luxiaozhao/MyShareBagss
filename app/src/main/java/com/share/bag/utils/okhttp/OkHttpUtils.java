package com.share.bag.utils.okhttp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.share.bag.APP;
import com.share.bag.Constant;
import com.share.bag.utils.SharePreUtils;
import com.share.bag.utils.okhttp.callback.ByteCallBack;
import com.share.bag.utils.okhttp.callback.MyNetWorkCallback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 基于OKhttp发送网络请求
 * Created by xingge on 2017/7/11.
 */

public class OkHttpUtils implements IHttp {

    private OkHttpClient okHttpClient;
    //构造函数私有化
    private OkHttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkHttpUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static OkHttpUtils getInstance(){
        if(okHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }

    @Override
    public <T> void get(String url, MyNetWorkCallback<T> callback) {

    }

    /**
     * 发送get请求
     * @param url 请求地址
     * @param params 请求参数
     * @param callback 回调
     * @param <T> 请求回来的数据对应的JavaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request request = new Request.Builder().url(url).addHeader("cookie",SharePreUtils.getString(Constant.COOKIE,"")).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });

    }

    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> headers, final MyNetWorkCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if(headers != null && headers.size() > 0){
            Set<String> keys = headers.keySet();
            for (String key : keys){
                String value = headers.get(key);
                builder.addHeader(key,value);
            }
        }
        Request request = builder.url(url).addHeader("cookie",SharePreUtils.getString(Constant.COOKIE,"")).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {

        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).addHeader("cookie",SharePreUtils.getString(Constant.COOKIE,"")).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
//                Log.e("OKhttpUtils","这是我的JSON:"+jsonData);
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
//                Log.e("OKhttpUtils","这是我的:"+call);
                if(cookies.size()!=0){
                    String session = cookies.get(0);
                    Log.e("TGA","session"+session);
                    SharePreUtils.setString(Constant.COOKIE,session);
                }
                //执行在子线程中
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void postByte(String url, Map<String, String> params, final ByteCallBack callback) {

        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).addHeader("cookie",SharePreUtils.getString(Constant.COOKIE,"")).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();

//                Log.e("OKhttpUtils","这是我的JSON:"+jsonData);
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
//                Log.e("OKhttpUtils","这是我的:"+call);
                if(cookies.size()!=0){
            //        String session = cookies.get(0);
              //      Log.e("TGA","session"+session);
                //    SharePreUtils.setString(Constant.COOKIE,session);
                }
                //执行在子线程中
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(jsonData);
                    }
                });

            }
        });
    }

    @Override
    public void upload() {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(APP.context).load(url).into(imageView);
    }


    public void loadImgCode(String url,final MyNetWorkCallback<Bundle> callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                Headers headers = response.headers();
                String jsessionId =  headers.get("Set-Cookie");
//                for (int i = 0; i < headers.size(); i++){
//                    String name = headers.name(i);
//                    headers.get("Set-Cookie")
//                    MyLog.d("abc","name = "+name);
//                    if(name != null && name.contains("JSESSIONID") && !name.contains(";")){
//                        jsessionId = headers.get(name);
//                        break;
//                    }
//                }
                final Bundle bundle = new Bundle();
//                bundle.putString(Keys.JSESSIONID,jsessionId);
//                bundle.putByteArray(Keys.IMGCODE,bytes);

                //执行在子线程中
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(bundle);
                    }
                });

            }
        });
    }

    /**
     * 自动解析json至回调中的JavaBean
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData,MyNetWorkCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        return t;
    }

//    private <T> T getByteGeneric(String jsonData, MyNetWorkCallback<T> callback){
//        Type[] types = callback.getClass().getGenericInterfaces();
//        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
//        Type type = actualTypeArguments[0];
//        Type type1 = new TypeToken<T>(){}.getType();
//        type1 = type;
//        Gson gson = new Gson();
//        return gson.fromJson(jsonData, type1);
//    }

    public  <T> void updataImg(String url,byte[] file, final MyNetWorkCallback<T> callback){
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("uploadAvatar", "uploadAvatar.jpg",
                        RequestBody.create(MediaType.parse("image/png"), file));

        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404,e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
//                Log.e("OKhttpUtils","这是我的:"+call);
                if(cookies.size()!=0){
                    String session = cookies.get(0);
                    Log.e("TGA","session"+session);
                    SharePreUtils.setString(Constant.COOKIE,session);
                }
                APP.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });
            }
        });
    }

}
