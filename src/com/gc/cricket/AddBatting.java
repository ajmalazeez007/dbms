package com.gc.cricket;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddBatting extends Activity {
EditText jnum,runs,dot,four,six;
Button addbatting;
CricketDatabase cricketDatabase;
SQLiteDatabase sqLiteDatabase;
ContentValues contentValues;
String sjnum,sruns,sfour,ssix;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_batting);
		jnum = (EditText) findViewById(R.id.p_id);
		runs = (EditText)findViewById(R.id.runs);
		four =(EditText)findViewById(R.id.no_four);
		six =(EditText)findViewById(R.id.no_six);
		addbatting =(Button)findViewById(R.id.add_batting);
		cricketDatabase = new CricketDatabase(getApplicationContext());
		sqLiteDatabase = cricketDatabase.getSQLiteDataBase();
		contentValues = new ContentValues();
		addbatting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sjnum = jnum.getText().toString();
				
				sruns = runs.getText().toString();
				
				sfour = four.getText().toString();
				ssix = six.getText().toString();
				contentValues.put("PID", Integer.parseInt(sjnum));
			
				
				contentValues.put("RUNS", Integer.parseInt(sruns));
				
				contentValues.put("FOUR", Integer.parseInt(sfour));
				contentValues.put("SIX", Integer.parseInt(ssix));
				
				sqLiteDatabase.insert("BATTING", null, contentValues);
				
			}
		});
	}

}
