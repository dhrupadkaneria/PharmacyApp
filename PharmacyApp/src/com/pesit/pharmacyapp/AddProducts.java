package com.pesit.pharmacyapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AddProducts extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_products);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_products, menu);
		return true;
	}
	
	 public void Add_to_DB(View v)
	    { 
	        	 Toast.makeText(this,"ADD TO DB", Toast.LENGTH_SHORT).show();
	        	 
	        	 EditText myEditText =  (EditText) findViewById(R.id.editText1);
	        	 String text = myEditText.getText().toString();
	        	 Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
	        	 
	        	 EditText myEditText1 =  (EditText) findViewById(R.id.editText3);
	        	 String text1 = myEditText1.getText().toString();
	        	 Toast.makeText(this,text1, Toast.LENGTH_SHORT).show();
	        	 
	        	 EditText myEditText2 =  (EditText) findViewById(R.id.editText2);
	        	 String text2 = myEditText2.getText().toString();
	        	 Toast.makeText(this,text2, Toast.LENGTH_SHORT).show();
	        	 
	        	 DatabaseHandler db = new DatabaseHandler(this);
	        	 
	        	 Log.d("Insert: ", "Inserting .."); 
	             db.addProduct(new Products(text, text1,text2));
	             
	             Log.d("Reading: ", "Reading all products.."); 
	             List<Products> products = db.getAllProducts();       
	              
	             for (Products cn : products) {
	                 String log = "Product: "+cn.getProductName()+" ,Company: " + cn.getCompanyName() + " ,Price: " + cn.getPrice();
	                     // Writing Contacts to log
	             Log.d("Name: ", log);
	        	 
	        	 
	    }
	    }

}


