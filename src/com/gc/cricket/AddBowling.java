package com.gc.cricket;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddBowling extends Activity {
EditText jnum,overs,wickets,runs,dot,four,six;
Button addbownling;
CricketDatabase cricketDatabase;
SQLiteDatabase sqLiteDatabase;
ContentValues contentValues;
String sjnum,sovers,swickets,sruns,sdot,sfour,ssix;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_bowling);
		jnum = (EditText) findViewById(R.id.p_id);
		overs = (EditText) findViewById(R.id.overs);
		wickets = (EditText) findViewById(R.id.wickets);
		runs = (EditText) findViewById(R.id.runs);
		dot = (EditText) findViewById(R.id.no_dotballs);
		four = (EditText) findViewById(R.id.no_four);
		six = (EditText) findViewById(R.id.no_six);
		addbownling = (Button) findViewById(R.id.add_bownling);
		cricketDatabase = new CricketDatabase(getApplicationContext());
		sqLiteDatabase = cricketDatabase.getSQLiteDataBase();
		contentValues = new ContentValues();
		addbownling.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sjnum = jnum.getText().toString();
				sovers = overs.getText().toString();
				swickets = wickets.getText().toString();
				sruns = runs.getText().toString();
				sdot = dot.getText().toString();
				sfour = four.getText().toString();
				ssix = six.getText().toString();
				contentValues.put("PID", Integer.parseInt(sjnum));
				contentValues.put("OVERS",Integer.parseInt(sovers) );
				contentValues.put("WICKETS", Integer.parseInt(swickets));
				contentValues.put("RUNS", Integer.parseInt(sruns));
				contentValues.put("DOT", Integer.parseInt(sdot));
				contentValues.put("FOUR", Integer.parseInt(sfour));
				contentValues.put("SIX", Integer.parseInt(ssix));
			
				sqLiteDatabase.insert("BOWLING", null, contentValues);
				
			}
		});
	}

}
