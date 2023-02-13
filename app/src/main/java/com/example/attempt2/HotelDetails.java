package com.example.attempt2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HotelDetails extends AppCompatActivity {

    Button btnBook;
    ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

    btnBook = findViewById(R.id.btn_hotel_book);
    imageView = findViewById(R.id.imageView11);

    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(HotelDetails.this, "Liked !", Toast.LENGTH_SHORT).show();
        }
    });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            NotificationChannel channel = new NotificationChannel("My Notification","My norification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(HotelDetails.this,"My Notification");
                builder.setContentTitle("Travel Nest");
                builder.setContentText("Thank you for Choosing us , Have a Safe Journey");
                //builder.setContentText("Booking Confirmed ,HAve a safe Journey! Thank you For Choosing Us");
                builder.setSmallIcon(R.drawable.logo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(HotelDetails.this);
                managerCompat.notify(1,builder.build());

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}