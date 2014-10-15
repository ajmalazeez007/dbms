package com.gc.cricket;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class CricketDatabase {
Context context;
CricketDatabaseHelper helper;
SQLiteDatabase db;
SharedPreferences sharedPreferences;
	public CricketDatabase(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;

		helper= new CricketDatabaseHelper();
	}
	
	
	 public SQLiteDatabase getSQLiteDataBase(){
		 helper= new CricketDatabaseHelper();
			SQLiteDatabase db = helper.getWritableDatabase();
			return db;
	 }
	
	
	private class CricketDatabaseHelper extends SQLiteOpenHelper{
		static final int Database_version=1;
		static final String Database_name= "cricket.db";
		
		
		static final String Create_player = "CREATE TABLE PLAYER(PID INTEGER PRIMARY KEY  NOT NULL,FNAME VARCHAR NOT NULL,LNAME VARCHAR NOT NULL,AGE INT NOT NULL,TEAM INT NOT NULL);";
		static final String Create_batting = "CREATE TABLE BATTING(PID INTEGER PRIMARY KEY  NOT NULL,SIX INT NOT NULL,FOUR INT NOT NULL,RUNS INT NOT NULL);";
		static final String Create_bowling = "CREATE TABLE BOWLING (PID INT PRIMARY KEY NOT NULL,OVERS INT NOT NULL,WICKETS INT NOT NULL,RUNS INT NOT NULL,DOT INT NOT NULL,FOUR INT NOT NULL,SIX INT NOT NULL);";
		static final String Create_stats= "CREATE TABLE STATITICS (PID INT PRIMARY KEY NOT NULL,OUT VARCHAR NOT NULL,BID INT NOT NULL);";
		public CricketDatabaseHelper() {
			super(context, Database_name, null, Database_version);
		}

		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
			
				db.execSQL(Create_player);
				db.execSQL(Create_batting);
				db.execSQL(Create_bowling);
				db.execSQL(Create_stats);
				Toast.makeText(context, "Successfully creating db", Toast.LENGTH_LONG).show();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Toast.makeText(context, "error creating db", Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
		
		}
		
	}
	
	
	
}