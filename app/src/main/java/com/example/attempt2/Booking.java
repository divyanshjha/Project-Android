package com.example.attempt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attempt2.adapter.RecentsAdapter;
import com.example.attempt2.model.RecentData;

import java.util.ArrayList;
import java.util.List;

public class Booking extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;
    ImageView imageView,notification_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        List<RecentData> recentDataList= new ArrayList<>();
        recentDataList.add(new RecentData("Grand Bay Hotel", "India", "from $25", R.drawable.images));
        recentDataList.add(new RecentData("Grand Bay Hotel", "India", "from $25", R.drawable.h1));
        recentDataList.add(new RecentData("Grand Bay Hotel", "India", "from $25", R.drawable.h2));
        recentDataList.add(new RecentData("Grand Bay Hotel", "India", "from $25", R.drawable.h3));
        recentDataList.add(new RecentData("Grand Bay Hotel", "India", "from $25", R.drawable.h4));

        setRecentRecycler(recentDataList);

    imageView = findViewById(R.id.btn_home);
    notification_1 = findViewById(R.id.notif_1);

    notification_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Booking.this,Notification.class);
            startActivity(intent);
            finish();
        }
    });

    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Booking.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    });
    }

    private void setRecentRecycler(List<RecentData> recentsDataList) {
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }
}
