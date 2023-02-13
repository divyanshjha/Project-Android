package com.example.attempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Animation extends AppCompatActivity {

    private static int SPLASH_SCREEN =4500;
    android.view.animation.Animation topAnim , bottomAnim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animation);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hook the animation to image and text
        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);

        //Assigning the animation to image and text
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        //For Splash Screen
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Animation.this, Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(image, "logo_text");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                            Animation.this, pairs);

                    startActivity(intent, options.toBundle());
                    finish();
                }


            }

        },SPLASH_SCREEN);  //End of animation for splash screen




    }
}
