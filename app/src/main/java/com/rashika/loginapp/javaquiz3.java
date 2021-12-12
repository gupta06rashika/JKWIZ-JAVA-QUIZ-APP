package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class
javaquiz3 extends AppCompatActivity {
    private TextView textView3;
    private MediaPlayer mediaPlayer;
    private Button button22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaquiz3);


        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView3=findViewById(R.id.textView3);
        button22=findViewById(R.id.button22);

        Intent intent=getIntent();
        String score2= intent.getStringExtra(javaquiz1.EXTRA_SCORE);

        String right= intent.getStringExtra(javaquiz1.EXTRA_SCORE_right_ans_1);

        textView3.setText("     WORK HARD AND COME AGAIN \n      YOUR SCORE IS " + score2 + "  / 10");
        mediaPlayer= MediaPlayer.create(this,R.raw.oops);
        mediaPlayer.start();

       // Toast.makeText(javaquiz3.this,""+right,Toast.LENGTH_SHORT).show();
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent1=new Intent(javaquiz3.this,next_review.class);
             intent1.putExtra("com.example.loginapp.userdata.data",right);

             startActivity(intent1);
            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(javaquiz3.this,home2.class);
        startActivity(intent);
    }
}