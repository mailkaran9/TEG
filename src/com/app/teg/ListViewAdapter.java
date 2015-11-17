package com.app.teg;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.teg.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter(Context context,
			ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView title;
		TextView date;
		TextView venue;
		TextView time;
		TextView description;
		ImageView pic;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.listview_item, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
		title = (TextView) itemView.findViewById(R.id.title);
		date = (TextView) itemView.findViewById(R.id.date);
		venue = (TextView) itemView.findViewById(R.id.venue);
		time = (TextView) itemView.findViewById(R.id.time);
		description = (TextView) itemView.findViewById(R.id.description);

		// Locate the ImageView in listview_item.xml
		pic = (ImageView) itemView.findViewById(R.id.pic);

		// Capture position and set results to the TextViews
		title.setText(resultp.get(MainActivity.TITLE));
		date.setText(resultp.get(MainActivity.DATE));
		venue.setText(resultp.get(MainActivity.VENUE));
		time.setText(resultp.get(MainActivity.TIME));
		description.setText(resultp.get(MainActivity.DESC));
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(MainActivity.PIC), pic);
		
	
		
		
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data rank
				intent.putExtra("title", resultp.get(MainActivity.TITLE));
				// Pass all data country
				intent.putExtra("date", resultp.get(MainActivity.DATE));
				// Pass all data population
				intent.putExtra("venue",resultp.get(MainActivity.VENUE));
				intent.putExtra("time",resultp.get(MainActivity.TIME));
				
				intent.putExtra("description",resultp.get(MainActivity.DESC));
				// Pass all data flag
				intent.putExtra("pic", resultp.get(MainActivity.PIC));
				// Start SingleItemView Class
				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
