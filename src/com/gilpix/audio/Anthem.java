package com.gilpix.audio;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gilpix.result.Result;
import com.gilpix.test.R;

	public class Anthem extends Activity {
		
		private int currentQuestion;
		private String [] questions;
		private String [] answers;
		private String [] ans1;
		private String [] ans2;
		private String [] ans3;
		private String [] ans4;
		private Button answerButton;
		private Button questionButton;
		private TextView questionView;
		private TextView answerView;
		public int correct;
		 public static  String msg = "SEND MESSAGE";
		
		 
		 
		 
		 
		CheckBox opt1,opt2,opt3,opt4;
		String r;
	     int point=0;
	     int neg = 0;
	     public Button image;
	     public ImageButton stop;
	     
	    int [] songs;
	  	MediaPlayer mediaPlayer;
	  	int current_index = 0; 
	     
	  

		@SuppressLint("NewApi")
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.audio);
			
			answerButton = (Button)findViewById(R.id.submit);
			questionButton = (Button)findViewById(R.id.next);
			questionView = (TextView)findViewById(R.id.ques);
			answerView = (TextView) findViewById(R.id.result);
			
			
			
			 opt1 = (CheckBox)findViewById(R.id.checkBox1);
			 opt1.setOnCheckedChangeListener(listener);
			 
			 opt2 = (CheckBox)findViewById(R.id.checkBox2);
			 opt2.setOnCheckedChangeListener(listener);
			 
			 opt3 = (CheckBox)findViewById(R.id.checkBox3);
			 opt3.setOnCheckedChangeListener(listener);
			 
			 opt4 = (CheckBox)findViewById(R.id.checkBox4);
			 opt4.setOnCheckedChangeListener(listener);
			
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
			 	        title.setText("NATIONAL ANTHEM");   
			        }
			        else if(metrics.densityDpi <160)
			        {
			        	getActionBar().hide();
			        }
		        
			        CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
			        
			        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
					checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
					checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
					checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
			        
			        final float scale1 = this.getResources().getDisplayMetrics().density;
			        checkBox1.setPadding(checkBox1.getPaddingLeft() + (int)(10.0f * scale1 + 0.5f),
			          		checkBox1.getPaddingTop(),
			                checkBox1.getPaddingRight(),
			                checkBox1.getPaddingBottom());
			        final float scale2 = this.getResources().getDisplayMetrics().density;
			        checkBox2.setPadding(checkBox2.getPaddingLeft() + (int)(10.0f * scale2 + 0.5f),
			          		checkBox2.getPaddingTop(),
			                checkBox2.getPaddingRight(),
			                checkBox2.getPaddingBottom());
			        final float scale3 = this.getResources().getDisplayMetrics().density;
			        checkBox3.setPadding(checkBox3.getPaddingLeft() + (int)(10.0f * scale3 + 0.5f),
			          		checkBox3.getPaddingTop(),
			                checkBox3.getPaddingRight(),
			                checkBox3.getPaddingBottom());
			        final float scale4 = this.getResources().getDisplayMetrics().density;
			        checkBox4.setPadding(checkBox4.getPaddingLeft() + (int)(10.0f * scale4 + 0.5f),
			          		checkBox4.getPaddingTop(),
			                checkBox4.getPaddingRight(),
			                checkBox4.getPaddingBottom());
			        
			
			
			init(); 
			
		}
		
		
		
		public OnCheckedChangeListener listener = new OnCheckedChangeListener() {
			 
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
			if(isChecked){
			switch(arg0.getId())
			  {
			    case R.id.checkBox1:
			    	opt1.setChecked(true);
			    	opt2.setChecked(false);
			    	opt3.setChecked(false);
			    	opt4.setChecked(false);
			         break;
			    case R.id.checkBox2:
			    	opt2.setChecked(true);
			    	opt1.setChecked(false);
			    	opt3.setChecked(false);
			    	opt4.setChecked(false);
			         break;
			   case R.id.checkBox3:
				   opt3.setChecked(true);
				   opt1.setChecked(false);
			        opt2.setChecked(false);
			        opt4.setChecked(false);
			        break;
			   case R.id.checkBox4:
				   opt4.setChecked(true);
				   opt1.setChecked(false);
			        opt2.setChecked(false);
			        opt3.setChecked(false);
			        break;
			  }
			}
			 
			}
			};
		
		
		
