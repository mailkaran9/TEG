package com.app.teg;

import com.app.teg.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MissionFragment extends Activity  {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList = (ListView) findViewById(R.id.left_drawer);
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;
    
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ourmission);
        




    mTitle = mDrawerTitle = getTitle();
    mPlanetTitles = getResources().getStringArray(R.array.planets_array);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

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

   
    
    
    
   

/*@Override
public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
        }

/*@Override
public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
        return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        case R.id.action_websearch:
        // create intent to perform web search for this planet
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
        // catch event that there's no activity to handle intent
        if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
        } else {
        Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
        }
        return true;
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


                startActivity(new Intent(this, AddEventFragment.class));



                break;
            case 1:
                startActivity(new Intent(this, HomeFragment.class));
                break;
            case 2:startActivity(new Intent(this, SocietiesFragment.class));
            case 3:startActivity(new Intent(this, MissionFragment.class));
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

	

        }