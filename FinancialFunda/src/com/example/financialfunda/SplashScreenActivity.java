package com.example.financialfunda;



import com.example.aaa.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreenActivity extends Activity {
	 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
 
        new Handler().postDelayed(new Runnable() {
 
           
            @Override
            public void run() {
                
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}