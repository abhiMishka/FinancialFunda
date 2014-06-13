package com.example.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class ScoreDB extends SQLiteOpenHelper {
	
	//database and table details
	    private static final int DATABASE_VERSION = 1; 
	    private static final String DATABASE_NAME = "ScoreDataManager";	 
	    private static final String TABLE_NAME = "ScoreData";

	//column details
	    private static final String ID = "id";
	    private static final String COMMENT="comment";
	    private static final String RATING="rating";
	    
	public ScoreDB(Context context, String name, CursorFactory factory,
			int version) {
		
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	public ScoreDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + COMMENT + " TEXT,"
                + RATING + " INT" + ")";
        db.execSQL(CREATE_SCORE_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);		 
        //call onCreate again to create a new table
        onCreate(db);
		
	}
	
	public void addDataToDatabase(ScoreList data){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put(COMMENT, data.getComment());
		values.put(RATING, data.getRating());
		
		 db.insert(TABLE_NAME, null, values);
		 db.close();
	}
	
	
	
	public ArrayList<ScoreList> getAllData() {
		ArrayList<ScoreList> data=new ArrayList();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_NAME;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	    int i=0;
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	        	data.add(new ScoreList());
	        	data.get(i).setId(Integer.parseInt(cursor.getString(0)));
	        	data.get(i).setComment(cursor.getString(1));
	    	    data.get(i).setRating(Integer.parseInt(cursor.getString(2)));
	    	    i++;
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return data;
	}
	
		
	public int updateScoreData(ScoreList data) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(COMMENT, data.getComment());
	    values.put(RATING, data.getRating());
	 
	    // updating row
	    return db.update(TABLE_NAME, values, ID + " = ?",
	            new String[] { String.valueOf(data.getId()) });
	}
	
	public int getDataSize() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close(); 
       
        return cursor.getCount();
    }
	
	public void deleteScoreData(ScoreList data) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_NAME, ID + " = ?",new String[] { String.valueOf(data.getId()) });
	    db.close();
	}
	
	public void deleteAllScoreData() {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.execSQL("delete from "+ TABLE_NAME);
	    db.close();
	}

}
