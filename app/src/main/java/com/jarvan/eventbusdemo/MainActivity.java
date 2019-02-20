package com.jarvan.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        EventBus.getDefault().register(this);
        com.jarvan.eventbusdemo.EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        com.jarvan.eventbusdemo.EventBus.getDefault().unregister(this);
    }

    private void initButton() {
        findViewById(R.id.btn_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageComeForMe(MessageEvent event) {
        Log.i(TAG," the is receive the event ->"+event+" data ->"+event.getData()+" stack is ->"+Log.getStackTraceString(new Throwable()));
    }


    @com.jarvan.eventbusdemo.Subscribe
    public void myDemoMessage(MessageEvent event){
        Log.i(TAG," this is myDemo Event bus msg ->"+event+" data ->"+event.getData()+" stack is ->"+Log.getStackTraceString(new Throwable()));
    }




}




