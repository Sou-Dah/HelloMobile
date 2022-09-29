/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
	
	private static String name = "Dear guest";
	private static int quantity = 2;
	private static int price = 10;
	private static int totalCost = 0;
	private static boolean addedWhippedCream = false;
	private static boolean addedChocolate = false;
	private static String templateForSummaryMessage = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		name = getString(R.string.dear_guest);
		displayQuantity(quantity);
		displayPrice(price);
		displayCost();
	}
	
	/**
	 * This method is called when the Calculate button is clicked.
	 */
	public void calculate(View  view) {
		totalCost = quantity * price;
		displayCost();
	}
	
	/**
	 * This method is called when the Send button is clicked.
	 */
	public void sendOrder(View view) {
		intentsForChoose(totalCost);
	}
	
	private void intentsForChoose(int intentNumber) {
		Intent intent;
		switch (intentNumber) {
			case 15:
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("get:47.6, -122.3"));
				if (intent.resolveActivity(getPackageManager()) != null) {
					startActivity(intent);
				} else {
					toastShow("No answer");
				}
				break;
			case 30:
				intent = new Intent(Intent.ACTION_SEND);
				intent.setType("*/*");
				intent.putExtra(Intent.EXTRA_SUBJECT,
						getString(R.string.order_summary_email_subject, name));
				intent.putExtra(Intent.EXTRA_TEXT, createMessage());
				if (intent.resolveActivity(getPackageManager()) != null) {
					startActivity(intent);
				} else {
					toastShow("No answer");
				}
				break;
			case 0:
				break;
		}
		
	}
	
	/**
	 * This method is called when the Order button is clicked.
	 */
	public void submitOrder(View view) {
		EditText editTextView = (EditText) findViewById(R.id.name_edittext_view);
		String editTextStr = editTextView.getText().toString();
		if (!editTextStr.isEmpty() && !editTextStr.equals(""))
			name = editTextView.getText().toString();
		calculate(view);
		displayMessage(createMessage());
	}
	
	/**
	 * This method is called when the Clear button is clicked.
	 */
	public void clearOrder(View view) {
		((EditText) findViewById(R.id.name_edittext_view)).clearComposingText();
		quantity = 1;
		isCheckedWhippedCream(view);
		isCheckedChocolate(view);
		displayQuantity(quantity);
		displayPrice(price);
		displayCost();
	}
	
	public void isCheckedWhippedCream(View view) {
		CheckBox whippedCreamCheckBox = findViewById(R.id.add_whipped_cream_checkbox);
		addedWhippedCream = whippedCreamCheckBox.isChecked();
		
		if (view instanceof Button) {
			if (((Button) view).getId() == R.id.clear_order_button) {
				if (addedWhippedCream)
					price -= 3;
				whippedCreamCheckBox.setChecked(false);
			} else {
				if (addedWhippedCream)
					price += 3;
				else
					price -= 3;
			}
		}
		
		displayPrice(price);
	}
	
	public void isCheckedChocolate(View view) {
		CheckBox chocolateCheckBox = findViewById(R.id.add_chocolate_checkbox);
		addedChocolate = chocolateCheckBox.isChecked();
		
		if (view instanceof Button) {
			if (((Button) view).getId() == R.id.clear_order_button) {
				if (addedChocolate)
					price -= 2;
				chocolateCheckBox.setChecked(false);
			} else {
				if (addedChocolate)
					price += 2;
				else
					price -= 2;
			}
		}
		
		displayPrice(price);
	}
	
	private String createMessage() {
		String templateForSummaryMessage1 = "" +
				"Name: %s" +
				"\n" + "Add whipped cream: %s" +
				"\n" + "Add chocolate: %s" +
				"\n" + "Price: %s" +
				"\n" + "Quantity: %s" +
				"\n" + "Total cost: %s" +
				"\n" + "Thank you!" +
				"";
		
		if (templateForSummaryMessage.isEmpty())
			templateForSummaryMessage = "" +
					getString(R.string.order_summary_name, name) +
					"\n" + getString(R.string.order_summary_whipped_cream) +
					" " + (addedWhippedCream ? getString(R.string.yes) : getString(R.string.no)) +
					"\n" + getString(R.string.order_summary_chocolate) +
					" " + (addedChocolate ? getString(R.string.yes) : getString(R.string.no)) +
					"\n" + getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(price)) +
					"\n" + getString(R.string.order_summary_quantity, quantity) +
					"\n" + getString(R.string.order_summary_total_cost, NumberFormat.getCurrencyInstance().format(totalCost)) +
					"\n" + getString(R.string.thank_you);
			
		String message = String.format(templateForSummaryMessage,
				name,
				addedWhippedCream,
				addedChocolate,
				NumberFormat.getCurrencyInstance().format(price),
				quantity,
				NumberFormat.getCurrencyInstance().format(totalCost) );
		return templateForSummaryMessage;
		
	}
	
	private void displayMessage(String message) {
		TextView summaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
		summaryTextView.setText(message);
	}
	
	/**
	 * This method displays the given quantity value on the screen/
	 */
	private void displayCost() {
		TextView costTextView = (TextView) findViewById(R.id.cost_text_view);
		costTextView.setText(NumberFormat.getCurrencyInstance().format(totalCost));
	}
	
	/**
	 * This method displays the given quantity value on the screen.
	 */
	private void displayQuantity(int number) {
		TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
		quantityTextView.setText("" + number);
	}
	
	/**
	 * Increase quantity by 1.
	 */
	public void increaseOrderQuantity(View view) {
		if (quantity == 50) {
			toastShow("Больше 20 кофе низя!");
			return;
		}
		quantity++;
		TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
		quantityTextView.setText("" + quantity);
	}
	
	/**
	 * Decrease quantity by 1.
	 */
	public void decreaseOrderQuantity(View view) {
		if (quantity == 1) {
			toastShow("Меньше 1 кофе низя!");
			return;
		}
		quantity--;
		TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
		quantityTextView.setText("" + quantity);
	}
	private void toastShow(String message) {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
	/**
	 * This method displays the given quantity value on the screen/
	 */
	private void displayPrice(int number) {
		TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
		priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
	}
    
    /**
     * Increase Price by 1.
     */
    public void increasePrice(View view) {
		price ++;
	    displayPrice(price);
    }
    
    /**
     * Decrease Price by 1.
     */
    public void decreasePrice(View view) {
	    price --;
	    if (price < 0)
			price = 0;
	    displayPrice(price);
    }
	
}