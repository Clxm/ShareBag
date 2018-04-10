package com.share.bag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private int i = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
//                    tv_text.setText(i+"");
                    i--;
                    if (i<0){

                        //关闭线程
                        handler.removeCallbacks(runnable);
                        Intent intent2 = new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent2);
                        finish();
                    }else{
                        //延时一秿
                        handler.postDelayed(runnable,1000);
                    }
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        handler.post(runnable);



    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            handler.sendMessage(message);
        }
    };




}
