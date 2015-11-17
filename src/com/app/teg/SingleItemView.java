package com.app.teg;

import com.app.teg.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
	// Declare Variables
	String title;
	String date;
	String venue;
	String time;
	String pic;
	String position;
	String description;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		title = i.getStringExtra("title");
		// Get the result of country
		date = i.getStringExtra("date");
		// Get the result of population
		venue = i.getStringExtra("venue");
		time = i.getStringExtra("time");
		
		description = i.getStringExtra("description");
		// Get the result of flag
		pic = i.getStringExtra("pic");

		// Locate the TextViews in singleitemview.xml
		TextView txttitle = (TextView) findViewById(R.id.title);
		TextView txtdate = (TextView) findViewById(R.id.date);
		TextView txtvenue = (TextView) findViewById(R.id.venue);
		TextView txttime = (TextView) findViewById(R.id.time);
		TextView txtdesc = (TextView) findViewById(R.id.description);

		// Locate the ImageView in singleitemview.xml
		ImageView imgpic = (ImageView) findViewById(R.id.pic);

		// Set results to the TextViews
		txttitle.setText(title);
		txtdate.setText(date);
		txtvenue.setText(venue);
		txttime.setText(time);
		txtdesc.setText(description);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(pic, imgpic);
	}
}