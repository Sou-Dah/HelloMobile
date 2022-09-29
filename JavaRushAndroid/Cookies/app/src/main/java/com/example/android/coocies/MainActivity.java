package com.example.android.coocies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * Called when the cookie should be eaten.
	 */
	public void eatCookie(View view) {
		// TODO: Find a reference to the ImageView in the layout. Change the image.
		
		// TODO: Find a reference to the TextView in the layout. Change the text.
		
		ImageView imageViewWithCookie = (ImageView) findViewById(R.id.android_cookie_image_view);
		imageViewWithCookie.setImageResource(R.drawable.after);
		imageViewWithCookie.setBackgroundResource(R.drawable.after);
		
		TextView statusTextView = (TextView) findViewById(R.id.status_text_view);
		statusTextView.setText("Om-nom-nom...");
		
		Button oneMoreButton = (Button) findViewById(R.id.oneMoreButton);
		oneMoreButton.setVisibility(View.VISIBLE);
		
		Button eatButton = (Button) findViewById(R.id.eatButton);
		eatButton.setVisibility(View.INVISIBLE);
		
	}
	
	public void oneMoreCookie(View view) {
		ImageView imageViewWithCookie = (ImageView) findViewById(R.id.android_cookie_image_view);
		imageViewWithCookie.setImageResource(R.drawable.before);
		
		TextView statusTextView = (TextView) findViewById(R.id.status_text_view);
		statusTextView.setText("I'm so hungry!");
		
		Button oneMoreButton = (Button) findViewById(R.id.oneMoreButton);
		oneMoreButton.setVisibility(View.INVISIBLE);
		
		Button eatButton = (Button) findViewById(R.id.eatButton);
		eatButton.setVisibility(View.VISIBLE);
		
	}
}
