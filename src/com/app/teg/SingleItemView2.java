package com.app.teg;

import com.app.teg.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView2 extends Activity {
	// Declare Variables
	String pid;
	String title;
	String email;
	String president;
	String gensec;
	String pic;
	String position;
	String description;
	ImageLoader2 imageLoader2 = new ImageLoader2(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview2);

		Intent i = getIntent();
		// Get the result of rank
		pid = i.getStringExtra("pid");
		title = i.getStringExtra("title");
		// Get the result of country
		email = i.getStringExtra("email");
		// Get the result of population
		president = i.getStringExtra("president");
		gensec = i.getStringExtra("gensec");
		
		description = i.getStringExtra("description");
		// Get the result of flag
		pic = i.getStringExtra("pic");

		// Locate the TextViews in singleitemview.xml
		TextView txtpid = (TextView) findViewById(R.id.pid);
		TextView txttitle = (TextView) findViewById(R.id.title);
		TextView txtemail = (TextView) findViewById(R.id.email);
		TextView txtpresident = (TextView) findViewById(R.id.president);
		TextView txtgensec = (TextView) findViewById(R.id.gensec);
		TextView txtdesc = (TextView) findViewById(R.id.description);

		// Locate the ImageView in singleitemview.xml
		ImageView imgpic = (ImageView) findViewById(R.id.pic);

		// Set results to the TextViews
		txtpid.setText(pid);
		txttitle.setText(title);
		txtemail.setText(email);
		txtpresident.setText(president);
		txtgensec.setText(gensec);
		txtdesc.setText(description);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader2.DisplayImage(pic, imgpic);
	}
}