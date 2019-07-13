package com.pay.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class JumpActivity extends AppCompatActivity {
    private String  TAG ="JumpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        try {
            if (getIntent()==null){
                return;
            }

            if (getIntent().getData()==null){
                return;
            }
            Uri data = getIntent().getData();
            Log.i(TAG, "host = " + data.getHost() + " path = " + data.getPath() + " query = " + data.getQuery());
            //  String order_id = data.getQueryParameter("order_id");
            final String url = data.getQueryParameter("url");
           //final Uri uri = Uri.parse(url+"&url="+Uri.encode("https://ds.alipay.com/?from=pc&appId=09999988&actionType=toCard&sourceId=bill&cardNo=6214837667780971&bankAccount=%E5%90%95%E4%B8%BD%E8%8A%B1&amount=10.00&money=10.00&bankMark=CMB&orderSource=from&pay_orderid=20190712224910544810"));

           // final Uri uri = Uri.parse("alipays://platformapi/startapp?appId=09999988&actionType=toCard&sourceId=bill&cardNo=6217000030001234567&bankAccount=%E9%A9%AC%E4%BA%91&money=0.01&amount=0.01&bankMark=CCB&bankName=%E4%B8%AD%E5%9B%BD%E5%BB%BA%E8%AE%BE%E9%93%B6%E8%A1%8C");
            //final Uri uri = Uri.parse(url+"&url=http://pay8.jianshenvip.cn/pay_Shhxx_toZfbPay.html?id=20190712224910544810");



            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }, 1000L);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
