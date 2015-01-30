package com.pesit.pharmacyapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper
{
	 private static final String DATABASE_NAME = "medicines";

     private static final int DATABASE_VERSION = 2;
     
     private static final String TABLE_PRODUCTS = "MyProducts";

     // Database creation sql statement
     private static final String DATABASE_CREATE = "create table MyProducts(product text primary key,company text,price text)";
  // Method is called during creation of the database
     public DatabaseHandler(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }
     @Override
     public void onCreate(SQLiteDatabase database) {
         database.execSQL(DATABASE_CREATE);
     }

     // Method is called during an upgrade of the database,
     @Override
     public void onUpgrade(SQLiteDatabase database, int oldVersion,
             int newVersion) {
         Log.w(Products.class.getName(),
                 "Upgrading database from version " + oldVersion + " to "
                         + newVersion + ", which will destroy all old data");
         database.execSQL("DROP TABLE IF EXISTS MyEmployees");
         onCreate(database);

     }
     
     /**
      * All CRUD(Create, Read, Update, Delete) Operations
      */
     void addProduct(Products product) {
         SQLiteDatabase db = this.getWritableDatabase();
  
         ContentValues values = new ContentValues();
         values.put("product", product.getProductName()); // Contact Name
         values.put("company", product.getCompanyName()); // Contact Phone
         values.put("price", product.getPrice());
  
         // Inserting Row
         db.insert(TABLE_PRODUCTS, null, values);
         db.close(); // Closing database connection
     }
  // Getting All Products
     public List<Products> getAllProducts() {
         List<Products> productList = new ArrayList<Products>();
         // Select All Query
         String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
  
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(selectQuery, null);
  
         // looping through all rows and adding to list
         if (cursor.moveToFirst()) {
             do {
                 Products product = new Products();
                // contact.setID(Integer.parseInt(cursor.getString(0)));
                 product.setProductName(cursor.getString(0));
                 product.setCompanyName(cursor.getString(1));
                 product.setPrice(cursor.getString(2));
                 // Adding contact to list
                 productList.add(product);
             } while (cursor.moveToNext());
         }
  
         // return contact list
         return productList;
     }
}
