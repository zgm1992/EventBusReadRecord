package com.jarvan.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.btn_send_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent());
            }
        });

        findViewById(R.id.btn_send_msg2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "this is other msaage";
                EventBus.getDefault().post(new MessageEvent<String>(msg));
            }
        });
    }

}
