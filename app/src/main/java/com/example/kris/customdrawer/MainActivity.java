package com.example.kris.customdrawer;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerRelativeLayout;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    CustomDrawerAdapter adapter;

    List<DrawerItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing
        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
        mDrawerList = (ListView) findViewById(R.id.list_view_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);

        // Add Drawer Item to dataList
        dataList.add(new DrawerItem("About me")); // adding a header to the list
        dataList.add(new DrawerItem("Main information", R.drawable.ic_action_search));
        dataList.add(new DrawerItem("AIESEC experience", R.drawable.ic_action_good));//find walking man!

        dataList.add(new DrawerItem("Professional Experience"));// adding a header to the list
        dataList.add(new DrawerItem("Emisia SA.", R.drawable.ic_action_email)); //logo
        dataList.add(new DrawerItem("AGH", R.drawable.ic_action_cloud)); //logo
        dataList.add(new DrawerItem("Comarch", R.drawable.ic_action_camera)); //logo

        dataList.add(new DrawerItem("General questions"));// adding a header to the list
        dataList.add(new DrawerItem("Why?", R.drawable.ic_action_help));
        dataList.add(new DrawerItem("Availability", R.drawable.ic_action_group));
        dataList.add(new DrawerItem("My virtual teams", R.drawable.ic_action_import_export));

        dataList.add(new DrawerItem("Specific Questions")); // adding a header to the list
        dataList.add(new DrawerItem("My projects", R.drawable.ic_action_about));
        dataList.add(new DrawerItem("Frameworks experience", R.drawable.ic_action_settings));
        dataList.add(new DrawerItem("Languages", R.drawable.ic_action_video));
        dataList.add(new DrawerItem("Apps ideas", R.drawable.ic_action_labels));

        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#037ef3"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {

            if (dataList.get(0).getTitle() != null) {
                SelectItem(1);
            } else {
                SelectItem(0);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void SelectItem(int position) {

        Fragment fragment = new MainInfoFragment();
        Bundle args = new Bundle();
        switch (position) {

            case 1:
                fragment = new MainInfoFragment();
                args.putString(MainInfoFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(MainInfoFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 2:
                fragment = new AiesecExperienceFragment();
                args.putString(AiesecExperienceFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(AiesecExperienceFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 4:
                fragment = new EmisiaFragment();
                args.putString(EmisiaFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(EmisiaFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 5:
                fragment = new AghFragment();
                args.putString(AghFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(AghFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 6:
                fragment = new ComarchFragment();
                args.putString(ComarchFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(ComarchFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 8:
                fragment = new WhyFragment();
                args.putString(WhyFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(WhyFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 9:
                fragment = new AvailabilityFragment();
                args.putString(AvailabilityFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(AvailabilityFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 10:
                fragment = new VirtualTeamsFragment();
                args.putString(VirtualTeamsFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(VirtualTeamsFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;

            case 12:
                fragment = new ProjectsFragment();
                args.putString(ProjectsFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(ProjectsFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 13:
                fragment = new FrameworksFragment();
                args.putString(FrameworksFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(FrameworksFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 14:
                fragment = new LanguagesFragment();
                args.putString(LanguagesFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(LanguagesFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            case 15:
                fragment = new IdeasFragment();
                args.putString(IdeasFragment.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(IdeasFragment.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                break;
            default:
                break;
        }

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commit();

        mDrawerList.setItemChecked(position, true);
        setTitle(dataList.get(position).getItemName());
        mDrawerLayout.closeDrawer(mDrawerRelativeLayout);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return false;
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if (dataList.get(position).getTitle() == null) {
                SelectItem(position);
            }

        }
    }


    public void launchGitHub(View v) {
        LaunchBrowserDialogFragment dialog = new LaunchBrowserDialogFragment();
        dialog.show(getFragmentManager(), "DIALOG");
    }

    public void startSplashScreen(View v) {
        Intent mainIntent = new Intent(MainActivity.this,SplashscreenActivity.class);
        startActivity(mainIntent);

    }
}