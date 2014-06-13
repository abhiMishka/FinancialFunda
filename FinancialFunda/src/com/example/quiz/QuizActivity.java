package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.aaa.R;
import com.example.financialfunda.MainActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class QuizActivity extends Activity {

	List<QuestionObj> quesList;
	int score=0;
	int qid=0;
	QuestionObj currentQ;
	TextView txtQuestion;
	TextView tv_a, tv_b, tv_c, tv_d;
	ArrayList<Integer> qidList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		qidList = new ArrayList<Integer>();
		qid = getQid();
		setContentView(R.layout.my_quiz);
		
		QuestionDB db=new QuestionDB(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView6);
		tv_a=(TextView)findViewById(R.id.textView2);
		tv_b=(TextView)findViewById(R.id.textView3);
		tv_c=(TextView)findViewById(R.id.textView4);
		tv_d=(TextView)findViewById(R.id.textView5);
		setQuestionView();
		
		tv_a.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Log.d("yourans", currentQ.getANSWER()+" "+tv_a.getText());
				if(currentQ.getANSWER().equals(tv_a.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
					tv_a.setBackgroundResource(R.drawable.right);
					TransitionDrawable transition = (TransitionDrawable) tv_a.getBackground();
					transition.startTransition(500);
				}
				else
				{						
					tv_a.setBackgroundResource(R.drawable.wrong);
					TransitionDrawable transition = (TransitionDrawable) tv_a.getBackground();
					transition.startTransition(500);
				}

				new AsyncTask<Integer, Void, Void>(){
				    @Override
				    protected Void doInBackground(Integer... params) {
				    	try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				        return null;
				    }
				    
				    protected void onPostExecute(Void result)
				    {
				    	if(qidList.size()<QuestionDB.quizQue){	
				    		qid = getQid();
							currentQ=quesList.get(qid);
							setQuestionView();
						}else{
							Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
							Bundle b = new Bundle();
							b.putInt("score", score); //Your score
							intent.putExtras(b); //Put your score to your next Intent
							startActivity(intent);
							finish();
						}
				    }
				}.execute();
				
				
				
			}
		});
		

		tv_b.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Log.d("yourans", currentQ.getANSWER()+" "+tv_b.getText());
				if(currentQ.getANSWER().equals(tv_b.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
					tv_b.setBackgroundResource(R.drawable.right);
					TransitionDrawable transition = (TransitionDrawable) tv_b.getBackground();
					transition.startTransition(500);
				}
				else
				{						
					tv_b.setBackgroundResource(R.drawable.wrong);
					TransitionDrawable transition = (TransitionDrawable) tv_b.getBackground();
					transition.startTransition(500);
				}

				new AsyncTask<Integer, Void, Void>(){
				    @Override
				    protected Void doInBackground(Integer... params) {
				    	try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				        return null;
				    }
				    
				    protected void onPostExecute(Void result)
				    {
				    	if(qidList.size()<QuestionDB.quizQue){	
				    		qid = getQid();
							currentQ=quesList.get(qid);
							setQuestionView();
						}else{
							Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
							Bundle b = new Bundle();
							b.putInt("score", score); //Your score
							intent.putExtras(b); //Put your score to your next Intent
							startActivity(intent);
							finish();
						}
				    }
				}.execute();
				
				
				
			}
		});
		

		tv_c.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Log.d("yourans", currentQ.getANSWER()+" "+tv_c.getText());
				if(currentQ.getANSWER().equals(tv_c.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
					tv_c.setBackgroundResource(R.drawable.right);
					TransitionDrawable transition = (TransitionDrawable) tv_c.getBackground();
					transition.startTransition(500);
				}
				else
				{						
					tv_c.setBackgroundResource(R.drawable.wrong);
					TransitionDrawable transition = (TransitionDrawable) tv_c.getBackground();
					transition.startTransition(500);
				}

				new AsyncTask<Integer, Void, Void>(){
				    @Override
				    protected Void doInBackground(Integer... params) {
				    	try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				        return null;
				    }
				    
				    protected void onPostExecute(Void result)
				    {
				    	if(qidList.size()<QuestionDB.quizQue){	
				    		qid = getQid();
							currentQ=quesList.get(qid);
							setQuestionView();
						}else{
							Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
							Bundle b = new Bundle();
							b.putInt("score", score); //Your score
							intent.putExtras(b); //Put your score to your next Intent
							startActivity(intent);
							finish();
						}
				    }
				}.execute();
				
				
				
			}
		});
		

		tv_d.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Log.d("yourans", currentQ.getANSWER()+" "+tv_d.getText());
				if(currentQ.getANSWER().equals(tv_d.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
					tv_d.setBackgroundResource(R.drawable.right);
					TransitionDrawable transition = (TransitionDrawable) tv_d.getBackground();
					transition.startTransition(500);
				}
				else
				{						
					tv_d.setBackgroundResource(R.drawable.wrong);
					TransitionDrawable transition = (TransitionDrawable) tv_d.getBackground();
					transition.startTransition(500);
				}

				new AsyncTask<Integer, Void, Void>(){
				    @Override
				    protected Void doInBackground(Integer... params) {
				    	try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				        return null;
				    }
				    
				    protected void onPostExecute(Void result)
				    {
				    	if(qidList.size()<QuestionDB.quizQue){		
				    		qid = getQid();
							currentQ=quesList.get(qid);
							setQuestionView();
						}else{
							Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
							Bundle b = new Bundle();
							b.putInt("score", score); //Your score
							intent.putExtras(b); //Put your score to your next Intent
							startActivity(intent);
							finish();
						}
				    }
				}.execute();
				
				
				
			}
		});
	}
	
	public void onBackPressed()
	{
	    super.onBackPressed(); 
	    startActivity(new Intent(QuizActivity.this, MainActivity.class));
	    finish();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}
	
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		tv_a.setText(currentQ.getOPTA());
		tv_b.setText(currentQ.getOPTB());
		tv_c.setText(currentQ.getOPTC());
		tv_d.setText(currentQ.getOPTD());
		
		tv_a.setBackgroundResource(R.drawable.back);
		tv_b.setBackgroundResource(R.drawable.back);
		tv_c.setBackgroundResource(R.drawable.back);
		tv_d.setBackgroundResource(R.drawable.back);
	}


	private int getQid()
	{
		
		int temp;
		while(true)
		{
		temp = new Random().nextInt(QuestionDB.totQue);
		temp = temp % QuestionDB.totQue;
		if(!qidList.contains(temp))
		{
			break;
		}
		}
		qidList.add(temp);
		return temp;
		
	}






}


