package com.app.teg;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.app.teg.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity4 extends Activity {
	// Declare Variables
	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview2;
	ListViewAdapter2 adapter;
	ProgressDialog mProgressDialog;
	ArrayList<HashMap<String, String>> arraylist;
	static String PID = "pid";
	static String TITLE = "title";
	static String EMAIL = "email";
	static String PRESIDENT = "president";
	static String GENSEC = "gensec";	
	static String DESC="description";
	static String PIC = "pic";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main2);
		// Execute DownloadJSON AsyncTask
		new DownloadJSON().execute();
	}

	// DownloadJSON AsyncTask
	private class DownloadJSON extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(MainActivity4.this);
			// Set progressdialog title
			mProgressDialog.setTitle("Societies List");
			// Set progressdialog message
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Create an arrayS
			arraylist = new ArrayList<HashMap<String, String>>();
			// Retrieve JSON Objects from the given URL address
			jsonobject = JSONfunctions
				 .getJSONfromURL("http://thaparlympics.com/thapareventsguide/get_all_societies.php");

			try {
				// Locate the array name in JSON
				jsonarray = jsonobject.getJSONArray("eventstu");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					// Retrieve JSON Objects
					map.put("pid", jsonobject.getString("pid"));
					map.put("title", jsonobject.getString("title"));
					map.put("email", jsonobject.getString("email"));
					map.put("president", jsonobject.getString("president"));
					map.put("gensec", jsonobject.getString("gensec"));
					map.put("description", jsonobject.getString("description"));					
					map.put("pic", jsonobject.getString("pic"));
					
					// Set the JSON Objects into the array
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void args) {
			// Locate the listview in listview_main.xml
			listview2 = (ListView) findViewById(R.id.listview2);
			// Pass the results into ListViewAdapter.java
			adapter = new ListViewAdapter2(MainActivity4.this, arraylist);
			// Set the adapter to the ListView
			listview2.setAdapter(adapter);
			// Close the progressdialog
			mProgressDialog.dismiss();
		}
	}
}