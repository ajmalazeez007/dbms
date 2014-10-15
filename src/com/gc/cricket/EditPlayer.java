package com.gc.cricket;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditPlayer extends Activity {
	CricketDatabase cricketDatabase;
	 SQLiteDatabase sqLiteDatabase;
	 EditText fname,lname,age,pid;
	 Button add;
	 Spinner team;
	 String sfname,slname,sage,ssix,sfour,srun,sjersy,oldid;
	 String[] steam; 
	 ContentValues contentValues;
	 ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		steam = new String[]{"India","West Indies"};
		
		setContentView(R.layout.add_player);
		fname = (EditText) findViewById(R.id.f_name);
		pid = (EditText) findViewById(R.id.p_id);
		lname = (EditText) findViewById(R.id.l_name);
		age = (EditText) findViewById(R.id.age);
		oldid=AinActivity.j_no;
		
		Toast.makeText(getApplicationContext(), oldid, Toast.LENGTH_LONG).show();
		contentValues = new ContentValues();
		
		add = (Button) findViewById(R.id.addplayer);
		team = (Spinner) findViewById(R.id.team);
		adapter = new ArrayAdapter<String>(EditPlayer.this, android.R.layout.simple_list_item_1, android.R.id.text1, steam);
		team.setAdapter(adapter);
		cricketDatabase = new CricketDatabase(getApplicationContext());
		sqLiteDatabase = cricketDatabase.getSQLiteDataBase();
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sfname = fname.getText().toString();
				slname = lname.getText().toString();
				sage = age.getText().toString();
				sjersy = pid.getText().toString();
				contentValues.put("PID", Integer.parseInt(sjersy));
				contentValues.put("FNAME",sfname );
				contentValues.put("LNAME", slname);
				contentValues.put("AGE", Integer.parseInt(sage));
				contentValues.put("TEAM", team.getSelectedItemPosition());
				
				sqLiteDatabase.update("PLAYER", contentValues, "PID="+oldid, null);
				ContentValues pid = new ContentValues();
				pid.put("PID",sjersy);
				sqLiteDatabase.update("BATTING", pid, "PID="+oldid, null);
				sqLiteDatabase.update("BOWLING", pid, "PID="+oldid, null);
				
				
			}
		});
		
	}

}
