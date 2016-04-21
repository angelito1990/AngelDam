package com.example.macmini_buzinger03.angeldam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by macmini-buzinger03 on 21/4/16.
 */

public class MainActivity extends AppCompatActivity {

    private static final int duration = 1000 * 3;
    boolean userTouchScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();

        userTouchScreen = false;

        Runnable m_handlerTask = new Runnable() {
            public void run() {
                if (!userTouchScreen) {
                    userTouchScreen = true;
                    initNextActivity();
                }

            }
        };
        Handler m_handler = new Handler();
        m_handler.postDelayed(m_handlerTask, duration);
    }
    public void initNextActivity(){
        Class mClass = TutorialActivity.class;

        Intent mIntent = new Intent(this, mClass);
        startActivity(mIntent);
    }
}
