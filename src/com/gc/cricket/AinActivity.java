package com.gc.cricket;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AinActivity extends Activity {
Button addplayer,addbowler,addbatting,delete,edit;
EditText todelete,toedit;
public static String j_no;
CricketDatabase cricketDatabase;
SQLiteDatabase sqLiteDatabase;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ain);
addplayer = (Button) findViewById(R.id.addplayer);
addbowler = (Button) findViewById(R.id.addbowler);
addbatting=(Button)findViewById(R.id.adbater);
delete = (Button) findViewById(R.id.b_delete);
todelete = (EditText)findViewById(R.id.delete);
toedit=(EditText)findViewById(R.id.edit);
edit =(Button)findViewById(R.id.b_edit);


cricketDatabase = new CricketDatabase(getApplicationContext());
sqLiteDatabase = cricketDatabase.getSQLiteDataBase();




addplayer.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(AinActivity.this, AddPlayer.class);
		startActivity(intent);
	}
});





addbatting.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(AinActivity.this, AddBatting.class);
		startActivity(intent);
		
	}
});





addbowler.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(AinActivity.this, AddBowling.class);
		startActivity(intent);
	}
});
	
	
	delete.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			j_no=todelete.getText().toString();
			sqLiteDatabase.delete("PLAYER", "PID="+j_no, null);
			sqLiteDatabase.delete("BATTING", "PID="+j_no, null);
			sqLiteDatabase.delete("BOWLING", "PID="+j_no, null);
			
			
		}
	});
	
	
	
	edit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			j_no=toedit.getText().toString();
			
			Intent intent = new Intent(AinActivity.this, EditPlayer.class);
			startActivity(intent);
			
		}
	});
	
	
	
	
	
	
	
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ain, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
