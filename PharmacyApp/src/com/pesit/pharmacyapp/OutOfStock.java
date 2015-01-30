package com.pesit.pharmacyapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OutOfStock extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_of_stock);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_of_stock, menu);
		return true;
	}

}
