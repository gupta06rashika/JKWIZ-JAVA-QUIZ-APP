package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class next_review extends AppCompatActivity {
private TextView textView25,textView26;
private Button button18,button20,button21;
private String questionsare[]={"1. JAVA IS INTRODUCED IN 1996?","2. JAVA IS OBJECT ORIENTED LANG?","3. JAVA IS WRITTEN IN PYTHON?","4. JAVA IS USED FOR APP DEVELOPMENT","5. JAVA CONTAINS POINTERS?"
            ,"6. CAN A CLASS EXTENDS INTERFACE ?","7. CAN WE USE AN INTERFACE REFERENCES FOR REFERRING TO AN OBJECT?","8. IS STRING IS IMMUTABLE OBJECT ?","9. IS RUNNABLE A MARKER INTERFACE?",
            "10. JVM STANDS FOR JAVA VIRTUAL MACHINE"};
private boolean answersare[]={true,true,false,true,false,false,true,true,false,true};
private int index=0,myflag=0;

    private boolean comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_review);

        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView25=findViewById(R.id.textView25);
        textView26=findViewById(R.id.textView26); // OUTPUT
        button18=findViewById(R.id.button18);  //YES
        button20=findViewById(R.id.button20);   //NO
        button21=findViewById(R.id.button21);    //NEXT

        Intent intent=getIntent();
        String rightans = intent.getStringExtra("com.example.loginapp.userdata.data");

   //     Toast.makeText(next_review.this,""+rightans,Toast.LENGTH_SHORT).show();
      //  int l=rightans.length();

       // char[] answer=rightans.toCharArray();

        comp=rightans.contains("0");
        if(comp){
            textView26.setText("YOUR ANSWER IS CORRECT");
        }
        else
        {
            myflag=1;
            textView26.setText("THIS IS CORRECT ANSWER ");

        }
       textView25.setText(questionsare[index]);

       if(answersare[index]){
           button18.setBackgroundColor(getResources().getColor(R.color.light_green));

           if(myflag==1)
           {
               button20.setBackgroundColor(getResources().getColor(R.color.Red));
               myflag=0;
           }


       }
       else {
           button20.setBackgroundColor(getResources().getColor(R.color.light_green));

           if(myflag==1)
           {
               button18.setBackgroundColor(getResources().getColor(R.color.Red));
               myflag=0;
           }
       }
       index++;

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(index<=questionsare.length-2){

                  textView25.setText(questionsare[index]);
                  button18.setBackgroundColor(getResources().getColor(R.color.blue));
                  button20.setBackgroundColor(getResources().getColor(R.color.blue));


                  comp=rightans.contains(String.valueOf(index));
                  if(comp){
                           textView26.setText("YOUR ANSWER IS CORRECT");

                           }
                   else
                           {
                               myflag=1;
                           textView26.setText("THIS IS CORRECT ANSWER ");
                           }

                  if(answersare[index]){
                      button18.setBackgroundColor(getResources().getColor(R.color.light_green));
                      if(myflag==1)
                      {
                          button20.setBackgroundColor(getResources().getColor(R.color.Red));
                          myflag=0;
                      }

                  }
                  else {
                      if(myflag==1)
                      {
                          button18.setBackgroundColor(getResources().getColor(R.color.Red));
                          myflag=0;
                      }

                      button20.setBackgroundColor(getResources().getColor(R.color.light_green));

                  }
                  index++;
              }
              else{

                  button18.setBackgroundColor(getResources().getColor(R.color.blue));
                  button20.setBackgroundColor(getResources().getColor(R.color.blue));

                  textView25.setText(questionsare[index]);

                  comp=rightans.contains(String.valueOf(index));
                  if(comp){
                           textView26.setText("YOUR ANSWER IS CORRECT");
                           }
                   else
                           {
                               myflag=1;
                           textView26.setText("THIS IS CORRECT ANSWER ");
                           }

                  if(answersare[index]){
                      button18.setBackgroundColor(getResources().getColor(R.color.light_green));
                      if(myflag==1)
                      {
                          button20.setBackgroundColor(getResources().getColor(R.color.Red));
                          myflag=0;
                      }

                  }
                  else {
                      if(myflag==1)
                      {
                          button18.setBackgroundColor(getResources().getColor(R.color.Red));
                          myflag=0;
                      }

                      button20.setBackgroundColor(getResources().getColor(R.color.light_green));

                  }
                  button21.setVisibility(View.INVISIBLE);
                  index++;
              }

            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(next_review.this,home2.class);
        startActivity(intent);
    }
}