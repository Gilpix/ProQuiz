package com.gilpix.test;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.gilpix.audio.Acategories;
import com.gilpix.beginners.Categories;
import com.gilpix.picture.Pcategories;

@SuppressLint("NewApi")
public class Level extends Activity { 

	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_level);
	        
	    /*  //----------ACTION BAR----------//
		    ActionBar actionbar = getActionBar();
		    actionbar.setDisplayUseLogoEnabled(false);//
	        actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
	        Drawable d=getResources().getDrawable(R.drawable.action2);  
	        getActionBar().setBackgroundDrawable(d);
	        //----------ACTION BAR----------//
	        
	      */  
	        
	        
	        
	        
	        
	        final View p_quiz = findViewById(R.id.p_quiz);
	        p_quiz.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Level.this,Pcategories.class);
		             startActivity(intent);
		             finish();
		            
	            }
	        });
	       
	        
	     final View audio = findViewById(R.id.A_quiz);
	     audio.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Level.this,Acategories.class);
		             startActivity(intent);
		             finish();
	            }
	        });
	     
	        final View imageButton = findViewById(R.id.big);
	        imageButton.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Level.this,Categories.class);
		             startActivity(intent);
		             finish();
	            }
	        });
	 }
	        
	 
	 
	 
	 
		@Override
	    public void onBackPressed() {
	        AlertDialog.Builder builder = new AlertDialog.Builder(Level.this);
	        builder.setMessage("Do you really want to exit?.").setCancelable(
	                false).setPositiveButton("Quit",
	                        new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int id) {
	                    	Level.this.finish();

	                    }
	                }).setNegativeButton("Cancel",
	                        new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int id) {

	                    }
	                });
	        AlertDialog alert = builder.create();
	        alert.show();

	    }
	 
	      
	        


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.level, menu);
	        return true;
	    }
	    
	   
	}

