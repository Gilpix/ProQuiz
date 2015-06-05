package com.gilpix.beginners;

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
import android.view.Window;
import android.widget.TextView;

import com.gilpix.test.Level;
import com.gilpix.test.R;

public class Categories extends Activity { 

	 @SuppressLint("NewApi")
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.categories);
	        
	        
	        
	        
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
		 	        title.setText("General Categories"); 
		        } 
		        else if(metrics.densityDpi <160)
		        {
		        	getActionBar().hide();
		        }
	        
	       
	        
	        
	        
	        
	        final View film = findViewById(R.id.entertainment);
	        film.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Entertainment.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        final View geography = findViewById(R.id.geography);
	        geography.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Geography.class);
		       startActivity(intent);
		       finish();
	            }
	        });
	        
	        final View history = findViewById(R.id.history);
	        history.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,History.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        final View literature = findViewById(R.id.literature);
	        literature.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Literature.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        
	        final View music = findViewById(R.id.music);
	        music.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Music.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        
	        final View politics = findViewById(R.id.politics);
	        politics.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Business.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        
	        final View religion = findViewById(R.id.religion);
	        religion.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Religion.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        
	        final View science = findViewById(R.id.science);
	        science.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Science.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	        
	        
	        final View sports = findViewById(R.id.sports);
	        sports.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Sports.class);
		           startActivity(intent);
		           finish();
	            }
	        });
	      
	        
	        final View imageButton = findViewById(R.id.gk);
	        imageButton.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View view) {
	                
	            	Intent intent = new Intent(Categories.this,Beginners.class);
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

		 return true;
	     default :
	    	 return super.onOptionsItemSelected(item);
		 
		 }
		 		 
	 }//set back button	
	 
	 
}
