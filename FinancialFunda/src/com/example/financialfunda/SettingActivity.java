package com.example.financialfunda;

import java.io.IOException;

import com.example.aaa.R;
import com.example.database.ScoreDB;
import com.example.quiz.ResultActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends Activity {

	private Switch musicSwitch;
	//private boolean musicStatus;
	public static boolean musicStatus=true;
	
	private ImageButton highScoreResetButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_page);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		highScoreResetButton = (ImageButton) findViewById(R.id.go_button);
		
		highScoreResetButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				if(musicStatus){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
				
				 ScoreDB db = new ScoreDB(SettingActivity.this);
				 db.deleteAllScoreData();
				 Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
	             db.close();
			}
 
		});
		
		
		
		
		
		musicSwitch = (Switch) findViewById(R.id.setting_switch);
	
		//set the switch to ON 
		musicSwitch.setChecked(musicStatus);
		  //attach a listener to check for changes in state
		musicSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		   @Override
		   public void onCheckedChanged(CompoundButton buttonView,
		     boolean isChecked) {

		    if(isChecked){
		    	musicStatus=true;
		    }else{
		    	musicStatus=false;
		    }

		   }
		  });
		  
		  //check the current state before we display the screen
		  
		 }

		public boolean getMusicStatus(){
			return musicStatus;
		}
		
		public void onBackPressed()
		{
		    super.onBackPressed(); 
		    startActivity(new Intent(SettingActivity.this, MainActivity.class));
		    finish();

		}
		
		
	
}
