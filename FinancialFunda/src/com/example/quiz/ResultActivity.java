package com.example.quiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.aaa.R;


import com.example.financialfunda.MainActivity;
import com.example.financialfunda.SettingActivity;
import com.example.financialfunda.StartScreen;
import com.example.highscore.ListItem;
import com.example.database.ScoreList;
import com.example.database.ScoreDB;

public class ResultActivity extends Activity {

	private String userName;
	private ImageButton saveButton;
	private int score_disp;
	public static ArrayList<ListItem> item = new ArrayList();
	private static final String FILENAME = "highScore.txt";
	
	SettingActivity setting=new SettingActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_result);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1); 
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		bar.setClickable(false);
		bar.setEnabled(false);
		addListenerOnButton();
		//TextView t=(TextView)findViewById(R.id.textResult);
		
		
		
		Bundle b = getIntent().getExtras();
		
		double score= b.getInt("score");
		score = (score / QuestionDB.quizQue)*5;

		score_disp = (int)score;
		bar.setRating(score_disp);
		
		
	}
	
	public void onBackPressed()
	{
	    super.onBackPressed(); 
	    startActivity(new Intent(ResultActivity.this, MainActivity.class));
	    finish();

	}
	
	
	public void addListenerOnButton() {
		 
		saveButton = (ImageButton) findViewById(R.id.saveImageButton);
		
		saveButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
				
				EditText name=(EditText)findViewById(R.id.username);
				userName=name.getText().toString();				
				
				if(userName.isEmpty()){
					Toast.makeText(getApplicationContext(), "Please enter your name.", Toast.LENGTH_SHORT).show();
				}
				
				else{
					ScoreDB db = new ScoreDB(ResultActivity.this); 					
					Log.d("Insert: ", "Inserting ..");
					ScoreList data =new ScoreList();
					data.setComment(userName);
					data.setRating(score_disp);
			        db.addDataToDatabase(data);  
			        
			        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
		            startActivity(intent);		            
		            finish();
				}
				
				
				
			}
 
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public String getUserName(){
		return userName;
	}
	
	 private void writeToFile(String data) {
		 
		 
	        try {
	        	FileOutputStream fos = openFileOutput(FILENAME, 
	        		    Context.MODE_APPEND | Context.MODE_WORLD_READABLE);
	        	fos.write(data.getBytes());
	        	fos.write(System.getProperty("line.separator").getBytes());
	            fos.close();
	        }
	        catch (IOException e) {
	            Log.e("ResultActivity", "File write failed: " + e.toString());
	        } 
	         
	    }
	
}
