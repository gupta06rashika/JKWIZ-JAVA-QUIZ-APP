package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class oops1 extends AppCompatActivity {
    public static final String EXTRA_SCORE_2="androidx.appcompat.app.AppCompatActivity.score.myuniquekey";

    public static final String EXTRA_SCORE_POSITIVE="androidx.appcompat.app.AppCompatActivity.score.positive";
    public static final String EXTRA_SCORE_NEGATIVE="androidx.appcompat.app.AppCompatActivity.score.negative";

    public static final long mytimertime=300000;
    private long timeleft;

    private TextView textView9;
    private Button buttona;
    private Button buttonb;
    private Button buttonc;
    private Button buttond;
    private TextView timer;
    private int index=0,score=0;
    private String positive="",negative="";
    private String sc;
    private Dialog dialog;
    public CountDownTimer countDownTimer;
    private String questions[]={"1. Which of the following is not OOPS concept in Java?","2. What best describes the term Object?","3. Which of the features of OOP reflect reusability of code","4. Java does not support _____________?","5. Encapsulation concept in java is",
            "6. ___ is used to find and fix bugs in java programs.","7. Which of the following for loop declaration is not valid ?","8. An interface with no field or methods is known as a___","9. jar stands for","10. How many threads can be executed at a time ?"};
    private String answers[]={"d","b","b","b","a","a","b","b","d","b"};
    private String option_a[]={"Inheritance","class","Encapsulation","Inheritance","Hiding complexity","JDB","for(int i=0;i<8;i++)","Runnable Interface","Java Archive Runner","Only one thread"};
    private String option_b[]={"Encapsulation","instance of a class","Inheritance","Multiple inheritance for classes","method hiding","JVM","for(int i=0;i<18;i/6)","Marker interface","Java Application Resource","Multiple thread"};
    private String option_c[]={"Polymorphism","The class extends from","Abstration","multiple inheritance of interfaces","Hiding constructor","JDK","for(int i=6;i>=1;--)","Abstract interface","Java Application Runner","Only main thread"};
    private String option_d[]={"Compilation","Parent class","Polymorphism","compile time polymorphism","None","JRE","for(int i=8;i<32;i=i-2)","CharSequence Interface","Java ARchive","Two thread"};
// Which of the following is a type of polymorphism in Java?
    //Compile time polymorphism
    //Execution time polymorphism
    //Multiple polymorphism
    //When does method overloading is determined?
    //At run time
    //At compile time
    //At coding time
    //At execution time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   getSupportActionBar().hide();


        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_oops1);
        textView9=findViewById(R.id.textView9);
        buttona=findViewById(R.id.buttona);
        buttonb=findViewById(R.id.buttonb);
        buttonc=findViewById(R.id.buttonc);
        buttond=findViewById(R.id.buttond);
        timer=findViewById(R.id.timer);

        dialog=new Dialog(oops1.this);

        textView9.setText(questions[index]);  //setting qusetions for first time
        buttona.setText(option_a[index]);
        buttonb.setText(option_b[index]);
        buttonc.setText(option_c[index]);
        buttond.setText(option_d[index]);

        if(index<questions.length){
            timer.setText(String.valueOf(mytimertime/10000));

        }
        else {
            timer.setText(" ");
        }
        countDownTimer=new CountDownTimer(mytimertime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft=millisUntilFinished/1000;
                timer.setText(String.valueOf(timeleft));
            }

            @Override
            public void onFinish() {
             Toast.makeText(oops1.this,"TIMES UP",Toast.LENGTH_SHORT).show();
                if(score>7){
                    //go to next page
                    index=questions.length;
                    sc=String.valueOf(score);

                    //countDownTimer.cancel();
                    Intent intent=new Intent(oops1.this,oopsresult.class);
                    intent.putExtra(EXTRA_SCORE_2,sc);
                    intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                    intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                    startActivity(intent);
                   // Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                }
                else{

                    //go to next page
                    index=questions.length;
                    sc=String.valueOf(score);
                    // countDownTimer.cancel();
                    Intent intent=new Intent( oops1.this,oopsresult2.class);
                   intent.putExtra(EXTRA_SCORE_2,sc);
                    intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                    intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                    startActivity(intent);
                    // Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();

                }

            }
        };
        if(index<questions.length){  //Timer should not start if we complete the quiz

           countDownTimer.start();

        }

        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<questions.length-1)       {


                    if(answers[index]=="a")
                    {
                        score++;
                        positive=positive.concat(Integer.toString(index));
//                        buttona.setBackgroundColor(getResources().getColor(R.color.light_green));

                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);
      //                  buttona.setBackgroundColor(getResources().getColor(R.color.blue));

                    }
                    else {
                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("a");



    //                    buttona.setBackgroundColor(getResources().getColor(R.color.Red));

                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);
  //                      buttona.setBackgroundColor(getResources().getColor(R.color.blue));

                    }

                }
                else if(index==questions.length-1){

                    if(answers[index]=="a")
                    {
                        score++;


                        positive=positive.concat(Integer.toString(index));
                        //              buttona.setBackgroundColor(getResources().getColor(R.color.light_green));

        //                buttona.setBackgroundColor(getResources().getColor(R.color.blue));

                        if(score>7){
                            //go to next page
                            countDownTimer.cancel();
                            sc=String.valueOf(score);

                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);
                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

            //                buttona.setBackgroundColor(getResources().getColor(R.color.Red));

                            //go to next page
              //              buttona.setBackgroundColor(getResources().getColor(R.color.blue));

                            countDownTimer.cancel();
                            sc=String.valueOf(score);
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);
                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();

                        }

                     index++;
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("a");

                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                            //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

                            //go to next page

                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                           // Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();

                        }

                        index++;
                    }
                }




                else{

                    if(index>=questions.length){

                        Toast.makeText(oops1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                        buttonb.setEnabled(false);
                        buttona.setEnabled(false);
                        buttonc.setEnabled(false);
                        buttond.setEnabled(false);
                    }
                }
            }
        });


        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<questions.length-1)       {


                    if(answers[index]=="b")
                    {


                        score++;


                        positive=positive.concat(Integer.toString(index));
                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("b");

                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);

                    }

                }
                else if(index==questions.length-1){

                    if(answers[index]=="b")
                    {
                        score++;


                        positive=positive.concat(Integer.toString(index));

                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);

                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

                            //go to next page
                            countDownTimer.cancel();

                            sc=String.valueOf(score);
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();

                        }

                        index++;
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("b");

                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

                            //go to next page

                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();

                        }

                        index++;
                    }
                }




                else{

                    if(index>=questions.length){
                        Toast.makeText(oops1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                        buttonb.setEnabled(false);
                        buttona.setEnabled(false);
                        buttonc.setEnabled(false);
                        buttond.setEnabled(false);

                    }
                }
            }
        });


        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<questions.length-1)       {


                    if(answers[index]=="c")
                    {
                        score++;


                        positive=positive.concat(Integer.toString(index));
                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("c");
                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);

                    }

                }
                else if(index==questions.length-1){

                    if(answers[index]=="c")
                    {
                        score++;

                        positive=positive.concat(Integer.toString(index));
                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{
                            //go to next page

                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }

                        index++;
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("c");
                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{
                            //go to next page

                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);
                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }

                        index++;
                    }
                }
                else{

                    if(index>=questions.length){
                        Toast.makeText(oops1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                        buttonb.setEnabled(false);
                        buttona.setEnabled(false);
                        buttonc.setEnabled(false);
                        buttond.setEnabled(false);

                    }
                }
            }
        });


        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<questions.length-1)       {


                    if(answers[index]=="d")
                    {
                        score++;

                        positive=positive.concat(Integer.toString(index));

                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("d");
                        index++;
                        buttona.setText(option_a[index]);
                        buttonb.setText(option_b[index]);
                        buttonc.setText(option_c[index]);
                        buttond.setText(option_d[index]);
                        textView9.setText(questions[index]);

                    }

                }
                else if(index==questions.length-1){

                    if(answers[index]=="d")
                    {
                        score++;

                        positive=positive.concat(Integer.toString(index));

                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);

                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

                            //go to next page

                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);
                            startActivity(intent);
                            //Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }

                        index++;
                    }
                    else {

                        negative=negative.concat(Integer.toString(index));
                        negative=negative.concat("d");
                        if(score>7){
                            //go to next page
                            sc=String.valueOf(score);
                            countDownTimer.cancel();
                            Intent intent=new Intent(oops1.this,oopsresult.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);
                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);


                            startActivity(intent);
                             //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                        }
                        else{

                            //go to next page

                            sc=String.valueOf(score);
                            Intent intent=new Intent( oops1.this,oopsresult2.class);
                            intent.putExtra(EXTRA_SCORE_2,sc);
                            intent.putExtra(EXTRA_SCORE_POSITIVE,positive);

                            intent.putExtra(EXTRA_SCORE_NEGATIVE,negative);
                            countDownTimer.cancel();
                            startActivity(intent);
                            //Toast.makeText( MainActivity.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/5",Toast.LENGTH_LONG).show();

                        }

                        index++;
                    }
                }
                else{

                    if(index>=questions.length){
                        Toast.makeText(oops1.this ,"YOUR QUIZ IS OVER",Toast.LENGTH_SHORT).show();
                        buttonb.setEnabled(false);
                        buttona.setEnabled(false);
                        buttonc.setEnabled(false);
                        buttond.setEnabled(false);

                    }
                }
            }
        });
    }
    //@Override
    public void onBackPressed() {

        dialog.setContentView(R.layout.quiz_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn19=dialog.findViewById(R.id.myyes);//yes
        Button btn10=dialog.findViewById(R.id.myno);//no

        btn19.setOnClickListener(new View.OnClickListener() {  //ON CLICKING YES BUTTON
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent=new Intent(oops1.this,home2.class);
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
        //super.onBackPressed();
    }
}
