package com.app.teg;
/*package com.app.teg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeClass extends Activity implements View.OnClickListener{

		 ImageButton ibAddEvent,ibListEvent;
			TextView tv1;
			Typeface type;
	 
		
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.homescreen);
	        
	    	initialize();
			type = Typeface.createFromAsset(getAssets(),"fonts/fleck.ttf"); 
			tv1.setTypeface(type); 
		}
	        
		private void initialize() {
			// TODO Auto-generated method stub
			tv1=(TextView)findViewById(R.id.tv1);
			ibAddEvent= (ImageButton)findViewById(R.id.ibAddEvent);
			
			ibListEvent= (ImageButton)findViewById(R.id.ibListEvent);
			
			ibAddEvent.setOnClickListener(this);
			
			ibListEvent.setOnClickListener(this);
		
			
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch(v.getId())
			{
				case R.id.ibListEvent:
				{
					Intent i = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(i);
					break;
				}
					
			
				case R.id.ibAddEvent:
				{
					Intent i = new Intent(getApplicationContext(), MainActivity2.class);
					startActivity(i);
					break;
				}
							
			}
					
		}
		
		public void onBackPressed() {
	        //Display alert message when back button has been pressed
	        backButtonHandler();
	        return;
	    }
		 public void backButtonHandler() {
		        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
		                HomeClass.this);
		        // Setting Dialog Title
		        alertDialog.setTitle("Leave application?");
		        // Setting Dialog Message
		        alertDialog.setMessage("Are you sure you want to leave the application?");
		     // Setting Icon to Dialog
		        alertDialog.setIcon(R.drawable.exit);	        
		        // Setting Positive "Yes" Button
		        alertDialog.setPositiveButton("YES",
		                new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int which) {
		                        finish();
		                    }
		                });
		        // Setting Negative "NO" Button
		        alertDialog.setNegativeButton("NO",
		                new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int which) {
		                        // Write your code here to invoke NO event
		                        dialog.cancel();
		                    }
		                });
		        // Showing Alert Message
		        alertDialog.show();
		    }
			
		} */