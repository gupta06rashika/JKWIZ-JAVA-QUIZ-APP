package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fillintheblanks extends AppCompatActivity {

public static final long mytimertimeis=300000;
public static final String EXTRA_SCORE_2="com.example.loginapp.fillintheblanks.marks";
public static final String EXTRA_SCORE_2_rightanswer="com.example.loginapp.fillintheblanks.marks.right.answer";
//private static final String TAG="MtActivity";
private TextView textView11,textView12,textView13;
private Button button5;
private EditText editText;
private CountDownTimer countDownTimer;
private int index=0,score=0;
private Dialog dialog;
private  String rightanswers="";

private String big_questions[]={"  int x=3,y=5,z=10; \n System.out.print(++z+y-y+z+x++);  \n\n  OUTPUT ????",
        "  int a=2; \n switch(a)\n {\n case 1: System.out.print(a) ; break; \n case 2: System.out.print(a);\n case 3: System.out.print(a);\n Default:System.out.print(a+4);\n }\n  \nOUTPUT ????","int []arr=new int[]{1,2,3,4}; \n arr[2]=3;\n arr[arr[2]]=7;\n arr[0]=5; \n \n System.out.print(arr[3]) is ????",
        "  int n=5; \n  while(n) { \n  System.out.print(n);\n  n--;\n  System.out.print(n+2); \n  }"," int f=1 \n int n=5; \n for(int i=2;i<=n;i++) \n  {\n    f=f*i \n  }\n System.out.print(f);\n \n OUTPUT ???? ",
       " int flag =0,n=5;  \n for(int i=2;i<n;i++) \n  {\n if((n%i)==0)) \n  { \n flag=1 ; \n break ;\n  }\n  } \n if (flag == ????) \n  {\n System.out.print(n is prime no);\n }","  for(int i=0 ; i<4; i++) \n   {\n    System.out.print(i);\n    i++; \n  }\n\n  OUTPUT ????","  int k=5,j=6 ; \n  do \n {\n   System.out.print(j+k); \n   k=k-2; \n }\n  while(k>=3);\n \n OUTPUT ????",
        "  int k=0;\n for(k=0;k<5;k++); \n System.out.print(k); \n\n  OUTPUT ????","  int a=0,b=0,c=0;\n  while((a<7)&&(b<17)&&(c<4))\n { \n   a++;\n   b++; \n   c++; \n } \n  System.out.print(a);\n  System.out.print(a); \n\n  OUTPUT ????"};
private String small_question[]={"1. What Does It Prints ?","2. Find The Output","3. Array Code","4. Find the Output","5. Code For Finding Factorial","6. Code For Finding n Is Prime Number Or Not","7. Find Output","8. Find Output","9. Find The Output","10. Find The Output"};
private String answers[]={"25","226","7","5645342312","120","0","02","119","5","44"};
private TextView textView14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillintheblanks);
  //      Log.d(TAG, "onCreate: ");
//
////
//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        textView11=findViewById(R.id.textView11);
        textView12=findViewById(R.id.textView12);
        textView13=findViewById(R.id.textView13);
        button5=findViewById(R.id.button5);
        textView14=findViewById(R.id.textView14);
        editText=findViewById(R.id.editTextTextPersonName2);

        dialog=new Dialog(fillintheblanks.this);

        textView12.setText(big_questions[index]);
        textView11.setText(small_question[index]);


        countDownTimer=new CountDownTimer(mytimertimeis,1000) {
////            @Override
            public void onTick(long millisUntilFinished) {
                textView14.setText(String.valueOf(millisUntilFinished/1000));
////
////
            }
////
////            @Override
            public void onFinish() {
                Toast.makeText(fillintheblanks.this,"TIMES UP",Toast.LENGTH_SHORT).show();
                if(score>=7)
                {
////                    //go to next page
                    index=big_questions.length;
                    String sc=String.valueOf(score);
////
////                 //   countDownTimer.cancel();
                    Intent intent=new Intent(fillintheblanks.this,fillintheblanks_result_win.class);
                    intent.putExtra(EXTRA_SCORE_2,sc);
                    intent.putExtra(EXTRA_SCORE_2_rightanswer,rightanswers);
                    startActivity(intent);
////                    //Toast.makeText(oops1.this ,"CONGRATULATIONS YOU ARE A GOOD PLAYER ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
                }
                else{
////
////                    //go to next page
                    index=big_questions.length;
                    String sc=String.valueOf(score);
////                    // countDownTimer.cancel();
////                    //countDownTimer.cancel();
                    Intent intent=new Intent( fillintheblanks.this,fillintheblanks_sad.class);
                    intent.putExtra(EXTRA_SCORE_2,sc);
////
                    intent.putExtra(EXTRA_SCORE_2_rightanswer,rightanswers);
                    startActivity(intent);
////                    // Toast.makeText( oops1.this ,"WORK HARD AND COME AGAIN ,YOUR SCORE IS "+ score +"/"+questions.length,Toast.LENGTH_LONG).show();
////
                }
////
////            }
////
////
////        };
            }
            };

        if(index<big_questions.length){  //Timer should not start if we complete the quiz

            countDownTimer.start();
                                  }
