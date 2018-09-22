package com.ibrickedlabs.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    //ActionBarToggle for the Hamburger icon on the top left for that we need this ActionBarToggle
    ActionBarDrawerToggle mActionBarDrawerToggle;
    private TextView mTextView;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        mNavigationView = (NavigationView) findViewById(R.id.navigatioView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        mTextView.setText("Item 1 selected");
                        getSupportActionBar().setTitle("Item 1");
                        break;
                    case R.id.item2:
                        mTextView.setText("Item 2 selected");
                        getSupportActionBar().setTitle("Item 2");
                        break;
                    case R.id.item3:
                        mTextView.setText("Item 3 selected");
                        getSupportActionBar().setTitle("Item 3");
                        break;
                }
                //close the drawer
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        /**
         * here we mention string as 3rd and 4th arguements becz of accessibilty purpose
         */
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        /**
         * ActionBarToggle.syncState render the hamburger on the screen
         */
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * Becasue we want the hamburger to work so we dont have any method available to integrate it so we use menu item to use instead
         *
         * So here we are trying to handle it through ActionBar
         */
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
