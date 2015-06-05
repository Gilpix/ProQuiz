package com.gilpix.audio;




	import android.annotation.SuppressLint;
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

	public class Acategories extends Activity { 

		 @SuppressLint("NewApi")
		@Override
		 protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.acategories);
		        
		        
		        DisplayMetrics metrics = getResources().getDisplayMetrics();
			      //----------ACTION BAR----------//
				    ActionBar actionbar = getActionBar();
				    //actionbar.setDisplayUseLogoEnabled(false);//
			        //actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
			        Drawable d=getResources().getDrawable(R.drawable.action2);  
			        getActionBar().setBackgroundDrawable(d);
			        //----------ACTION BAR----------//
			        getActionBar().setIcon(android.R.color.transparent);
			       
				        if (metrics.densityDpi >=160 )
				        {
				        	TextView title;
				 	        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
				 	        getActionBar().setCustomView(R.layout.actiobar); 
				 	        title= (TextView)findViewById(R.id.title);
				 	        title.setText("Audio Categories"); 
				        }
				        else if(metrics.densityDpi <160)
				        {
				        	getActionBar().hide();
				        }
		        
		        
		        
		        
		        
		         
                final View film = findViewById(R.id.animals);
		        film.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Animals.class);
			           startActivity(intent);
			           finish(); 
		            }
		        });
		        
		    	  		        final View geography = findViewById(R.id.anthem);
		        geography.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Anthem.class);
			       startActivity(intent);
			       finish();
		            }
		        });
		        
		        	 final View history = findViewById(R.id.games);
		        history.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Games.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        
		        final View literature = findViewById(R.id.language);
		        literature.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Languages.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        
		        
		        final View music = findViewById(R.id.serials);
		        music.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Serials.class);
			           startActivity(intent);
			           finish();
		            }
		        });
		        
		        
		        final View politics = findViewById(R.id.songs);
		        politics.setOnClickListener(new OnClickListener(){
		            @Override
		            public void onClick(View view) {
		                
		            	Intent intent = new Intent(Acategories.this,Songs.class);
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
