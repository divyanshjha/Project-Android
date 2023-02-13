package com.example.attempt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Guidelines extends AppCompatActivity{

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);

    button = findViewById(R.id.btn_Checkde);

    }
    public void onClick(View view)
    {
        Intent intent = new Intent(Guidelines.this,MainActivity.class);
        Toast.makeText(this, "You Have Checked The Guidelines, Welcome", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }
}