////
////
//
        button5.setOnClickListener(new View.OnClickListener() {           // On CLICKING SUBMIT BUTTON
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                if(index<big_questions.length-1)
                {
                    String myinput=editText.getText().toString().trim();

                   //Toast.makeText(fillintheblanks.this,"IM IN : "+ myinput,Toast.LENGTH_SHORT).show();
                      //score++;
                    if(myinput.contentEquals(answers[index])){
                        //Toast.makeText(fillintheblanks.this,"SCORE : "+score,Toast.LENGTH_SHORT).show();

                        score=score+1;
                        rightanswers=rightanswers.concat(String.valueOf(index));

                      // Toast.makeText(fillintheblanks.this,"IM IN : ",Toast.LENGTH_SHORT).show();
                 //       editText.setBackgroundColor(R.color.light_green);


                    }
                   else {
                       // editText.setBackgroundColor(R.color.Red);


                    }

                    index++;

                    editText.setText("");
                    textView12.setText(big_questions[index]);
                    textView11.setText(small_question[index]);
            //        editText.setBackgroundColor(R.color.white);

                    //String scc=String.valueOf(score);
                    //Toast.makeText(fillintheblanks.this,"sc0re : "+scc,Toast.LENGTH_SHORT).show();

                }
                else if(index==big_questions.length-1){

                    String myinput=editText.getText().toString().trim();

                    //  input = editText.getText();
                    if(myinput.contentEquals(answers[index])){
                        rightanswers=rightanswers.concat(String.valueOf(index));

                        score++;
                   //     editText.setBackgroundColor(R.color.light_green);


                    }
                    else{
                     //   editText.setBackgroundColor(R.color.Red);


                    }
                    index++;

                    if(score<7)
                    {

                        String sc;
                        sc=String.valueOf(score);
                      //  Toast.makeText(fillintheblanks.this,"SCORE : "+sc,Toast.LENGTH_SHORT).show();
                        countDownTimer.cancel();
                        Intent intent=new Intent(fillintheblanks.this,fillintheblanks_sad.class);
                        intent.putExtra(EXTRA_SCORE_2,sc);
                        intent.putExtra(EXTRA_SCORE_2_rightanswer,rightanswers);
                        startActivity(intent);

                    }
                    else
                    {
                        String sc;
                        sc=String.valueOf(score);
                        //Toast.makeText(fillintheblanks.this,"SCORE : "+sc,Toast.LENGTH_SHORT).show();
                        countDownTimer.cancel();
                        Intent intent=new Intent(fillintheblanks.this,fillintheblanks_result_win.class);
                        intent.putExtra(EXTRA_SCORE_2,sc);
                        intent.putExtra(EXTRA_SCORE_2_rightanswer,rightanswers);
                        startActivity(intent);

                    }
                }
                else {
                    //score++;
                    Toast.makeText(fillintheblanks.this,"QUIZ OVER",Toast.LENGTH_SHORT).show();
                    button5.setEnabled(false);
                   editText.setEnabled(false);

                }
            }
        });

    }
    public void onBackPressed() {

        dialog.setContentView(R.layout.quiz_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn19=dialog.findViewById(R.id.myyes);//yes
        Button btn10=dialog.findViewById(R.id.myno);//no

        btn19.setOnClickListener(new View.OnClickListener() {  //ON CLICKING YES BUTTON
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent=new Intent(fillintheblanks.this,home2.class);
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


    //    super.onBackPressed();
    }

}