package com.app.teg;

import com.app.teg.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;



public class Splash extends Activity{
	Intent i;
	Thread timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		// tvTitle=(TextView)findViewById(R.id.tvTitle);
		// type = Typeface.createFromAsset(getAssets(),"fonts/fleck.ttf"); 
		// tvTitle.setTypeface(type);
		
		timer=new Thread(){
			public void run(){
				try{
					sleep(3000);
				}
				catch( Exception e)
				{
					e.printStackTrace();
				}
				finally{
					i= new Intent(Splash.this,DrawerClass.class);
					startActivity(i);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}
}
