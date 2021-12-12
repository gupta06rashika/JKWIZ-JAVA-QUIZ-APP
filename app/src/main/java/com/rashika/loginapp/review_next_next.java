package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class review_next_next extends AppCompatActivity {private
String big_questions[]={"  int x=3,y=5,z=10; \n System.out.print(++z+y-y+z+x++);  \n\n  OUTPUT ????",
        "  int a=2; \n switch(a)\n {\n case 1: System.out.print(a) ; break; \n case 2: System.out.print(a);\n case 3: System.out.print(a);\n Default:System.out.print(a+4);\n }\n  \nOUTPUT ????","int []arr=new int[]{1,2,3,4}; \n arr[2]=3;\n arr[arr[2]]=7;\n arr[0]=5; \n \n System.out.print(arr[3]) is ????",
        "  int n=5; \n  while(n) { \n  System.out.print(n);\n  n--;\n  System.out.print(n+2); \n  }"," int f=1 \n int n=5; \n for(int i=2;i<=n;i++) \n  {\n    f=f*i \n  }\n System.out.print(f);\n \n OUTPUT ???? ",
        " int flag =0,n=5;  \n for(int i=2;i<n;i++) \n  {\n if((n%i)==0)) \n  { \n flag=1 ; \n break ;\n  }\n  } \n if (flag == ????) \n  {\n System.out.print(n is prime no);\n }","  for(int i=0 ; i<4; i++) \n   {\n    System.out.print(i);\n    i++; \n  }\n\n  OUTPUT ????","  int k=5,j=6 ; \n  do \n {\n   System.out.print(j+k); \n   k=k-2; \n }\n  while(k>=3);\n \n OUTPUT ????",
        "  int k=0;\n for(k=0;k<5;k++); \n System.out.print(k); \n\n  OUTPUT ????","  int a=0,b=0,c=0;\n  while((a<7)&&(b<17)&&(c<4))\n { \n   a++;\n   b++; \n   c++; \n } \n  System.out.print(a);\n  System.out.print(a); \n\n  OUTPUT ????"};
private String small_question[]={"1. What Does It Prints ?","2. Find The Output","3. Array Code","4. Find the Output","5. Code For Finding Factorial","6. Code For Finding n Is Prime Number Or Not","7. Find Output","8. Find Output","9. Find The Output","10. Find The Output"};
private String answers[]={"25","226","7","5645342312","120","0","02","119","5","44"};

    private TextView textView27,textView30,textView29;
    private TextView editTextTextPersonName3;
    private Button button24;
    private int index=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_next_next);
//
//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        editTextTextPersonName3=findViewById(R.id.editTextTextPersonName3);
        textView27=findViewById(R.id.textView27); //question
        textView29=findViewById(R.id.textView29); //small question
        textView30=findViewById(R.id.textView30);
        button24=findViewById(R.id.button24);

        Intent intent1=getIntent();
        String rightanswer=intent1.getStringExtra("com.example.loginapp.ans.ans.ans");

        if(rightanswer.contains(String.valueOf(index))){
            textView30.setText("Your Answer is correct");
        }
        else {
            textView30.setText("This is the correct answer");
        }

        textView27.setText(big_questions[index]);
        textView29.setText(small_question[index]);
        editTextTextPersonName3.setText(answers[index]);
        index++;


        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index <= big_questions.length - 2) {
                    textView27.setText(big_questions[index]);
                    textView29.setText(small_question[index]);
                    editTextTextPersonName3.setText(answers[index]);


                    if(rightanswer.contains(String.valueOf(index))){
                        textView30.setText("Your Answer is correct");
                    }
                    else {
                        textView30.setText("This is the correct answer");
                    }

                    index++;

                }
                else {

                    textView27.setText(big_questions[index]);
                    textView29.setText(small_question[index]);
                    editTextTextPersonName3.setText(answers[index]);


                    if(rightanswer.contains(String.valueOf(index))){
                        textView30.setText("Your Answer is correct");
                    }
                    else {
                        textView30.setText("This is the correct answer");
                    }
                    index++;

                    button24.setVisibility(View.INVISIBLE);
                    index++;
                }

            }
            });


    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(review_next_next.this,home2.class);
        startActivity(intent);
    }
}