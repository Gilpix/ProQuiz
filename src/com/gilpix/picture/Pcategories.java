package com.gilpix.picture;




	import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.gilpix.test.Level;
import com.gilpix.test.R;

	public class Pcategories extends Activity { 

		 @Override
		 protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.pcategories);
		        
		     /*   
		      //----------ACTION BAR----------//
			    ActionBar actionbar = getActionBar();
			    actionbar.setDisplayUseLogoEnabled(false);//
		        actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
		        Drawable d=getResources().getDrawable(R.drawable.action2);  
		        getActionBar().setBackgroundDrawable(d);
		        //----------ACTION BAR----------//
		       */ 
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
				 	        title.setText("Picture Categories");   
				        }
				        else if(metrics.densityDpi <240)
				        {
				        	getActionBar().hide();
				        }
			        
		        
		        
		        
		        
		        
		        final View film = findViewById(R.id.logo);
		        film.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,Logo.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        
		        
		        
		        final View geography = findViewById(R.id.monuments);
		        geography.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,Monuments.class);
			       startActivity(intent);
			       finish();
		            }
		        });
		        
		        
		        final View literature = findViewById(R.id.flags);
		        literature.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,Flags.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        
		        
		        final View music = findViewById(R.id.sports);
		        music.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,Sports.class);
			           startActivity(intent);
			           finish();
		            }
		        });
 
		        final View science = findViewById(R.id.nature);
		        science.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,Nature.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		           
		        final View imageButton = findViewById(R.id.people);
		        imageButton.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Pcategories.this,People.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        

	}
		 @Override
		    public boolean onCreateOptionsMenu(Menu menu) {
		        // Inflate the menu; this adds items to the action bar if it is present.
		        getMenuInflater().inflate(R.menu.level, menu);
		        return true;
		    }
		 
		 
		 
		 
		 @Override
		    public void onBackPressed() {
				 Intent intent= new Intent(this,Level.class);
				 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 startActivity(intent);
				 	finish();
		                    }
		       
		 
		 
		//set back button
		 @Override
		 public boolean onOptionsItemSelected(MenuItem item){
			 switch (item.getItemId())
			 {
			 
			 case (android.R.id.home) :
			 Intent intent= new Intent(this,Level.class);
			 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 startActivity(intent);
			
			 finish();
			 return true;
		     default :
		    	 return super.onOptionsItemSelected(item);
			 
			 }
			 		 
		 }//set back button	
		 
		 
	}
