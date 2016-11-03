package com.rocks.android.animations.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.rocks.android.animations.R;
import com.rocks.android.animations.fragment.AnimaterSetFragment;
import com.rocks.android.animations.fragment.ObjectAnimatorFragment;
import com.rocks.android.animations.fragment.ValueAnimatorFragment;

public class SliderActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
RelativeLayout container;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
       // drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu=navigationView.getMenu();
       menu.add(R.id.grp,Menu.NONE,0,"2").setIcon(R.mipmap.ic_launcher);
        menu.add(R.id.grp,Menu.NONE,0,"3").setIcon(R.drawable.ic_menu_camera);
        container=(RelativeLayout)findViewById(R.id.container);
        manager=(FragmentManager)getSupportFragmentManager();

       /* int[][] states = new int[][] {
               new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_checked}  // pressed
        };

        int[] colors = new int[] {


                R.color.colorPrimary,
                R.color.colorAccent
        };

        ColorStateList list=new ColorStateList(states,colors);
        navigationView.setItemTextColor(list);*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    MenuItem mPreviousMenuItem;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        transaction=manager.beginTransaction();
        int id = menuItem.getItemId();

        if (id == R.id.nav_value) {
            transaction.replace(R.id.container, ValueAnimatorFragment.newInstance("",""));
            transaction.addToBackStack(null);
            transaction.commit();
            // Handle the camera action
        } else if (id == R.id.nav_obj) {
            transaction.replace(R.id.container, ObjectAnimatorFragment.newInstance("",""));
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.nav_set) {
            transaction.replace(R.id.container, AnimaterSetFragment.newInstance("",""));
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.nav_view) {

        } else if (id == R.id.nav_drawable) {

        }
        menuItem.setCheckable(true);
        menuItem.setChecked(true);
        if (mPreviousMenuItem != null&&mPreviousMenuItem!=menuItem) {
            mPreviousMenuItem.setChecked(false);
        }
        mPreviousMenuItem = menuItem;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
