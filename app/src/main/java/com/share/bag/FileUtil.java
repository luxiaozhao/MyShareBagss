package com.share.bag;

//import androSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/1/16.
 */

public  class FileUtil {
    /**
     * 最为通用的第四种方法：
     * 使用SharedPreference进行保存用户名和密码，可以实现拆分，不必手动的以，为分隔符进行拆分，
     * 如果用，进行拆分，那么一旦用户登录的时候输入了，号，程序就会出错，现在以Map的形式保存用户名和密码，
     * 就不用再担心这个问题
     * @param context
     * @param name
     * @param pass
     */


    public static void saveToPre1(Context context, String name, String pass,String id,String gender,String nickname,String imageurl) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);//手机号
        editor.putString("pass",pass);//密码
        editor.putString("id",id);//
        editor.putString("gender",gender);//性别
        editor.putString("nickname",nickname);//昵称
        editor.putString("imageurl",imageurl);//图片
        editor.commit();
    }

    /**
     * 使用SharedPreference进行读取保存的用户名和密码
     * @param context
     * @param tname
     * @param tpass
     */
    public static void readFromPre(Context context, EditText tname, EditText tpass) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String pass = sharedPreferences.getString("pass","");
        tname.setText(name);
        tpass.setText(pass);
    }

/*
* 我的主页的sp
* */
    public static void MinereadFromPre(Context context,  TextView nickname,ImageView touxiangurl) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);

        String nickname1 = sharedPreferences.getString("nickname", "");
        String imageurl = sharedPreferences.getString("imageurl", "");
        nickname.setText(nickname1);
        Glide.with(context).load("http://baobaoapi.ldlchat.com/"+imageurl).into(touxiangurl);
    }


    public static void SelectedreadFromPre(Context context, TextView tname) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        tname.setText(name);

    }


/*
* 清空sp内容
* */
    public static void shanchu(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

}



