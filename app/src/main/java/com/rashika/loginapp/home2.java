package com.rashika.loginapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home2 extends AppCompatActivity {
private Button button6;
private Button button7;
private Button button8;
Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button8=findViewById(R.id.button8);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        dialog=new Dialog(home2.this);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_questions);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btn=dialog.findViewById(R.id.button10);
                btn.setOnClickListener(new View.OnClickListener() {  //ON CLICKING OK BUTTON
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home2.this,javaquiz1.class);
                        startActivity(intent);

                    }
                });
                dialog.show();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setContentView(R.layout.dialog_questions);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btn=dialog.findViewById(R.id.button10);
                btn.setOnClickListener(new View.OnClickListener() {  //ON CLICKING OK BUTTON
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home2.this,oops1.class);
                        startActivity(intent);

                    }
                });
                dialog.show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_questions);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btn=dialog.findViewById(R.id.button10);
                btn.setOnClickListener(new View.OnClickListener() {  //ON CLICKING OK BUTTON
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home2.this,fillintheblanks.class);
                        startActivity(intent);

                    }
                });
                dialog.show();

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(home2.this,MainActivity.class);
        startActivity(intent);

    }
}