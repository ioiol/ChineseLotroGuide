package com.fc.lotro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.fc.lotro.MainActivity;
import com.fc.lotro.R;

public class SplashActivity extends AppCompatActivity {

    private static final int FIRST_PHOTO = 1;
    private static final int SEC_PHOTO = 2;
    private static final int THIRD_PHOTO = 3;
    private static final int SPLASH_DELAY_MILLIS = 1100;

    private ImageView imageView;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FIRST_PHOTO:
                    //第一张图播放结束
                    imageView.setBackgroundResource(R.drawable.main_photo2);
                    break;
                case SEC_PHOTO:
                    //第二张图
                    imageView.setBackgroundResource(R.drawable.main_photo3);
                    break;
                case THIRD_PHOTO:
                    //第三张图
                    goToMain();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.main_photo1);
        mHandler.sendEmptyMessageDelayed(FIRST_PHOTO, SPLASH_DELAY_MILLIS);
        mHandler.sendEmptyMessageDelayed(SEC_PHOTO, SPLASH_DELAY_MILLIS);
        mHandler.sendEmptyMessageDelayed(THIRD_PHOTO, SPLASH_DELAY_MILLIS);
    }

    private void goToMain(){
        Intent  intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
