package com.app.teg;

import com.app.teg.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class DrawerClass extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTitle = mDrawerTitle = getTitle();
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()




            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
   }



    /* public static class ImageAdapter extends BaseAdapter {

        public Integer[] pics={R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};
        @Override
        public int getCount() {
            return pics.length;
        }
        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView img=new ImageView(context);
            img.setImageResource(pics[position]);
            return img;
        }

        private Context context;
        int imageback;

        public ImageAdapter(Context context)
        {
            this.context=context;
        }
    } */
    /* Called whenever we call invalidateOptionsMenu() */
   
/*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
       // menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        /*case R.id.action_websearch:
            // create intent to perform web search for this planet
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
            // catch event that there's no activity to handle intent
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
            }
            return true;*/
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments



        switch(position) {

            case 0:


                Fragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);


                fragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;
            case 1:
                Fragment fragment1 = new SocietiesFragment();
                Bundle args1 = new Bundle();
                args1.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);


                fragment1.setArguments(args1);

                FragmentManager fragmentManager1 = getFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.content_frame, fragment1).commit();
                break;
            case 2:
                Fragment fragment2 = new PlanetFragment();
                Bundle args2 = new Bundle();
                args2.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);


                fragment2.setArguments(args2);

                FragmentManager fragmentManager2 = getFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();
                break;
                
            case 3:
                Fragment fragment3 = new MissionFragment();
                Bundle args3 = new Bundle();
                args3.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);


                fragment3.setArguments(args3);

                FragmentManager fragmentManager3 = getFragmentManager();
                fragmentManager3.beginTransaction().replace(R.id.content_frame, fragment3).commit();
                break;

        }





                // update selected item and title, then close the drawer
                mDrawerList.setItemChecked(position, true);
                setTitle(mPlanetTitles[position]);
                mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Fragment that appears in the "content_frame", shows a planet
     */
    public static class PlanetFragment extends Fragment {
        public static final String ARG_PLANET_NUMBER = "planet_number";

        public PlanetFragment() {
            // Empty constructor required for fragment subclasses
        }
        
        Button Societies;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.planets_array)[i];
            
            Button Societies= (Button)rootView.findViewById(R.id.Society);

            Societies.setOnClickListener(new Button.OnClickListener() {
       			
       			@Override
       			public void onClick(View v) {
       				// TODO Auto-generated method stub
       				startActivity(new Intent(getActivity().getApplicationContext(),MainActivity4.class));
       				
       			}
       		});
            
           
            
            

           /* final int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                            "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(imageId);
            Gallery gallery=(Gallery) rootView.findViewById(R.id.gallery);

            gallery.setAdapter(new ImageAdapter(getActivity()));
            gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public Integer[] pics={R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(pics[position]);
                }
            }); */
            getActivity().setTitle(planet);
            return rootView;
        }
    }


    @SuppressLint("ValidFragment")
	public class HomeFragment extends Fragment{
        public static final String ARG_PLANET_NUMBER = "planet_number";



        @SuppressLint("ValidFragment")
		public HomeFragment() {
            // Empty constructor required for fragment subclasses
        }
        
        ImageView ibTech,ibCultural,ibFest;
		TextView tv1;
        Typeface type;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.homescreen, container, false);

            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.planets_array)[i];
            
           // TextView tv1=(TextView)findViewById(R.id.tv1);
            ImageView ibTech= (ImageView)rootView.findViewById(R.id.ibTech);            
            ImageView ibCultural= (ImageView)rootView.findViewById(R.id.ibCultural);
            ImageView ibFest= (ImageView)rootView.findViewById(R.id.ibFest);
            
           // initialize();
			//type = Typeface.createFromAsset(getAssets(),"fonts/fleck.ttf"); 
			//tv1.setTypeface(type);
			//tv1=(TextView)findViewById(R.id.tv1);
           
            ibCultural.setOnClickListener(new ImageView.OnClickListener() {
       			
       			@Override
       			public void onClick(View v) {
       				// TODO Auto-generated method stub
       				startActivity(new Intent(getApplicationContext(),MainActivity.class));
       				
       			}
       		});
            
            ibFest.setOnClickListener(new ImageView.OnClickListener() {
       			
       			@Override
       			public void onClick(View v) {
       				// TODO Auto-generated method stub
       				startActivity(new Intent(getApplicationContext(),MainActivity3.class));
       				
       			}
       		});
            
            ibTech.setOnClickListener(new ImageView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),MainActivity2.class));
				
			}
		}); 
                   
           
           
           
            getActivity().setTitle(planet);
            
            return rootView;
        }
        
             
        
         
        

    }
    
    @SuppressLint("ValidFragment")
	public class SocietiesFragment extends Fragment {
        @SuppressLint("ValidFragment")
		public static final String ARG_PLANET_NUMBER = "planet_number";



        @SuppressLint("ValidFragment")
		public SocietiesFragment() {
            // Empty constructor required for fragment subclasses
        }
        
        TextView name,category,venue,time,date,synopsis,organisers;
        String id;
        Button Report;
        String Name, Time, Date, Category, Venue, emailAdd, Synopsis, Organisers;
        
       //JSONParser jsonParser = new JSONParser();
        
       /* private static final String TAG_NAME = "Name";
        private static final String TAG_VENUE = "Venue";
        private static final String TAG_SYNOPSIS = "Synopsis";
        private static final String TAG_CATEGORY = "Category";
        private static final String TAG_DATE ="Date";
        private static final String TAG_EVENTSLIST = "eventslist";
        private static final String TAG_TIME = "Time";
        private static final String TAG_ORGANISERS = "Organisers"; */
        

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.fragment_addevent, container, false);

            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.planets_array)[i];
            
            
            //JSONObject json = jsonParser.makeHttpRequest(url_event_details, "GET", params);
           
          //  JSONArray eventObj = json.getJSONArray(TAG_EVENTSLIST); // JSON Array 
           // JSONObject event = eventObj.getJSONObject(0); 
            
            Report=(Button)rootView.findViewById(R.id.bReport);
            
            name = (TextView)rootView.findViewById(R.id.etName);
            category = (TextView)rootView.findViewById(R.id.etCategory);
            date= (TextView)rootView.findViewById(R.id.etDate);
            organisers= (TextView)rootView.findViewById(R.id.etOrganisers);
            synopsis= (TextView)rootView.findViewById(R.id.etSynopsis);
            time= (TextView)rootView.findViewById(R.id.etTime);
            venue= (TextView)rootView.findViewById(R.id.etVenue);
            

            Report.setOnClickListener(new Button.OnClickListener() {
                  			
                  			@Override
                  			public void onClick(View v) {
                  				
                  				 // Set bold on click
                                Report.setTypeface(null, Typeface.BOLD);
                  				emailAdd = "thapareventguide@gmail.com";
                        		Category= category.getText().toString();
                        		Name = name.getText().toString();
                        		Venue = venue.getText().toString();
                        		Date= date.getText().toString();
                        		Time = time.getText().toString();
                        		Synopsis= synopsis.getText().toString();
                        		Organisers= organisers.getText().toString();
                        		
                  				
                  				String emailaddress[] = { emailAdd };
                  				String message = "Event Details "
                  						+"\n Name: "
                  						+ Name
                  						+ " \n Category: "
                  						+ Category
                  						+ "\n Venue: "
                  						+ Venue
                  						+ "\n Date: "
                  						+ Date
                  						+ " \n Time: "
                  						+ Time
                  						+" \n Synopsis: "
                  						+ Synopsis
                  						+" \n Organisers: "
                  						+ Organisers;
                  						
                  				Intent i = new Intent(android.content.Intent.ACTION_SEND);
                  				i.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
                  				i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Event Details");
                  				i.setType("plain/text");
                  				i.putExtra(android.content.Intent.EXTRA_TEXT,message);
                  				startActivity(i);
                  			}
                  		});
            
           /* @Override
            public void EditTexttoString() {
        		// TODO Auto-generated method stub
        		
        	} */

          /*  // display event data in EditText
            name.setText(event.getString(TAG_NAME));
            category.setText(event.getString(TAG_CATEGORY));
            date.setText(event.getString(TAG_DATE));
            venue.setText(event.getString(TAG_VENUE));
            synopsis.setText(event.getString(TAG_SYNOPSIS));
            time.setText(event.getString(TAG_TIME));
            organisers.setText(event.getString(TAG_ORGANISERS)); */
            

            getActivity().setTitle(planet);
            return rootView;
        }

    }
 
    @SuppressLint("MissionFragment")
	public class MissionFragment extends Fragment{
        public static final String ARG_PLANET_NUMBER = "planet_number";



        @SuppressLint("MissionFragment")
		public MissionFragment() {
            // Empty constructor required for fragment subclasses
        }
        
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.ourmission, container, false);

            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.planets_array)[i];
            
                                              
           
           
            getActivity().setTitle(planet);
            
            return rootView;
        }

    

}
    
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        return;
    }
	 public void backButtonHandler() {
	        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
	                DrawerClass.this);
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
    
    
    
}