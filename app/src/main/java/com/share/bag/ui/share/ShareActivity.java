package com.share.bag.ui.share;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;

/*
* 分享界面
* */
public class ShareActivity extends AppCompatActivity {

    private ImageView Share_return;
    private TextView share_invite;
    private LinearLayout share_wxfriends1;
    private LinearLayout share_wxcircle1;
    private LinearLayout share_qqcircle1;
    private LinearLayout share_xlsina1;
    private LinearLayout share_qqfriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
    }

    private void initView() {
        Share_return = (ImageView) findViewById(R.id.Share_return);
        share_invite = (TextView) findViewById(R.id.share_invite);
        share_wxfriends1 = (LinearLayout) findViewById(R.id.share_wxfriends1);
        share_wxcircle1 = (LinearLayout) findViewById(R.id.share_wxcircle1);
        share_qqcircle1 = (LinearLayout) findViewById(R.id.share_qqcircle1);
        share_xlsina1 = (LinearLayout) findViewById(R.id.share_xlsina1);
        share_qqfriends = (LinearLayout) findViewById(R.id.share_qqfriends);

        Share_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        share_invite
        share_wxfriends1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShareActivity.this, "微信好友", Toast.LENGTH_SHORT).show();
            }
        });

        share_wxcircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShareActivity.this, "微信朋友圈", Toast.LENGTH_SHORT).show();
            }
        });
        share_qqcircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShareActivity.this, "QQ好友", Toast.LENGTH_SHORT).show();
            }
        });

        share_xlsina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ShareActivity.this, "新浪微博", Toast.LENGTH_SHORT).show();


            }
        });



        share_qqfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ShareActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
