package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class oopsresult2 extends AppCompatActivity {
public static final String EXTRA_KEY_USER="com.example.loginapp.userdata";
    private TextView textView17,textView18;
private Button review_btn_2;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopsresult2);

        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView17=findViewById(R.id.textView17);
        textView18=findViewById(R.id.textView18);
        review_btn_2=findViewById(R.id.review_btn_2);

        Intent intent=getIntent();
        String score2= intent.getStringExtra(oops1.EXTRA_SCORE_2);
        String correct_answer= intent.getStringExtra(oops1.EXTRA_SCORE_POSITIVE);
        String wrong_answer=intent.getStringExtra(oops1.EXTRA_SCORE_NEGATIVE);

        textView17.setText("SCORE : " + score2+" / 10");
        textView18.setText("SORRY , WORK HARD AND COME AGAIN");
        mediaPlayer= MediaPlayer.create(this,R.raw.oops);
        mediaPlayer.start();

        review_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oopsresult2.this,REVIEW.class);
                intent.putExtra("com.example.loginapp.userdata",correct_answer);
                intent.putExtra("com.example.loginapp.userdata.wronganswer",wrong_answer);

                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(oopsresult2.this,home2.class);
        startActivity(intent);
    }
}