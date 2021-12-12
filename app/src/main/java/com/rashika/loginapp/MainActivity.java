package com.rashika.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button3;
    private Button skip;
    private EditText editText;
    private EditText editText2;
    private TextView forget;
    private Dialog dialog;
    FirebaseAuth fauth;
    ProgressBar progressBar;
    Dialog dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        if (Build.VERSION.SDK_INT < 16) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }
//        else{
//
//            View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//
//        }
//
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button = findViewById(R.id.button);//create an account
        dialog=new Dialog(MainActivity.this);

        dialog2=new Dialog(MainActivity.this);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPassword);
        button3 = findViewById(R.id.button3);//login
        forget=findViewById(R.id.forget);
        skip=findViewById(R.id.skip);
        progressBar = findViewById(R.id.progressBar);
        fauth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,home2.class);
                startActivity(intent);
            }
        });
               //login
    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email1=editText.getText().toString().trim();
            String pass1=editText2.getText().toString().trim();
            if(TextUtils.isEmpty(email1)){
                editText.setError("Email is required");
            }
            else if(TextUtils.isEmpty(pass1)){
                editText2.setError("password is required");
            }

            else if(pass1.length()<6){
                editText2.setError("password length should atleast be 6");
            }
            else {
                fauth.signInWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //progressBar.setVisibility(View.VISIBLE);
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,home2.class);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(MainActivity.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
           // progressBar.setVisibility(View.VISIBLE);
        }
    });
            forget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog2.setContentView(R.layout.forget_password);
                    dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    EditText writemail=dialog2.findViewById(R.id.editTextTextPersonName4);
                    Button yess=dialog2.findViewById(R.id.button19);  //yes
                        Button noo=dialog2.findViewById(R.id.button10); //no

                    yess.setOnClickListener(new View.OnClickListener() {  //ON CLICKING YES BUTTON
                        @Override
                        public void onClick(View v) {

                          String email=writemail.getText().toString();
                          if(email.isEmpty()){
                              Toast.makeText(MainActivity.this,"Enter email it cant be empty",Toast.LENGTH_SHORT).show();
                              dialog2.dismiss();

                          }
                          else{
                              fauth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                                  @Override
                                  public void onSuccess(Void aVoid) {

                                      Toast.makeText(MainActivity.this,"Reset link is send to your email",Toast.LENGTH_SHORT).show();
                                      dialog2.dismiss();

                                  }
                              }).addOnFailureListener(new OnFailureListener() {
                                  @Override
                                  public void onFailure(@NonNull Exception e) {
                                      Toast.makeText(MainActivity.this," "+e.getMessage(),Toast.LENGTH_SHORT).show();
                                      dialog2.dismiss();

                                  }
                              });

                          }
                        }
                    });
                    noo.setOnClickListener(new View.OnClickListener() {  //ON CLICKING NO BUTTON
                        @Override
                        public void onClick(View v) {
                            dialog2.dismiss();

                        }
                    });
                    dialog2.show();
                }
            });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        dialog.setContentView(R.layout.u_want_to_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn11=dialog.findViewById(R.id.button11);
        Button btn9=dialog.findViewById(R.id.button9);

        btn11.setOnClickListener(new View.OnClickListener() {  //ON CLICKING YES BUTTON
            @Override
            public void onClick(View v) {
                finishAffinity();
                finish();

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {  //ON CLICKING NO BUTTON
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }

}