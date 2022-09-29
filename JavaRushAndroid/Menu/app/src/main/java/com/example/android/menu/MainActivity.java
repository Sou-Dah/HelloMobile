package com.example.android.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	
	public void printToLogs(View view) {
		// Find first menu item TextView and print the text to the logs
		
		// Find second menu item TextView and print the text to the logs
		
		// Find third menu item TextView and print the text to the logs
		
		TextView menuItem1tv = (TextView) findViewById(R.id.menu_item_1);
		TextView menuItem2tv = (TextView) findViewById(R.id.menu_item_2);
		TextView menuItem3tv = (TextView) findViewById(R.id.menu_item_3);
		
		Log.i("MainActivity.java", "" + menuItem1tv.getText());
		Log.i("MainActivity.java", "" + menuItem2tv.getText());
		Log.i("MainActivity.java", "" + menuItem3tv.getText());
		
		
	}
	
}