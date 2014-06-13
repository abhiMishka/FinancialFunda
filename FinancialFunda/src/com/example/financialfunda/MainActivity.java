package com.example.financialfunda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;



import com.example.highscore.ListAdapter;
import com.example.highscore.ListItem;
import com.example.aaa.R;
import com.example.database.ScoreDB;

import com.example.database.ScoreList;
import com.example.quiz.QuizActivity;
import com.example.quiz.ResultActivity;

public class MainActivity extends Activity {

	ImageView highScoreButton,storiesButton,settingButton,quizButton,helpButton;
	private static final String FILENAME = "highScore.txt";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);		
		
		addListenerOnButton();
		
		if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

	}
	
	
	
	public void addListenerOnButton() {
		
		final SettingActivity setting=new SettingActivity();
		 
		
		highScoreButton = (ImageView) findViewById(R.id.highscore_button_view);
		storiesButton = (ImageView) findViewById(R.id.stories_button_view);
		settingButton = (ImageView) findViewById(R.id.settings_button_view);
		quizButton = (ImageView) findViewById(R.id.quiz_button_view);
		helpButton = (ImageView) findViewById(R.id.raju_button_view);
		
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int height1 = metrics.heightPixels;
		
		int marginBottom = (int) (30* height1)/800;
		
		int marginBottom2 = (int) (30* height1)/800;		
		RelativeLayout.LayoutParams	lp= (android.widget.RelativeLayout.LayoutParams) highScoreButton.getLayoutParams();
		 lp.setMargins(0, 0, 0, marginBottom2);
		 highScoreButton.setLayoutParams(lp);
		 
		RelativeLayout.LayoutParams	lp1= (android.widget.RelativeLayout.LayoutParams) quizButton.getLayoutParams();
		 lp1.setMargins(0, 0, 0, marginBottom);
		 quizButton.setLayoutParams(lp1);
		 
		 RelativeLayout.LayoutParams lp2= (android.widget.RelativeLayout.LayoutParams) storiesButton.getLayoutParams();
		 lp2.setMargins(0, 0, 0, marginBottom);
		 storiesButton.setLayoutParams(lp2);
		 
		highScoreButton.setOnClickListener(new OnClickListener() { 
			@Override
			public void onClick(View arg0) {
				
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
				
 
				//Intent intent = new Intent(MainActivity.this, QuizActivity.class);
               // startActivity(intent);
				try {
					showPopUp();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
 
		});
		
		storiesButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
				Intent intent = new Intent(MainActivity.this, StartScreen.class);
                startActivity(intent);   
 
			}
 
		});		
		settingButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				if(SettingActivity.musicStatus){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
 
				Intent intent = new Intent(MainActivity.this, SettingActivity.class);
	            startActivity(intent);
 
			}
 
		});
		
		
		quizButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				if(setting.getMusicStatus()){
					MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
					mp.start();
				}
 
				Intent intent = new Intent(MainActivity.this, QuizActivity.class);
	            startActivity(intent);
 
			}
 
		});
	
	
	helpButton.setOnClickListener(new OnClickListener() {
		 
		@Override
		public void onClick(View arg0) {
			if(SettingActivity.musicStatus){
				MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.startsound2);
				mp.start();
			}

			Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);

		}

	});
	
	}
	
		 public void showPopUp() throws IOException{

		       
			 	ScoreDB db = new ScoreDB(this);
			 	ArrayList<ScoreList> d2 = db.getAllData();
			 	
			 	 Collections.sort(d2, new Comparator<ScoreList>() {
			         public int compare(ScoreList p1, ScoreList p2) {
			             return -(p1.getRating() - p2.getRating());
			         }

			     });
			 	 
			 	ListItem[] ListItem1 = new ListItem[d2.size()];
			 	int i=0;
			 	for(ScoreList s : d2 ){
			 		ListItem1[i] = new ListItem(s.getComment(),s.getRating());
			 		
			 		i++;
			 	}
			 	
			 /*	for(int j=0;j<d2.size();j++){
			 		
			 	}*/
			 	
			 	
		        ListAdapter adapter = new ListAdapter(this, R.layout.list_item, ListItem1);

		        
		       
		        ListView listViewItems = new ListView(this);
		        listViewItems.setAdapter(adapter);
			 
		        AlertDialog  alertDialogStores = new AlertDialog.Builder(MainActivity.this)
		            .setView(listViewItems)
		            .setTitle("High Scores")
		            .show();

		    

 
	}
		 
		 
		 @Override
		 public void onBackPressed() {
			 Intent intent = new Intent(MainActivity.this, MainActivity.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             intent.putExtra("EXIT", true);
             startActivity(intent);
		 }
		 
}
