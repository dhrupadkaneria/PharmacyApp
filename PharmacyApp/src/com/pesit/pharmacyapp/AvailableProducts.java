package com.pesit.pharmacyapp;


import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AvailableProducts extends ListActivity {
	//Button button1,button2;
	ListView listView ;
	int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_products);
        listView = (ListView) findViewById(android.R.id.list);
        //listView = (ListView) findViewById(R.id.list);
        DatabaseHandler db = new DatabaseHandler(this);
        List<Products> products = db.getAllProducts();
        //String[] values = new String[200];
        ArrayList<String> ar = new ArrayList<String>();
        for (Products m : products) {
            String str = "NAME: " + m.getProductName() + " \nCOMPANY: " + m.getCompanyName()+" \nPRICE: "+m.getPrice();
            //values[i]=str;
            ar.add(str);
            //Log.d("Name: ",values[i] );
            //i=i+1;
        }
        //i=i-1;
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,ar);
   //     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
     //           android.R.layout.simple_list_item_1, android.R.id.text1, values);
     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
       //                 android.R.layout.simple_list_item_1, values);

              // Assign adapter to ListView
             listView.setAdapter(adapter);
        
             
    }
} 
 



