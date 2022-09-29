package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private static int countFirst = 666;
	private static int countSecond = 777;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		displayCountFirst();
		displayCountSecond();
	}
	
	private void displayCountFirst() {
		TextView countFirstTextView = (TextView) findViewById(R.id.count_first_text_view);
		countFirstTextView.setText("" + countFirst);
	}
	
	private void displayCountSecond() {
		TextView countSecondTextView = (TextView) findViewById(R.id.count_second_text_view);
		countSecondTextView.setText("" + countSecond);
	}
	
	public void changeCount(View view) {
		String id = getResources().getResourceEntryName(view.getId());
		switch (id) {
			case "clearCountsButton":
				countFirst = 0;
				displayCountFirst();
				countSecond = 0;
				displayCountSecond();
				break;
			case "increaseFirstCountBy3Button":
				countFirst++;
			case "increaseFirstCountBy2Button":
				countFirst++;
			case "increaseFirstCountBy1Button":
				countFirst++;
				displayCountFirst();
				break;
			case "increaseSecondCountBy3Button":
				countSecond++;
			case "increaseSecondCountBy2Button":
				countSecond++;
			case "increaseSecondCountBy1Button":
				countSecond++;
				displayCountSecond();
				break;
		}
		
	}
	
}