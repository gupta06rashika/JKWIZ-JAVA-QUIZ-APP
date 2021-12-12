package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.os.CountDownTimer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class javaquiz1 extends AppCompatActivity {
    public static final String EXTRA_SCORE="androidx.appcompat.app.AppCompatActivity.score";
    public static final String EXTRA_SCORE_right_ans_1="androidx.appcompat.app.AppCompatActivity.score.right.answer.1";
    public static final long mytimertimeis=100000;

    private Button yes;
    private Button no;
    private TextView textView,textView7;
  //  private TextView timer2;
    private int index=0,score=0;
    private String sc,right_ans="";
    private Dialog dialog;
    CountDownTimer countDownTimer;
    private long timeleftiss;
    private String questionsare[]={"1. JAVA IS INTRODUCED IN 1996?","2. JAVA IS OBJECT ORIENTED LANG?","3. JAVA IS WRITTEN IN PYTHON?","4. JAVA IS USED FOR APP DEVELOPMENT","5. JAVA CONTAINS POINTERS?"
            ,"6. CAN A CLASS EXTENDS INTERFACE ?","7. CONSTRUCTER MUST HAVE SAME NAME AS THE CLASS NAME?","8. IS STRING IS IMMUTABLE OBJECT ?","9. IS RUNNABLE A MARKER INTERFACE?",
            "10. JVM STANDS FOR JAVA VIRTUAL MACHINE"};
    private boolean answersare[]={true,true,false,true,false,false,true,true,false,true};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaquiz1);

        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        yes=findViewById(R.id.button);
        no=findViewById(R.id.button2);
        textView7=findViewById(R.id.textView7);
        textView=findViewById(R.id.textView);
        dialog=new Dialog(javaquiz1.this);
        textView.setText(questionsare[index]);

        textView7.setText(String.valueOf(timeleftiss));
//    //    timer2.findViewById(R.id.timer2);
//
//        //if(index<5){
//       //     timer2.setText(String.valueOf(mytimertimeis/1000));
////        }
////        CountDownTimer countDownTimer=new CountDownTimer(mytimertimeis,1000) {
////            @Override
////            public void onTick(long millisUntilFinished) {
////                timeleftiss=millisUntilFinished/1000;
////                timer2.setText(String.valueOf(timeleftiss));
////            }
////
////            @Override
////            public void onFinish() {
////                Toast.makeText(javaquiz1.this,"TIMES UP",Toast.LENGTH_SHORT).show();
////
////                if(score>3){
////                    //go to next page
////                    index=questionsare.length;
////                    sc=String.valueOf(score);
////                    Intent intent=new Intent( javaquiz1.this,javaquiz2.class);
////                    intent.putExtra(EXTRA_SCORE,sc);
////                    startActivity(intent);
////                    // Toast.makeText(MainActivity.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();
////                }
////                else{
////
////                    //go to next page
////                    index=questionsare.length;
////                    sc=String.valueOf(score);
////                    Intent intent=new Intent( javaquiz1.this,javaquiz3.class);
////                    intent.putExtra(EXTRA_SCORE,sc);
////
////                    startActivity(intent);
////                    //Toast.makeText( MainActivity.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();
////
////                }
////
////
////
////            }
////        };
////        if(index<5){
////          countDownTimer.start(); //start timer
////        }
//
        countDownTimer=new CountDownTimer(mytimertimeis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView7.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
            Toast.makeText(javaquiz1.this,"TIMES UP",Toast.LENGTH_SHORT).show();

                if(score>7){
                    //go to next page

                    sc=String.valueOf(score);
                    countDownTimer.cancel();
                    index=questionsare.length+1;
                    Intent intent=new Intent( javaquiz1.this,javaquiz2.class);
                    intent.putExtra(EXTRA_SCORE,sc);
                    intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                    startActivity(intent);
                    // Toast.makeText(MainActivity.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();
                }
                else{

                    //go to next page

                    sc=String.valueOf(score);
                    countDownTimer.cancel();
                    index=questionsare.length+1;
                    Intent intent=new Intent( javaquiz1.this,javaquiz3.class);
                    intent.putExtra(EXTRA_SCORE,sc);

                    intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                    startActivity(intent);
                    //Toast.makeText( MainActivity.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();

                }




            }
        };

        if(index<questionsare.length){
            countDownTimer.start();
        }

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<questionsare.length){
                    if(answersare[index]){
                        right_ans=right_ans.concat(Integer.toString(index));
                        score++;
                    }}
                index++;
                if(index==questionsare.length){

                    if(score>7){
                        //go to next page

                        sc=String.valueOf(score);
                        countDownTimer.cancel();
                        Intent intent=new Intent( javaquiz1.this,javaquiz2.class);
                        intent.putExtra(EXTRA_SCORE,sc);
                        intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                        startActivity(intent);
                        // Toast.makeText(MainActivity.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();
                    }
                    else{

                        //go to next page

                        sc=String.valueOf(score);
                        countDownTimer.cancel();
                        Intent intent=new Intent( javaquiz1.this,javaquiz3.class);
                        intent.putExtra(EXTRA_SCORE,sc);

                        intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                        startActivity(intent);
                        //Toast.makeText( MainActivity.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();

                    }



                }
                if(index<questionsare.length){
                    textView.setText(questionsare[index]);
                }

                if(index>questionsare.length){
                    Toast.makeText(javaquiz1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                    yes.setEnabled(false);
                }
//                 else{
//                     To
//                 }

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<questionsare.length) {
                    if (!answersare[index]) {
                        right_ans=right_ans.concat(Integer.toString(index));
                        score++;
                    }
                }
                index++;

                if(index==questionsare.length){
                    if(score>7){

                        //go to next page

                        sc=String.valueOf(score);
                        countDownTimer.cancel();
                        Intent intent=new Intent( javaquiz1.this,javaquiz2.class);
                        intent.putExtra(EXTRA_SCORE,sc);

                        intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();
                    }
                    else{

                        //go to next page

                        sc=String.valueOf(score);
                        countDownTimer.cancel();
                        Intent intent=new Intent( javaquiz1.this,javaquiz3.class);
                        intent.putExtra(EXTRA_SCORE,sc);

                        intent.putExtra(EXTRA_SCORE_right_ans_1,right_ans);
                        startActivity(intent);
                        //  Toast.makeText(MainActivity.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();

                    }
                }
                if(index<questionsare.length){
                    textView.setText(questionsare[index]);
                }
                if(index>questionsare.length){

                    Toast.makeText(javaquiz1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                }
             }
        });

    }

    @Override
    public void onBackPressed() {

        dialog.setContentView(R.layout.quiz_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn19=dialog.findViewById(R.id.myyes);//yes
        Button btn10=dialog.findViewById(R.id.myno);//no

        btn19.setOnClickListener(new View.OnClickListener() {  //ON CLICKING YES BUTTON
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent=new Intent(javaquiz1.this,home2.class);
                startActivity(intent);

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {  //ON CLICKING NO BUTTON
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
//       super.onBackPressed();
    }
}