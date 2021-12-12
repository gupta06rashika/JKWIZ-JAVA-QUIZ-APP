package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fillintheblanks_sad extends AppCompatActivity {
private TextView textView21,textView22;
private Button button12;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillintheblanks_sad);


        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        textView21=findViewById(R.id.textView21);
        textView22=findViewById(R.id.textView22);
        button12=findViewById(R.id.button12);
         MediaPlayer mediaPlayer=MediaPlayer.create(fillintheblanks_sad.this,R.raw.oops);
         mediaPlayer.start();
        Intent intent=getIntent();
        String score=intent.getStringExtra(fillintheblanks.EXTRA_SCORE_2);
        String right=intent.getStringExtra(fillintheblanks.EXTRA_SCORE_2_rightanswer);
        textView21.setText("SCORE : "+score+" / 10");
        textView22.setText("WORK HARD AND COME AGAIN");

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(fillintheblanks_sad.this,review_next_next.class);
                intent2.putExtra("com.example.loginapp.ans.ans.ans",right);
                startActivity(intent2);
            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(fillintheblanks_sad.this,home2.class);
        startActivity(intent);
    }
}