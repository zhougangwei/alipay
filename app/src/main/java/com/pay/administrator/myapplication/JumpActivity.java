package com.pay.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class JumpActivity extends AppCompatActivity {
    private String  TAG ="JumpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        Uri data = getIntent().getData();
        Log.i(TAG, "host = " + data.getHost() + " path = " + data.getPath() + " query = " + data.getQuery());
        String order_id = data.getQueryParameter("order_id");
        final String url = data.getQueryParameter("url");

        Log.i(TAG, "order_id = " +order_id + " url = " +url );

        View viewById = findViewById(R.id.tv);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url+"&url=http://pay8.jianshenvip.cn/pay_Shhxx_toZfbPay.html?id=20190712224910544810");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
