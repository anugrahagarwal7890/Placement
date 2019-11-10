package com.appsquadz.placement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {


    private final Handler handler = new Handler();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        intent = new Intent(this, SignInActivity.class);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();

            }
        };

        handler.postDelayed(runnable, 3000);

    }



}
