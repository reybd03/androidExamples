package com.example.engineeringtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private class MyTabListener implements ActionBar.TabListener{
	
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mFragname;
		
		public MyTabListener(Activity activity, String fragName){
			mActivity = activity;
			mFragname = fragName;
		}
		
		@Override
		public void onTabReselected( Tab tab, FragmentTransaction ft){
			
			// TODO Auto-generated method stud
		}
		
		@Override
		public void onTabSelected (Tab tab, FragmentTransaction ft){
		
			mFragment = Fragment.instantiate(mActivity, mFragname);
			ft.add(android.R.id.content, mFragment);
		}
		
		@Override
		public void onTabUnselected( Tab tab, FragmentTransaction ft){
			
			ft.remove(mFragment);
			mFragment = null;
		}
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		ActionBar ab = getActionBar();
		setTabNavigation(ab);
		
	
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		boolean ret;
		if (item.getItemId() == R.id.action_settings)
		{
			// Handle Settings
			ret = true;
		} else if (item.getItemId() == R.id.menu_toggle)
		{
			ActionBar ab = getActionBar();
			if (ab.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS)
			{
				setListNavigation( ab );
			} else
			{
				setTabNavigation( ab );
			}
			ret = true;
		} else
		{
			ret = super.onOptionsItemSelected( item );
		}
		return ret;
	}

	private void setTabNavigation( ActionBar actionBar){
		
		actionBar.removeAllTabs();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle( R.string.app_name);
		
		
		Tab tab = actionBar
				.newTab()
				.setText(R.string.app_name)
				.setTabListener(
						new MyTabListener(this, Home.class.getName()));
		actionBar.addTab(tab);
		
		tab = actionBar
				.newTab()
				.setText(R.string.textview_location1)
				.setTabListener(
						new MyTabListener(this, Location1.class.getName()));
		actionBar.addTab(tab);
		
		tab = actionBar
				.newTab()
				.setText(R.string.textView_location2)
				.setTabListener(
						new MyTabListener(this, Location2.class.getName()));
		actionBar.addTab(tab);
		
		tab = actionBar
				.newTab()
				.setText(R.string.textview_location3)
				.setTabListener(
						new MyTabListener(this, Location3.class.getName()));
		actionBar.addTab(tab);
		
		tab = actionBar
				.newTab()
				.setText(R.string.textview_location4)
				.setTabListener(
						new MyTabListener(this, Location4.class.getName()));
		actionBar.addTab(tab);
		
		tab = actionBar
				.newTab()
				.setText(R.string.textview_location5)
				.setTabListener(
						new MyTabListener(this, Location5.class.getName()));
		actionBar.addTab(tab);
		
		
	}

	private void setListNavigation( ActionBar actionBar){
		actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_LIST );
		actionBar.setTitle( "" );
		final List<Map<String, Object>> data = 
				new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.app_name) );
		map.put( "fragment", Fragment.instantiate( this, Home.class.getName() ));
		data.add( map );
		map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.textview_location1) );
		map.put( "fragment", Fragment.instantiate( this, Location1.class.getName() ));
		data.add( map );
		map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.textView_location2 ) );
		map.put( "fragment", Fragment.instantiate( this, Location2.class.getName() ));
		data.add( map );
		map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.title_activity_location3 ) );
		map.put( "fragment", Fragment.instantiate( this, Location3.class.getName() ));
		data.add( map );
		map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.textview_location4 ) );
		map.put( "fragment", Fragment.instantiate( this, Location4.class.getName() ));
		data.add( map );
		map = new HashMap<String, Object>();
		map.put( "title", getString( R.string.title_activity_location5 ) );
		map.put( "fragment", Fragment.instantiate( this, Location5.class.getName() ));
		data.add( map );
		SimpleAdapter adapter = new SimpleAdapter( this, data,
				android.R.layout.simple_spinner_dropdown_item,
				new String[] { "title" }, new int[] { android.R.id.text1 } );
		actionBar.setListNavigationCallbacks( adapter,
				new OnNavigationListener()
				{

					@Override
					public boolean onNavigationItemSelected( int itemPosition,
							long itemId )
					{
						Map<String, Object> map = data.get( itemPosition );
						Object o = map.get( "fragment" );
						if( o instanceof Fragment ) 
						{
							FragmentTransaction tx = getFragmentManager().beginTransaction();
							tx.replace( android.R.id.content, (Fragment )o );
							tx.commit();
						}
						return true;
					}
		
	
	
});}}
