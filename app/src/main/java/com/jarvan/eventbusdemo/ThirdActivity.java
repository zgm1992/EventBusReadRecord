package com.jarvan.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findViewById(R.id.btn_send_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivity third","send the empty message");
                EventBus.getDefault().post(new MessageEvent());
            }
        });

        findViewById(R.id.btn_send_msg2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivity third","send the withe value message");
                String msg = "message from third activity";
                EventBus.getDefault().post(new MessageEvent<String>(msg));
            }
        });
    }
}
