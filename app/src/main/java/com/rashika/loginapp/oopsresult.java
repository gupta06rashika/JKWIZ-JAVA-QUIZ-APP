package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class oopsresult extends AppCompatActivity {
public static final String EXTRA_KEY_USERCHOICE="com.example.loginapp.userdata";

 TextView textView15,textView16;
 Button review_button;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopsresult);

        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView15=findViewById(R.id.textView15);
        textView16=findViewById(R.id.textView16);
        review_button=findViewById(R.id.review_button);

        Intent intent=getIntent();
        String score2= intent.getStringExtra(oops1.EXTRA_SCORE_2);
        String correct_answer=intent.getStringExtra(oops1.EXTRA_SCORE_POSITIVE);
        String wrong_answer=intent.getStringExtra(oops1.EXTRA_SCORE_NEGATIVE);


        textView15.setText("SCORE : " + score2+" / 10");
        textView16.setText("CONGRATULATIONS ,YOU CLEARED THE QUIZ");
        mediaPlayer= MediaPlayer.create(this,R.raw.clap3);
        mediaPlayer.start();

       // Toast.makeText(oopsresult.this,""+wrong_answer,Toast.LENGTH_SHORT).show();

        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oopsresult.this,REVIEW.class);
                intent.putExtra("com.example.loginapp.userdata",correct_answer);
                intent.putExtra("com.example.loginapp.userdata.wronganswer",wrong_answer);

                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(oopsresult.this,home2.class);
        startActivity(intent);
    }
}