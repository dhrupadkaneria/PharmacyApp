package com.pesit.pharmacyapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner spinner1;
	private Button btnSubmit;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
		  public void addListenerOnSpinnerItemSelection() {
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		  }
		 
		  // get the selected drop down list value
		  public void addListenerOnButton() {
		 
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			
			btnSubmit = (Button) findViewById(R.id.btnSubmit);
		 
			btnSubmit.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
				  
				  	if(String.valueOf(spinner1.getSelectedItem()).equals("Available products"))
				  	{
				  		Intent myintent = new Intent(MainActivity.this,AvailableProducts.class);
					    startActivity(myintent);  
				  	}
				  	
				  	else if(String.valueOf(spinner1.getSelectedItem()).equals("Out of stock products"))
				  	{
				  		Intent myintent = new Intent(MainActivity.this,OutOfStock.class);
					    startActivity(myintent);  
				  	}
				  	
					else if(String.valueOf(spinner1.getSelectedItem()).equals("Ordered products"))
				  	{
				  		Intent myintent = new Intent(MainActivity.this,OrderedProducts.class);
					    startActivity(myintent);  
				  	}
					else if(String.valueOf(spinner1.getSelectedItem()).equals("Add products"))
				  	{
				  		Intent myintent = new Intent(MainActivity.this,AddProducts.class);
					    startActivity(myintent);  
				  	}
			  }
		 
			});
		  }
		  
		  public class CustomOnItemSelectedListener implements OnItemSelectedListener {
			  
			  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
				Toast.makeText(parent.getContext(), 
					"Selected option : " + parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_SHORT).show();
				
			 	//Log.i("TAG", String.valueOf(spinner1.getSelectedItem()));
			  }
			  
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			  }

		  }
}
