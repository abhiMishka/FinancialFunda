package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestionDB extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "SEBIQuiz";
	private static final String TABLE_QUEST = "quest";

	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private static final String KEY_OPTD= "optd"; //option c
	
	private SQLiteDatabase dbase;
	
	public static int totQue = 30;
	public static int quizQue = 10;
	
	public QuestionDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
	
	private void addQuestions()
	{
		
		QuestionObj q1=new QuestionObj("What is the maximum amount we can withdraw from debit card at an instance?" 
				,"5000", "1000", "10000", "7500", "10000");
		this.addQuestion(q1);
		
				
		QuestionObj q2=new QuestionObj("What is the maximum amount we can withdraw from debit card in a month?" 
				,"25000", "50000", "40000", "15000","25000");
		this.addQuestion(q2);
		
		QuestionObj q3=new QuestionObj("Which card can not be used to purchase good and services on POS terminals?" 
				,"ATM cum debit card", "Prepaid Card", "Credit Card", "Smart Card", "Smart Card");
		this.addQuestion(q3);

		QuestionObj q4=new QuestionObj("How many digit long is a PIN?" 
				,"2 digit", "3 digit", "4 digit", "5 digit", "4 digit");
		this.addQuestion(q4);

		QuestionObj q5=new QuestionObj("What should we do when the card is lost?" 
				,"Sit at home", "Contact bank and Freeze Card", "Cry out loud", "Steal someone else's card", "Contact bank and Freeze Card");
		this.addQuestion(q5);
		
		QuestionObj q6=new QuestionObj("What problem can be solved if POS machines are available everywhere?" 
				,"Pick Pocketing", "Starvation", "Crop Failure", "Inflation", "Pick Pocketing");
		this.addQuestion(q6);
		
		QuestionObj q7=new QuestionObj("What can we not do from ATM cum debit card?" 
				,"Withdraw Money", "Pay on POS machines", "Transfer Money", "Play Cards", "Play Cards");
		this.addQuestion(q7);
		
		QuestionObj q8=new QuestionObj("When is a note mutilated?" 
				,"Note has missing pieces", "Note is disfigured", "Note is burnt", "All of above", "All of above");
		this.addQuestion(q8);
		
		QuestionObj q9=new QuestionObj("What is the maximum amount we can withdraw from debit card at an instance?" 
				,"5000", "1000", "10000", "7500", "10000");
		this.addQuestion(q9);
		
		QuestionObj q10=new QuestionObj("What happens with unusable notes?" 
				,"They are burnt", "They are shredded", "They are resold", "They are thrown away", "They are shredded");
		this.addQuestion(q10);

		QuestionObj q11=new QuestionObj("When was RBI established?" 
				,"April 1, 1935", "June 1, 1947", "April 23, 1875", "August 9, 1977", "April 1, 1935");
		this.addQuestion(q11);

		QuestionObj q12=new QuestionObj("How much value we'll get for a note which has numbers intact on both sides?" 
				,"Full Value", "No Value", "Half of the Value", "Double Value", "Full Value");
		this.addQuestion(q12);
		
		QuestionObj q13=new QuestionObj("How much value we'll get for a note which has numbers missing?" 
				,"Full Value", "No Value", "Half of the Value", "Double Value", "Half of the Value");
		this.addQuestion(q13);
		
		QuestionObj q14=new QuestionObj("What is/are task of currency chest?" 
				,"Withdraw soiled notes from system", "Facilitate distribution of fresh notes", "Act like extended arms of RBI", "All of the above", "All of the above");
		this.addQuestion(q14);
		
		QuestionObj q15=new QuestionObj("How do notes get dirty?" 
				,"Use notes for writing", "Notes change hands frequently", "People stain these notes","All of the above", "All of the above");
		this.addQuestion(q15);
		
		QuestionObj q16=new QuestionObj("What does ATM means?" 
				,"Automated Teller Machine", "Automated Telephone Machine", "Automatic Telephone Mobile", "None of the Above", "Automated Teller Machine");
		this.addQuestion(q16);

		QuestionObj q17=new QuestionObj("How much bank charge for withdrawing money from ATM?" 
				,"10 Rs per transaction", "25 Rs per transaction", "None", "100 Rs per transaction", "None");
		this.addQuestion(q17);
		
		QuestionObj q18=new QuestionObj("How many transactions are free when using different bank's ATM?" 
				,"5", "6", "7", "10", "5");
		this.addQuestion(q18);
		
		QuestionObj q19=new QuestionObj("What to do when card has been swallowed by ATM?" 
				,"Report to bank which issued the card", "Break the machine", "Go home and do nothing", "Start shouting outside the ATM", "Report to bank which issued the card");
		this.addQuestion(q19);
		
		QuestionObj q20=new QuestionObj("What precautions should be kept in mind while using ATM?" 
				,"Ensure no one is peeking while you use ATM", "Do not tell your password", "Carry contact number of bank every time with you", "All of the above", "All of the above");
		this.addQuestion(q20);
		
		QuestionObj q21=new QuestionObj("What does bank do if ATM machine deducts money from account but doesn't give money" 
				,"Pay cash within 7 days", "Refuses to pay money", "Gives lesser money than deducted", "Gives extra money than deducted", "Pay cash within 7 days");
		this.addQuestion(q21);
		
		QuestionObj q22=new QuestionObj("What happens if bank doesn't pay back within 7 days if money has been wrongly reduced from account" 
				,"Pays Rs 100 per day", "Pays Rs 50 per day", "Doesn't pay anything", "Deducts Rs 25 per day", "Pays Rs 100 per day");
		this.addQuestion(q22);
		
		QuestionObj q23=new QuestionObj("How many days we have to report any mistake by ATM machine to the bank?" 
				,"Within 30 days", "Within 10 days", "Within 21 days", "Within a week", "Within 30 days");
		this.addQuestion(q23);
		
		QuestionObj q24=new QuestionObj("What are the objectives of monetary policy?" 
				,"Controlling inflation", "Encouraging growth", "Financial Stability", "All of the above", "All of the above");
		this.addQuestion(q24);
		
		QuestionObj q25=new QuestionObj("What is inflation?" 
				,"Fewer Good, Lot of money", "Fewer Money, Lot of Good", "Lot of Money, Lot of Good", "Fewer Money, Fewer Good", "Fewer Good, Lot of money");
		this.addQuestion(q25);

		QuestionObj q26=new QuestionObj("How does RBI maintain Price Stability?" 
				,"By providing excess money", "Taking away excess money from the banks", "Manage interest rates", "Any of the above", "Any of the above");
		this.addQuestion(q26);
		
		QuestionObj q27=new QuestionObj("What happens if there is financial instability?" 
				,"Banks can not give loan", "People won't deposit money in banks", "People will not get there savings back from bank", "All of the above", "All of the above");
		this.addQuestion(q27);
		
		QuestionObj q28=new QuestionObj("What steps are taken to ensure financial stability?" 
				,"Risk assessment", "Capital adequacy", "Prudential norms", "All of the above", "All of the above");
		this.addQuestion(q28);
		
		QuestionObj q29=new QuestionObj("What are the advantages of bank?" 
				,"We earn interest on our money", "Our money remains safe", "We can take loan", "All of the above", "All of the above");
		this.addQuestion(q29);
		
		QuestionObj q30=new QuestionObj("Who is a nominee?" 
				,"For whom we leave money when something unfortunate happens", "Whose money we get if unfortunate happens to him/her", "Who gets interest on our money", "Who gives us money every month", "For whom we leave money when something unfortunate happens");
		this.addQuestion(q30);

		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	
	public void addQuestion(QuestionObj quest) {
		
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		
		dbase.insert(TABLE_QUEST, null, values);		
	}
	
	public List<QuestionObj> getAllQuestions() {
		List<QuestionObj> quesList = new ArrayList<QuestionObj>();

		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				QuestionObj quest = new QuestionObj();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quest.setOPTD(cursor.getString(6));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}

		return quesList;
	}

	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
	
}
