package com.gilpix.result;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilpix.beginners.Beginners;
import com.gilpix.test.Level;
import com.gilpix.test.R;

public class Result extends Beginners {
	
	
	public int correct1;
	public TextView t1,marks,result;
	public ImageView img;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		
		
		result = (TextView)findViewById(R.id.text1);
		marks = (TextView) findViewById(R.id.text2);
		t1= (TextView) findViewById(R.id.text3);;
		img = (ImageView) findViewById(R.id.imageView1) ;

		 Bundle b=this.getIntent().getExtras();
		   // String[] array=b.getStringArray("mes");
		    String recive = getIntent().getStringExtra("string");
		 
		
		 int point = Integer.parseInt(recive);
		//t1.setText(recive);
		marks.setText(recive+" "+"Out Of 15");
		//result.setText(rec.toString());
		if(point == 15 ){
			 img.setBackgroundResource(R.drawable.excelent);
	          t1.setText("Excellent");}
	        if(point > 10 && point <= 14){
	        	 img.setBackgroundResource(R.drawable.good);
	            t1.setText("Good");}
	        if(point > 5 && point <= 9 ){
	        	 img.setBackgroundResource(R.drawable.average);
	            t1.setText("Average");}
	        if(point <= 5 ){
	            t1.setText("Poor");
	        img.setBackgroundResource(R.drawable.poor);
	        }
		
	        
	        
	        
	        DisplayMetrics metrics = getResources().getDisplayMetrics();
		      //----------ACTION BAR----------//
			    ActionBar actionbar = getActionBar();
			    //actionbar.setDisplayUseLogoEnabled(false);//
		        //actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
		        Drawable d=getResources().getDrawable(R.drawable.action2);  
		        getActionBar().setBackgroundDrawable(d);
		        //----------ACTION BAR----------//
		        getActionBar().setIcon(android.R.color.transparent);
		       
		    
			        if (metrics.densityDpi >=240 )
			        {
			        	TextView title;
			 	        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
			 	        getActionBar().setCustomView(R.layout.actiobar); 
			 	        title= (TextView)findViewById(R.id.title);
			 	        title.setText("RESULT");
			            
			            
			        }
			        else if(metrics.densityDpi <240)
			        {
			        	getActionBar().hide();
			        }
	        
	        
		       
		   
	        

	        
	        
	        
	        
	        
	        int[] ques={R.drawable.poor,R.drawable.average,R.drawable.good,R.drawable.excelent};
	        
	        
	        
	        
	        
	        
	        
	        
	        
		
    ///////////////////////////////////////////////////////////
		final View Button = findViewById(R.id.home);
        Button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                
            	Intent intent = new Intent(Result.this,Level.class);
	             startActivity(intent);
	             finish();
            }
        });
    
    
	
		
	}
	
	@Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Result.this);
        builder.setMessage("Do you really want to exit?.").setCancelable(
                false).setPositiveButton("Quit",
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	Result.this.finish();
                    	Intent intent = new Intent(Result.this,Level.class);
	     		           startActivity(intent);

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



