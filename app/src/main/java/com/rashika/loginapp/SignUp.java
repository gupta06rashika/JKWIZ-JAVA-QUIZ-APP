package com.rashika.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private Button button4; //submit
    private Button button3; //create an account
    private EditText editText3;
    private  EditText editText4;
    private  EditText editText5;
    private ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//
//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        auth=FirebaseAuth.getInstance();
        button3=findViewById(R.id.button2);//SUBMIT
        button4=findViewById(R.id.button4);
        editText3=findViewById(R.id.editTextTextPersonName); //name
        editText4=findViewById(R.id.editTextTextPersonName8); //email
        editText5=findViewById(R.id.editTextTextPersonName9); //password
        progressBar=findViewById(R.id.progressBar);
// Already an Account
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
// on clicking submit button
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= editText4.getText().toString().trim();
                String password=editText5.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    editText4.setError("EMAIL IS REQUIRED");
                }
                else if (TextUtils.isEmpty(password)){
                    editText5.setError("PASSWORD IS REQUIRED");
                }
                else if (password.length()<6){
                    editText5.setError("PASSWORD LENGTH IS ATLEAST 6");
                }
          //      progressBar.setVisibility(View.VISIBLE);
                else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //Toast.makeText(SignUp.this, "USER CREATED", Toast.LENGTH_SHORT).show();
                                Intent intent2=new Intent(SignUp.this,MainActivity.class);
                                startActivity(intent2);
                            }
                            else {
                                Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                //                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(SignUp.this,MainActivity.class);
        startActivity(intent);

    }
}