package com.example.attempt2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Place extends AppCompatActivity  {

    Button button;

    CardView cardView;

    private int  date,months,year,day;
    TextView textView;
    DatePickerDialog.OnDateSetListener setListener;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);


        textView =findViewById(R.id.txt_Date1);

        final Calendar calendar = Calendar.getInstance();
        //current time

        date = calendar.get(Calendar.DATE);
        months=calendar.get(Calendar.MONTH);
        year =calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Place.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,months,date);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                months = month+1;
                String date = day+"/"+month+"/"+year;
                textView.setText(date);
            }
        };

        button =findViewById(R.id.btn);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            NotificationChannel channel = new NotificationChannel("My Notification","My norification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        cardView = findViewById(R.id.crd_loc);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),maps.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Place.this,"My Notification");
                builder.setContentTitle("Travel Nest");
                builder.setContentText("Let's proceed with booking!");
                //builder.setContentText("Booking Confirmed ,HAve a safe Journey! Thank you For Choosing Us");
                builder.setSmallIcon(R.drawable.logo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Place.this);
                managerCompat.notify(1,builder.build());

                Intent intent = new Intent(getApplicationContext(),Booking.class);
                startActivity(intent);
            }
        });

    }
}