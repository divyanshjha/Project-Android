package com.example.attempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUs extends AppCompatActivity {

RatingBar ratingBar;
Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);


        ratingBar = findViewById(R.id.rt_Bar);
        button = findViewById(R.id.btn_rate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data  = String.valueOf(ratingBar.getRating());
                Toast.makeText(RateUs.this, data+"Star", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RateUs.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }); 


    }
}