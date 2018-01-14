package com.share.bag.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by 54hk on 2017/12/7.
 * 登录验证码 倒计时
 */
public class TimeCountUtils  extends CountDownTimer {

    private TextView getvcode;
    public boolean timerIsStart = false;
    public TimeCountUtils(long millisInFuture, long countDownInterval, TextView getvcode) {
        super(millisInFuture, countDownInterval);
        this.getvcode = getvcode;
    }

    @Override
    public void onFinish() {
        timerIsStart = false;
        getvcode.setText("重发验证码");
        getvcode.setClickable(true);
        getvcode.setEnabled(true);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        timerIsStart = true;
        getvcode.setClickable(false);
        getvcode.setText("重发验证码" + "(" + millisUntilFinished / 1000 + ")");
        getvcode.setEnabled(false);
    }

}
