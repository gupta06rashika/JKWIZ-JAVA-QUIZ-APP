package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class REVIEW extends AppCompatActivity {
private Button button17,button16,button15,button14,button13;
private TextView textView9,textView5;
private int index=0,comp2,index2=0,index3=0,flag=0,myindexis=0,comp,set=0,flag2=0;
    private String questions[]={"1. Which of the following is not OOPS concept in Java?","2. What best describes the term Object?","3. Which of the features of OOP reflect reusability of code","4. Java does not support _____________?","5. Encapsulation concept in java is",
            "6. ___ is used to find and fix bugs in java programs.","7. Which of the following for loop declaration is not valid ?","8. An interface with no field or methods is known as a___","9. jar stands for","10. How many threads can be executed at a time ?"};
    private String answers[]={"d","b","b","b","a","a","b","b","d","b"};
    private String option_a[]={"Inheritance","class","Encapsulation","Inheritance","Hiding complexity","JDB","for(int i=0;i<8;i++)","Runnable Interface","Java Archive Runner","Only one thread"};
    private String option_b[]={"Encapsulation","instance of a class","Inheritance","Multiple inheritance for classes","method hiding","JVM","for(int i=0;i<18;i/6)","Marker interface","Java Application Resource","Multiple thread"};
    private String option_c[]={"Polymorphism","The class extends from","Abstration","multiple inheritance of interfaces","Hiding constructor","JDK","for(int i=6;i>=1;--)","Abstract interface","Java Application Runner","Only main thread"};
    private String option_d[]={"Compilation","Parent class","Polymorphism","compile time polymorphism","None","JRE","for(int i=8;i<32;i=i-2)","CharSequence Interface","Java ARchive","Two thread"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_e_v_i_e_w);

        View decorView = getWindow().getDecorView();
// Hide the status bar.

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button15=findViewById(R.id.button15);
        button16=findViewById(R.id.button16);
        button17=findViewById(R.id.button17);
        textView9=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);

        Intent intent=getIntent();
        String user_ans=intent.getStringExtra("com.example.loginapp.userdata");
        String user_wrong_ans=intent.getStringExtra("com.example.loginapp.userdata.wronganswer");

        //Toast.makeText(REVIEW.this,""+user_ans,Toast.LENGTH_SHORT).show();
        int l=user_ans.length();
        int ll=user_wrong_ans.length();

        char[] answer=user_ans.toCharArray();
        char[] answer_wrong=user_wrong_ans.toCharArray();

        if(l!=0)
       {
           char my=answer[index2];
           char first='0';
           comp = Character.compare(my,first);

       }

        if(user_ans.isEmpty())
        {
            flag=1;
            int myindex=user_wrong_ans.indexOf('0');
            char bt=answer_wrong[myindex+1];
            comp2=Character.compare(bt,'a');
            if(comp2==0){

                button13.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'b');
            if(comp2==0){

                button14.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'c');
            if(comp2==0){

                button15.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'d');
            if(comp2==0){

                button16.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            myindexis=myindexis+2;
            textView5.setText("This is the correct answer ");

        }
       else if(comp==0)
        {    index2++;
            textView5.setText("Your Answer is correct");
        }
       else {
            int myindex=user_wrong_ans.indexOf('0');
            char bt=answer_wrong[myindex+1];
            comp2=Character.compare(bt,'a');
            if(comp2==0){

                button13.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'b');
            if(comp2==0){

                button14.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'c');
            if(comp2==0){

                button15.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'d');
            if(comp2==0){

                button16.setBackgroundColor(getResources().getColor(R.color.Red));
            }

            myindexis=myindexis+2;

            textView5.setText("This is the correct answer ");


       }
        button13.setText(option_a[index]);
        button14.setText(option_b[index]);
        button15.setText(option_c[index]);
        button16.setText(option_d[index]);
        textView9.setText(questions[index]);

        if(answers[index]=="d")
        {
            button16.setBackgroundColor(getResources().getColor(R.color.light_green));
        }

        else if(answers[index]=="c")
        {
            button15.setBackgroundColor(getResources().getColor(R.color.light_green));
        }
        else if(answers[index]=="b")
        {
            button14.setBackgroundColor(getResources().getColor(R.color.light_green));
        }
        else
        {
            button13.setBackgroundColor(getResources().getColor(R.color.light_green));
        }

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.setText("");

                    button16.setBackgroundColor(getResources().getColor(R.color.blue));
                    button15.setBackgroundColor(getResources().getColor(R.color.blue));
                    button14.setBackgroundColor(getResources().getColor(R.color.blue));
                    button13.setBackgroundColor(getResources().getColor(R.color.blue));


                if(index<questions.length-2)
                {
                    index++;

                    if(l!=0){

                    if(index2<=user_ans.length()-1)
                    {

                    char c=Character.forDigit(index,10);
                    char my=answer[index2];

                    comp = Character.compare(my,c); //comparing two characters

                               if(comp==0)
                                       {    index2++;
                                              set=1;
                                           textView5.setText("Your Answer is correct");
                                           }


        else {
            //char cc=Character.forDigit(index,10);
            //int myindex=user_wrong_ans.indexOf(cc);
            char bt=answer_wrong[myindexis+1];
            comp2=Character.compare(bt,'a');
            if(comp2==0){

                button13.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'b');
            if(comp2==0){

                button14.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'c');
            if(comp2==0){

                button15.setBackgroundColor(getResources().getColor(R.color.Red));
            }
            comp2=Character.compare(bt,'d');
            if(comp2==0){

                button16.setBackgroundColor(getResources().getColor(R.color.Red));
            }
                                   myindexis=myindexis+2;

      //                             Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
            textView5.setText("This is the correct answer ");

        }
    }
else{

  //  char cc=Character.forDigit(index,10);
//        int myindex=user_wrong_ans.indexOf(cc);
        char bt=answer_wrong[myindexis+1];
        comp2=Character.compare(bt,'a');
        if(comp2==0){

            button13.setBackgroundColor(getResources().getColor(R.color.Red));
        }
        comp2=Character.compare(bt,'b');
        if(comp2==0){

            button14.setBackgroundColor(getResources().getColor(R.color.Red));
        }
        comp2=Character.compare(bt,'c');
        if(comp2==0){

            button15.setBackgroundColor(getResources().getColor(R.color.Red));
        }
        comp2=Character.compare(bt,'d');
        if(comp2==0){

            button16.setBackgroundColor(getResources().getColor(R.color.Red));
        }
                        myindexis=myindexis+2;

    //                    Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
        textView5.setText("This is the correct answer ");

    }





}
if(l==0){

  //  char cc=Character.forDigit(index,10);
//    int myindex=user_wrong_ans.indexOf(cc);
    char bt=answer_wrong[myindexis+1];
    comp2=Character.compare(bt,'a');
    if(comp2==0){

        button13.setBackgroundColor(getResources().getColor(R.color.Red));
    }
    comp2=Character.compare(bt,'b');
    if(comp2==0){

        button14.setBackgroundColor(getResources().getColor(R.color.Red));
    }
    comp2=Character.compare(bt,'c');
    if(comp2==0){

        button15.setBackgroundColor(getResources().getColor(R.color.Red));
    }
    comp2=Character.compare(bt,'d');
    if(comp2==0){

        button16.setBackgroundColor(getResources().getColor(R.color.Red));
    }
    myindexis=myindexis+2;

  //  Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
    textView5.setText("This is the correct answer ");

}

                     button13.setText(option_a[index]);
                    button14.setText(option_b[index]);
                    button15.setText(option_c[index]);
                    button16.setText(option_d[index]);
                    textView9.setText(questions[index]);
//
//                    button16.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button15.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button14.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button13.setBackgroundColor(getResources().getColor(R.color.blue));

                    if(answers[index]=="d")
                    {
                        button16.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }

                    else if(answers[index]=="c")
                    {
                        button15.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                    else if(answers[index]=="b")
                    {
                        button14.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                    else
                    {
                        button13.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                }
                else if(index==questions.length-2){

                    index++;
                 if(flag!=1){
                     if(index2<=user_ans.length()-1){

                         char c=Character.forDigit(index,10);
                         char my=answer[index2];

                         comp = Character.compare(my,c);

                         if(comp==0)
                         {    index2++;

                             textView5.setText("Your Answer is correct");
                         }
                         else {
//                             char cc=Character.forDigit(index,10);
  //                           int myindex=user_wrong_ans.indexOf(cc);
                             char bt=answer_wrong[myindexis+1];
                             comp2=Character.compare(bt,'a');
                             if(comp2==0){

                                 button13.setBackgroundColor(getResources().getColor(R.color.Red));
                             }
                             comp2=Character.compare(bt,'b');
                             if(comp2==0){

                                 button14.setBackgroundColor(getResources().getColor(R.color.Red));
                             }
                             comp2=Character.compare(bt,'c');
                             if(comp2==0){

                                 button15.setBackgroundColor(getResources().getColor(R.color.Red));
                             }
                             comp2=Character.compare(bt,'d');
                             if(comp2==0){

                                 button16.setBackgroundColor(getResources().getColor(R.color.Red));
                             }
                             myindexis=myindexis+2;

             //                Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
                             textView5.setText("This is the correct answer ");
                         }
                     }

                     else

                     { //  char cc=Character.forDigit(index,10);
                        // int myindex=user_wrong_ans.indexOf(cc);
                         char bt=answer_wrong[myindexis+1];
                         comp2=Character.compare(bt,'a');
                         if(comp2==0){

                             button13.setBackgroundColor(getResources().getColor(R.color.Red));
                         }
                         comp2=Character.compare(bt,'b');
                         if(comp2==0){

                             button14.setBackgroundColor(getResources().getColor(R.color.Red));
                         }
                         comp2=Character.compare(bt,'c');
                         if(comp2==0){

                             button15.setBackgroundColor(getResources().getColor(R.color.Red));
                         }
                         comp2=Character.compare(bt,'d');
                         if(comp2==0){

                             button16.setBackgroundColor(getResources().getColor(R.color.Red));
                         }

           //              Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
                         textView5.setText("This is the correct answer ");
                         myindexis=myindexis+2;

                     }

                 }
                 else if (l==0){

//                     char cc=Character.forDigit(index,10);
  //                   int myindex=user_wrong_ans.indexOf(cc);
                     char bt=answer_wrong[myindexis+1];
                     comp2=Character.compare(bt,'a');
                     if(comp2==0){

                         button13.setBackgroundColor(getResources().getColor(R.color.Red));
                     }
                     comp2=Character.compare(bt,'b');
                     if(comp2==0){

                         button14.setBackgroundColor(getResources().getColor(R.color.Red));
                     }
                     comp2=Character.compare(bt,'c');
                     if(comp2==0){

                         button15.setBackgroundColor(getResources().getColor(R.color.Red));
                     }
                     comp2=Character.compare(bt,'d');
                     if(comp2==0){

                         button16.setBackgroundColor(getResources().getColor(R.color.Red));
                     }
                     myindexis=myindexis+2;

         //            Toast.makeText(REVIEW.this,""+bt,Toast.LENGTH_SHORT).show();
                     textView5.setText("This is the correct answer ");
                 }

                    button13.setText(option_a[index]);
                    button14.setText(option_b[index]);
                    button15.setText(option_c[index]);
                    button16.setText(option_d[index]);
                    textView9.setText(questions[index]);
//
//                    button16.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button15.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button14.setBackgroundColor(getResources().getColor(R.color.blue));
//                    button13.setBackgroundColor(getResources().getColor(R.color.blue));

                    button17.setVisibility(View.INVISIBLE);


                    if(answers[index]=="d")
                    {
                        button16.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }

                    else if(answers[index]=="c")
                    {
                        button15.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                    else if(answers[index]=="b")
                    {
                        button14.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                    else
                    {
                        button13.setBackgroundColor(getResources().getColor(R.color.light_green));
                    }
                }

            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(REVIEW.this,home2.class);
        startActivity(intent);
    }
}