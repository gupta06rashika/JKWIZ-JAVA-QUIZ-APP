package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fillintheblanks_result_win extends AppCompatActivity {
private TextView textView19,textView20;
private Button button25;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillintheblanks_result_win);


        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        textView19=findViewById(R.id.textView19);
        textView20=findViewById(R.id.textView20);
        button25=findViewById(R.id.button25);
        MediaPlayer mediaPlayer=MediaPlayer.create(fillintheblanks_result_win.this,R.raw.clap3);
        mediaPlayer.start();
        Intent intent=getIntent();
        String score=intent.getStringExtra(fillintheblanks.EXTRA_SCORE_2);
        String right=intent.getStringExtra(fillintheblanks.EXTRA_SCORE_2_rightanswer);
        textView19.setText("SCORE : "+score+" / 10");
        textView20.setText("CONGRATULATIONS, YOU PASSED THE TEST");

        button25.setOnClickListener(new View.OnClickListener() {
            @Override

        public void onClick(View v) {

              Intent intent2 = new Intent(fillintheblanks_result_win.this,review_next_next.class);
                intent2.putExtra("com.example.loginapp.ans.ans.ans",right);
              startActivity(intent2);

        }
          });

    }


    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(fillintheblanks_result_win.this,home2.class);
        startActivity(intent);
    }
}