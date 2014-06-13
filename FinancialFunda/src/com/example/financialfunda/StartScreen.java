package com.example.financialfunda;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.aaa.R;
import com.example.stories.Story1;
import com.example.stories.Story2;
import com.example.stories.Story3;
import com.example.stories.Story4;
import com.example.stories.Story5;

public class StartScreen extends Activity{

	SettingActivity setting = new SettingActivity();
	ImageButton story1,story2,story3,story4,story5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startscreen);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		addListenerOnButton();
		
	}
	
	

	
	public void addListenerOnButton() {
		 
		story1 = (ImageButton) findViewById(R.id.imageButton1);
		story2 = (ImageButton) findViewById(R.id.imageButton2);
		story3 = (ImageButton) findViewById(R.id.imageButton3);
		story4 = (ImageButton) findViewById(R.id.imageButton4);
		story5 = (ImageButton) findViewById(R.id.imageButton5);
		
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int height1 = metrics.heightPixels;
		
		int marginBottom = (int) (40*height1)/800;
		
		int marginBottom2 = (int) (80*height1)/800;		
		/*
		RelativeLayout.LayoutParams	lp= (android.widget.RelativeLayout.LayoutParams) story1.getLayoutParams();
		 lp.setMargins(marginBottom, marginBottom2, 0, 0);
		 
		 story1.setLayoutParams(lp);
		RelativeLayout.LayoutParams	lp2= (android.widget.RelativeLayout.LayoutParams) story2.getLayoutParams();
		 lp2.setMargins(marginBottom, 0, 0, 0);
		 story2.setLayoutParams(lp2);
		RelativeLayout.LayoutParams	lp3= (android.widget.RelativeLayout.LayoutParams) story3.getLayoutParams();
		 lp3.setMargins(0, marginBottom2, 0, 0);
		 story3.setLayoutParams(lp3);
		 RelativeLayout.LayoutParams	lp4= (android.widget.RelativeLayout.LayoutParams) story5.getLayoutParams();
		 lp4.setMargins(0, marginBottom, 0, 0);
		 story5.setLayoutParams(lp4);
 */
		story1.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
	 
				}
				
				
				Intent intent = new Intent(StartScreen.this, Story1.class);
                startActivity(intent);
                finish();
			}
 
		});
		
		story2.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();	 
				}
				Intent intent = new Intent(StartScreen.this, Story2.class);
                startActivity(intent);
                finish();
			}
 
		});
		
		story3.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();	 
				}
 
				Intent intent = new Intent(StartScreen.this, Story3.class);
                startActivity(intent);
                finish();
			}
 
		});
		
		story4.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();	 
				}
 
				Intent intent = new Intent(StartScreen.this, Story4.class);
                startActivity(intent);
                finish();
 
 
			}
 
		});
		
		story5.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();	 
				}
				
				Intent intent = new Intent(StartScreen.this, Story5.class);
                startActivity(intent);
                finish();
 
				
			}
 
		});
 
	}
	
}
