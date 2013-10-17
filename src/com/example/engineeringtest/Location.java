package com.example.engineeringtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Location extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		
		
		
		editBox = (EditText) findViewById(R.id.edit_location1);
		editBox2 = (EditText) findViewById(R.id.edit_location2);
		editBox3 = (EditText) findViewById(R.id.edit_location3);
		editBox4 = (EditText) findViewById(R.id.edit_location4);
		editBox5 = (EditText) findViewById(R.id.edit_location5);
	}
	
	protected void onResume() {
		super.onResume();
		
		// Location 1
		SharedPreferences prefs = getPreferences(0);
		String restoredText = prefs.getString("text", null);
		if (restoredText != null) {
			editBox.setText(restoredText, TextView.BufferType.EDITABLE);

			int selectionStart = prefs.getInt("selection-start", -1);
			int selectionEnd = prefs.getInt("selection-end", -1);
			if (selectionStart != -1 && selectionEnd != -1) {
				editBox.setSelection(selectionStart, selectionEnd);
			}
		// Location 2	
			SharedPreferences prefs2 = getPreferences(1);
			String restoredText2 = prefs2.getString("text2", null);
			if (restoredText2 != null) {
				editBox2.setText(restoredText2, TextView.BufferType.EDITABLE);

				int selectionStart2 = prefs2.getInt("selection-start2", -1);
				int selectionEnd2 = prefs2.getInt("selection-end2", -1);
				if (selectionStart2 != -1 && selectionEnd2 != -1) {
					editBox2.setSelection(selectionStart2, selectionEnd2);
				}
			// Location 3
				SharedPreferences prefs3 = getPreferences(2);
				String restoredText3 = prefs3.getString("text3", null);
				if (restoredText3 != null) {
					editBox3.setText(restoredText3, TextView.BufferType.EDITABLE);

					int selectionStart3 = prefs3.getInt("selection-start3", -1);
					int selectionEnd3 = prefs3.getInt("selection-end3", -1);
					if (selectionStart3 != -1 && selectionEnd3 != -1) {
						editBox3.setSelection(selectionStart3, selectionEnd3);	
				
			}
					// Location 4
					SharedPreferences prefs4 = getPreferences(3);
					String restoredText4 = prefs4.getString("text4", null);
					if (restoredText4 != null) {
						editBox4.setText(restoredText4, TextView.BufferType.EDITABLE);

						int selectionStart4 = prefs4.getInt("selection-start4", -1);
						int selectionEnd4 = prefs4.getInt("selection-end4", -1);
						if (selectionStart4 != -1 && selectionEnd4 != -1) {
							editBox4.setSelection(selectionStart4, selectionEnd4);	
					
				}
						// Location 5
						SharedPreferences prefs5 = getPreferences(4);
						String restoredText5 = prefs5.getString("text5", null);
						if (restoredText5 != null) {
							editBox5.setText(restoredText5, TextView.BufferType.EDITABLE);

							int selectionStart5 = prefs5.getInt("selection-start5", -1);
							int selectionEnd5 = prefs5.getInt("selection-end5", -1);
							if (selectionStart5 != -1 && selectionEnd5 != -1) {
								editBox5.setSelection(selectionStart5, selectionEnd5);	
						
					} 
				}
			}		
		}
				
				
		}
						
		}
		
	}

	protected void onPause() {
		super.onPause();
		
		// Location 1
		SharedPreferences.Editor editor = getPreferences(0).edit();
		editor.putString("text", editBox.getText().toString());
		editor.putInt("selection-start", editBox.getSelectionStart());
		editor.putInt("selection-end", editBox.getSelectionEnd());
		editor.commit();
		
		// Location 2
		SharedPreferences.Editor editor2 = getPreferences(1).edit();
		editor2.putString("text2", editBox2.getText().toString());
		editor2.putInt("selection-start2", editBox2.getSelectionStart());
		editor2.putInt("selection-end2", editBox2.getSelectionEnd());
		editor2.commit();
		
		// Location 3
		SharedPreferences.Editor editor3 = getPreferences(2).edit();
		editor3.putString("text3", editBox3.getText().toString());
		editor3.putInt("selection-start3", editBox3.getSelectionStart());
		editor3.putInt("selection-end3", editBox3.getSelectionEnd());
		editor3.commit();
		
		// Location 4
		SharedPreferences.Editor editor4 = getPreferences(3).edit();
		editor4.putString("text4", editBox4.getText().toString());
		editor4.putInt("selection-start4", editBox4.getSelectionStart());
		editor4.putInt("selection-end4", editBox4.getSelectionEnd());
		editor4.commit();
		
		// Location 5
		SharedPreferences.Editor editor5 = getPreferences(4).edit();
		editor5.putString("text5", editBox5.getText().toString());
		editor5.putInt("selection-start5", editBox5.getSelectionStart());
		editor5.putInt("selection-end5", editBox5.getSelectionEnd());
		editor5.commit();
	}

	private EditText editBox;
	private EditText editBox2;
	private EditText editBox3;
	private EditText editBox4;
	private EditText editBox5;

	public void setLocation1(View view) {
		//Setup our test data
				EditText L1 = (EditText) findViewById(R.id.edit_location1);
				String test = L1.getText().toString();
				//Setup the bundle that will be passed
				Bundle Loc1 = new Bundle();
				Loc1.putString("Loc1", test);
				//Setup the Intent that will start the next Activity
				Intent location1 = new Intent(this, Location1.class); 
				//Assumes this references this instance of Activity A
				location1.putExtras(Loc1);

				this.startActivity(location1);
	}
	
	public void setLocation2(View view) {
		//Setup our test data
		EditText L2 = (EditText) findViewById(R.id.edit_location2);
		String test = L2.getText().toString();
		//Setup the bundle that will be passed
		Bundle b = new Bundle();
		b.putString("Loc2", test);
		//Setup the Intent that will start the next Activity
		Intent nextActivity = new Intent(this, Location2.class); 
		//Assumes this references this instance of Activity A
		nextActivity.putExtras(b);

		this.startActivity(nextActivity);
	}
	
	public void setLocation3(View view) {
		//Setup our test data
		EditText L3 = (EditText) findViewById(R.id.edit_location3);
		String Location3 = L3.getText().toString();
		//Setup the bundle that will be passed
		Bundle Loc3 = new Bundle();
		Loc3.putString("Loc3", Location3);
		//Setup the Intent that will start the next Activity
		Intent location3 = new Intent(this, Location3.class); 
		//Assumes this references this instance of Activity A
		location3.putExtras(Loc3);

		this.startActivity(location3);
	}
	
	public void setLocation4(View view) {
		//Setup our test data
		EditText L4 = (EditText) findViewById(R.id.edit_location4);
		String Location4 = L4.getText().toString();
		//Setup the bundle that will be passed
		Bundle Loc4 = new Bundle();
		Loc4.putString("Loc4", Location4);
		//Setup the Intent that will start the next Activity
		Intent location4 = new Intent(this, Location4.class); 
		//Assumes this references this instance of Activity A
		location4.putExtras(Loc4);

		this.startActivity(location4);
	}

	public void setLocation5(View view) {

		//Setup our test data
		EditText L5 = (EditText) findViewById(R.id.edit_location5);
		String Location5 = L5.getText().toString();
		//Setup the bundle that will be passed
		Bundle Loc5 = new Bundle();
		Loc5.putString("Loc5", Location5);
		//Setup the Intent that will start the next Activity
		Intent location5 = new Intent(this, Location5.class); 
		//Assumes this references this instance of Activity A
		location5.putExtras(Loc5);

		this.startActivity(location5);
	}
	
}
