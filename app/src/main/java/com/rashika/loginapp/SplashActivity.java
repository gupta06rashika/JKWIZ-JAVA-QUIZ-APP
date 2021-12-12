package com.rashika.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//

        //if (Build.VERSION.SDK_INT < 16) {
 //           getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }
//        else{
//
//            View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//
//        }

        // Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.

//
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();
        getSupportActionBar().hide();
        new Thread(){
          public void run(){
              try {
                  sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              finally {

                  Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                  startActivity(intent);
                  SplashActivity.this.finish();

              }
          }
        }.start();
    }
}