////////////////////Press Lower Back Button			
			@Override
		    public void onBackPressed() {
		        AlertDialog.Builder builder = new AlertDialog.Builder(Anthem.this);
		        builder.setMessage("Do you really want to exit?").setCancelable(
		                false).setPositiveButton("Quit",
		                        new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int id) {
		                    	mediaPlayer.stop();
		                    	Anthem.this.finish();
		                    	Intent intent = new Intent(Anthem.this,Acategories.class);
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
////////////////////Press Lower Back Button		
			
			
/////////////////////set back button
			 @Override
			 public boolean onOptionsItemSelected(MenuItem item){
				 switch (item.getItemId())
				 {
				 
				 case (android.R.id.home) :
				 Intent intent= new Intent(this,Acategories.class);
				 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 startActivity(intent);
				 mediaPlayer.stop();
				 finish();
				 return true;
			     default :
			    	 return super.onOptionsItemSelected(item);	 
				 }
			 }//set back button	
/////////////////////set back button		 
		
			 
			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.beginner, menu);
				return true;
			}

	

		public void init()
		{
			  songs= new int[] {R.raw.ant_argentina,R.raw.ant_australia ,R.raw.ant_brazil ,R.raw.ant_china ,R.raw.ant_india ,R.raw.ant_japan ,R.raw.ant_japan ,R.raw.ant_nepal ,R.raw.ant_new_zealand ,R.raw.ant_norway ,
					  R.raw.ant_sweden ,R.raw.ant_switzerland ,R.raw.ant_taiwan ,R.raw.ant_thailand ,R.raw.ant_uganda ,R.raw.ant_united_kingdom}; 
			
		questions = new String[]{
		"Q1. This country is the fifth largest producer of wine in the world",      
		"Q2. Chemist Dave Warren invented the black box in 1953 belongs to",
		"Q3. Samba – A beautiful complex dance and music is famous in",
		"Q4. Which country is famous for its one child policy?",
		"Q5. Zero or 0 in mathematics is founded by which country?",
		"Q6. 'Tokyo' is the capital of which country ",
		"Q7. Arun valley, the deepest valley in the world is located in",
		"Q8. Only 5% of which country population is human- the rest are animals?",
		"Q9. 'Oslo' is the capital of which country ",
		"Q10. World's third biggest exporter of music after the US and the UK is",
		"Q11. Which country is famous for its no-interference policy in the war?",
		"Q12. Which country offer free WiFi on a mass scale? ",
		"Q13. It is the world’s most visited place in 2013 ",
		"Q14. Which country referred as Pearl of Africa by Winston Churchil?",
		"Q15. Which country is famous for Big Ben, a tall clock in the center of the capital?"
			};
			
		answers = new String[]{"Argentina", "Australia", "Brazil", "China", "India", "Japan", "Nepal", "New Zealand", 
					"Norway","Sweden", "Switzerland", "Taiwan", "Thailand", "Uganda", "United Kingdom"};
				
		ans1 = new String[]{"Argentina", "Belgium", "Canada", "Colombia", "Russia", "United Kingdom",
		"Australia", "Cuba", "Denmark", "Sweden", "Sri Lanka", "Taiwan", "Russia", "South Africa", 
		"Germany",};
		
		ans2 = new String[]{"France", "Australia", "Egypt", "China", "India", "Denmark"
		, "Finland", "Albania", "Norway", "South Africa", "Switzerland", "France", "Colombia",
		"Sri Lanka", "United Kingdom",};
		
		ans3 = new String[]{"Egypt", "Turkey", "Brazil", "United Kingdom", "Finland", "Greece",
		"Pakistan", "New Zealand", "Rutherford", "Hong Kong", "Australia", "Mexico", 
		"Thailand", "Albania", "France",};
		
		ans4 = new String[]{"Colombia", "Mexico", "Sri Lanka", "Pakistan", "Zimbabwe", "Japan",
		"Nepal", "Zimbabwe", "Germany", "Turkey", "Egypt", "Germany", "Egypt", 
		"Uganda", "Colombia",};
		
		
		 
		 currentQuestion = 0;



opt1.setText(ans1[currentQuestion]);
opt2.setText(ans2[currentQuestion]);
opt3.setText(ans3[currentQuestion]);
opt4.setText(ans4[currentQuestion]);



mediaPlayer = MediaPlayer.create(this, songs[0]);
final Button play_button = (Button)this.findViewById(R.id.play);
play_button.setBackgroundResource(R.drawable.play);
play_button.setOnClickListener(new OnClickListener(){

    public void onClick(View v) {
        // If the music is playing
        if(mediaPlayer.isPlaying() == true){
            // Pause the music player  
       	 play_button.setBackgroundResource(R.drawable.play);
       	 mediaPlayer.pause();}
        // If it's not playing
        else{
            // Resume the music player
       	 play_button.setBackgroundResource(R.drawable.pause);
       	 mediaPlayer.start();
    }}
});



mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	    public void onCompletion(MediaPlayer mediaPlayer1) {
	    	play_button.setBackgroundResource(R.drawable.play);
	    	 mediaPlayer.pause();
	    }
	});


questionView.setText(questions[currentQuestion]);
 answerView.setText("");
 
 
