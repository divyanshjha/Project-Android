package com.example.attempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn,backtologin;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backtologin  = findViewById(R.id.reg_login_btn);
        backtologin.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent (SignUp.this,Login.class);
                startActivity(intent);


            }

        } );

//CUTPASTE


        //Hooks to all xml elements in activity_sign_up
        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.reg_login_btn);

        //Save data on Firebase when button is clicked

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = "https://console.firebase.google.com/u/0/project/travel-nest-27cd7/database/travel-nest-27cd7-default-rtdb/data;
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user-data");
                //reference = rootNode.getReferenceFromUrl(url);

                //Get all the values
                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }else if (password.length()<6){
                    Toast.makeText(SignUp.this,"Password must be greater then 6 digit",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(username)) {
                    Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(phoneNo)) {
                    Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserHelperClass helperClass = new UserHelperClass(name,username,email,phoneNo,password);

                reference.child(username).setValue(helperClass);

                Toast.makeText(SignUp.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });

    }//Oncreate Method End


}

