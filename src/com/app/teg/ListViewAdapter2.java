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

public class ListViewAdapter2 extends BaseAdapter {

	// Declare Variables
	Context context2;
	LayoutInflater inflater2;
	ArrayList<HashMap<String, String>> data2;
	ImageLoader2 imageLoader2;
	HashMap<String, String> resultp2 = new HashMap<String, String>();

	public ListViewAdapter2(Context context2,
			ArrayList<HashMap<String, String>> arraylist) {
		this.context2 = context2;
		data2 = arraylist;
		imageLoader2 = new ImageLoader2(context2);
	}

	@Override
	public int getCount() {
		return data2.size();
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
		TextView pid;
		TextView title;
		TextView email;
		TextView president;
		TextView gensec;
		TextView description;
		ImageView pic;

		inflater2 = (LayoutInflater) context2
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater2.inflate(R.layout.listview_item2, parent, false);
		// Get the position
		resultp2 = data2.get(position);

		// Locate the TextViews in listview_item.xml
		pid = (TextView) itemView.findViewById(R.id.title);
		title = (TextView) itemView.findViewById(R.id.title);
		email = (TextView) itemView.findViewById(R.id.email);
		president = (TextView) itemView.findViewById(R.id.president);
		gensec = (TextView) itemView.findViewById(R.id.gensec);
		description = (TextView) itemView.findViewById(R.id.description);

		// Locate the ImageView in listview_item.xml
		pic = (ImageView) itemView.findViewById(R.id.pic); 

		// Capture position and set results to the TextViews
		pid.setText(resultp2.get(MainActivity4.PID));
		title.setText(resultp2.get(MainActivity4.TITLE));
		email.setText(resultp2.get(MainActivity4.EMAIL));
		president.setText(resultp2.get(MainActivity4.PRESIDENT));
		gensec.setText(resultp2.get(MainActivity4.GENSEC));
		description.setText(resultp2.get(MainActivity4.DESC));
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader2.DisplayImage(resultp2.get(MainActivity4.PIC), pic); 
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp2 = data2.get(position);
				Intent intent = new Intent(context2, SingleItemView2.class);
				// Pass all data rank
				intent.putExtra("pid", resultp2.get(MainActivity4.PID));
				intent.putExtra("title", resultp2.get(MainActivity4.TITLE));
				// Pass all data country
				intent.putExtra("email", resultp2.get(MainActivity4.EMAIL));
				// Pass all data population
				intent.putExtra("president",resultp2.get(MainActivity4.PRESIDENT));
				intent.putExtra("gensec",resultp2.get(MainActivity4.GENSEC));
				
				intent.putExtra("description",resultp2.get(MainActivity4.DESC));
				// Pass all data flag
				intent.putExtra("pic", resultp2.get(MainActivity4.PIC));
				// Start SingleItemView Class 
				context2.startActivity(intent);

			}
		});
		return itemView;
	}
}