Lable1: {	 
	 answerButton.setOnClickListener(new OnClickListener(){
     @Override
	 public void onClick(View v) {        
	 
    	 if(opt1.isChecked()||opt2.isChecked()||opt3.isChecked()||opt4.isChecked()){  
	    	mediaPlayer.stop();
	    	play_button.setBackgroundResource(R.drawable.play);
	    	
		 if (opt1.isChecked()) {
			 
	        opt2.setChecked(false);
	        opt3.setChecked(false);
	        opt4.setChecked(false);
 	        r = opt1.getText().toString();
	      }
	      if (opt2.isChecked()) {
	      
	        opt1.setChecked(false);
	        opt3.setChecked(false);
	        opt4.setChecked(false);
	        r = opt2.getText().toString();
	      }
	      if (opt3.isChecked()) {
	      
	        opt2.setChecked(false);
	        opt1.setChecked(false);
	        opt4.setChecked(false);
	        r = opt3.getText().toString();
	      }
	      if (opt4.isChecked()) {
	      
	       opt2.setChecked(false);
	        opt3.setChecked(false);
	        opt1.setChecked(false);
	       r = opt4.getText().toString();
	      }
	      checkAnswer(r);
	      opt1.setChecked(false);
		    opt2.setChecked(false);
	        opt3.setChecked(false);
		    opt4.setChecked(false);
		    showQuestion();
	        
	     }
	    else {
	    	Toast toast= Toast.makeText(getApplicationContext(), 
					"Select Atleast one Option", Toast.LENGTH_SHORT);  
					toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
					toast.show();
					 mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
		        	    public void onCompletion(MediaPlayer mediaPlayer1) {
		        	    	play_button.setBackgroundResource(R.drawable.play);
		        	    	 mediaPlayer.pause();
		        	    }
		        	});
					
				    
	    }

	   

    
}});
break Lable1;
}


questionButton.setOnClickListener(new OnClickListener(){
@Override
public void onClick(View v) {
	 play_button.setBackgroundResource(R.drawable.play);
	 mediaPlayer.stop();
	
	opt1.setChecked(false);
   opt2.setChecked(false);
   opt3.setChecked(false);
   opt4.setChecked(false);
   
showQuestion();
}});
}


/*
* This method
* 1: increment currentQuestion index
* 2: check if it is equal to the size of the array and rest
if necessary
* 3: display the question at currentQuestion index in
question view
* 4: Empty answer view
*/

public void showQuestion()
{
currentQuestion++;
if(currentQuestion == (questions.length)){
	correct = point;
	String ms = Integer.toString(correct);
	msg=ms; 
	currentQuestion =0;
	 point = 0;
	 
	 
	 Bundle b=new Bundle();
	b.putStringArray("mes", new String[]{answers[0],answers[1]});
   
	Intent in=new Intent(Anthem.this,Result.class);
	in.putExtra("string",msg );
   in.putExtras(b);
	 startActivity(in);
	 finish();		
}


mediaPlayer = MediaPlayer.create(this, songs[currentQuestion]);  
final Button play_button = (Button)this.findViewById(R.id.play);

play_button.setOnClickListener(new OnClickListener(){
  public void onClick(View v) {
      // If the music is playing
      if(mediaPlayer.isPlaying() == true){
          // Pause the music player  
     	 play_button.setBackgroundResource(R.drawable.play);
     	mediaPlayer.pause();}
      // If it's not playing
      else{
          // Resume the music player
     	 play_button.setBackgroundResource(R.drawable.pause);
     	mediaPlayer.start();
  }}
});

mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
  public void onCompletion(MediaPlayer mediaPlayer1) {
  	play_button.setBackgroundResource(R.drawable.play);
  	 mediaPlayer.pause();
  }
});


  
questionView.setText(questions[currentQuestion]);
answerView.setText("");
opt1.setText(ans1[currentQuestion]);
opt2.setText(ans2[currentQuestion]);
opt3.setText(ans3[currentQuestion]);
opt4.setText(ans4[currentQuestion]);

}

/*
* This method return true if the answer equals to correct
answer
* (Ignoring case)
*/
public boolean isCorrect(String r)
{
return (r.equalsIgnoreCase(answers[currentQuestion]));
}


/* this method :
* 1: Read the text ( answer) from the answerTextEdit
* 2: call the isCorrect method
* 3: display the appropriate message.
*/
public void checkAnswer(String r)
{
	
if(isCorrect(r)){
point++;
	Toast toast2= Toast.makeText(getApplicationContext(), 
			"Correct", Toast.LENGTH_SHORT);  
	
			toast2.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
			toast2.show();

}
else{
neg++;


Toast toast3= Toast.makeText(getApplicationContext(), 
		"Correct answer is: "+answers[currentQuestion], Toast.LENGTH_SHORT);  
		toast3.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
		//toast3.setView(incorrect);
		toast3.show();
}}
}
