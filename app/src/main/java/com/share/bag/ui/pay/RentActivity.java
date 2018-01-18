package com.share.bag.ui.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.share.bag.R;

/*
* 确认租
* */
public class RentActivity extends AppCompatActivity {


    private ImageView rent_return;
    private ImageView imageView3;
    private TextView rent;
    private TextView rent_22;
    private TextView rent_11;
    private RelativeLayout rent_address;
    private TextView rent_rent;
    private TextView rent_time_less;
    private TextView rent_time;
    private TextView rent_time_plus;
    private TextView rent_member;
    private TextView rent_postage;
    private TextView rent_red_package;
    private TextView rent_handle_deposit;
    private TextView rent_paid_deposit;
    private TextView rent_handle_rent;
    private TextView rent_supplement_rent;
    private TextView rent_total_amount;
    private LinearLayout rent_submit_order;

    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        initView();

        String s = rent_time.getText().toString();
        number=Integer.parseInt(s);//string转换int
        rent_time_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number<8){
                    Toast.makeText(RentActivity.this, "最少7天", Toast.LENGTH_SHORT).show();
                    rent_time_less.clearFocus();
                    rent_time_less.setFocusable(false);
                }else {
                    rent_time_less.setFocusable(true);
                    rent_time_less.requestFocus();
                    number--;
                    rent_time.setText(number+"");
                }
            }
        });

        rent_time_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    rent_time_less.setFocusable(true);
                    rent_time_less.requestFocus();
                    number++;
                    rent_time.setText(number+"");
            }
        });

        rent_submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RentActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

            }
        });



        rent_total_amount.setText("");

    }


    private void initView() {
        rent_return = (ImageView) findViewById(R.id.rent_return);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        rent = (TextView) findViewById(R.id.rent);
        rent_22 = (TextView) findViewById(R.id.rent_22);
        rent_11 = (TextView) findViewById(R.id.rent_11);
        rent_address = (RelativeLayout) findViewById(R.id.rent_address);
        rent_rent = (TextView) findViewById(R.id.rent_rent);
        rent_time_less = (TextView) findViewById(R.id.rent_time_less);
        rent_time = (TextView) findViewById(R.id.rent_time);
        rent_time_plus = (TextView) findViewById(R.id.rent_time_plus);
        rent_member = (TextView) findViewById(R.id.rent_member);
        rent_postage = (TextView) findViewById(R.id.rent_postage);
        rent_red_package = (TextView) findViewById(R.id.rent_red_package);
        rent_handle_deposit = (TextView) findViewById(R.id.rent_handle_deposit);
        rent_paid_deposit = (TextView) findViewById(R.id.rent_paid_deposit);
        rent_handle_rent = (TextView) findViewById(R.id.rent_handle_rent);
        rent_supplement_rent = (TextView) findViewById(R.id.rent_supplement_rent);
        rent_total_amount = (TextView) findViewById(R.id.rent_total_amount);
        rent_submit_order = (LinearLayout) findViewById(R.id.rent_submit_order);
    }
}
