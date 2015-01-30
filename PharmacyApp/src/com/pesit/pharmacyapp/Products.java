package com.pesit.pharmacyapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;

public class Products //extends SQLiteOpenHelper 
{
	 String prod;
	 String comp;
	 String price;
	 
	 public Products(String Pname,String Cname,String pr)
	 {
		 prod = Pname;
         comp = Cname;
         price = pr;
	 }
	 
	 public Products(){}
	 public String getProductName(){
	        return this.prod;
	    }
	 public String getCompanyName(){
	        return this.comp;
	    }
	 public String getPrice(){
	        return this.price;
	    }
	 public void setProductName(String name){
	        this.prod = name;
	    }
	 public void setCompanyName(String name){
	        this.comp = name;
	    }
	 public void setPrice(String pri){
	        this.price = pri;
	    }
/*	 private static final String DATABASE_NAME = "DBName";

     private static final int DATABASE_VERSION = 2;

     // Database creation sql statement
     private static final String DATABASE_CREATE = "create table MyProducts(product text primary key,company text,price integer)";
     

     public Products(Context context,String Pname,String Cname,int pr) 
     {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
         prod = Pname;
         comp = Cname;
         price = pr;
     }

     // Method is called during creation of the database
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

     }*/
}
