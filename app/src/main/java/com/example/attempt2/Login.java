package com.example.attempt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;

public class Login extends AppCompatActivity {

    private TextInputLayout etloginname,etloginpass;
    private DatabaseReference reference;
    private String name,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Getting Reference
        reference= FirebaseDatabase.getInstance().getReference("user-data");

        etloginname =findViewById(R.id.username);
        etloginpass =findViewById(R.id.password);


    }//CLOSING ON CREATE

    // public void forgot(View view) {

    //       Intent intent = new Intent (Login.this,ForgotPassword.class);
    //     startActivity(intent);
    //  }


    public void gotosignuppage(View view) {

        Intent intent = new Intent (Login.this,SignUp.class);
        startActivity(intent);
    }


    public void loginn(View view) {
        name =etloginname.getEditText().getText().toString().toLowerCase();
        pass =etloginpass.getEditText().getText().toString();
        reference.child(name).addListenerForSingleValueEvent(listener);
    }

    ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()) {
                String password= (String) dataSnapshot.child("password").getValue(String.class);

                if(password.equals(pass)) {
                    Intent i = new Intent(Login.this,Guidelines.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(Login.this, "Record not found", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError databaseError) {
            //  Toast.makeText(Login.this,databaseError.toString());
            Toast.makeText(Login.this, "Wrong Input", Toast.LENGTH_SHORT).show();


        }
    };

}