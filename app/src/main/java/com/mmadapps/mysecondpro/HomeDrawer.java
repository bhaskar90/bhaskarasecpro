package com.mmadapps.mysecondpro;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class HomeDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    // navigation drawaer variables
    protected DrawerLayout drawer;
    android.support.v4.app.ActionBarDrawerToggle mDrawerToggle;
    CoordinatorLayout coordinatorLayout;
    LinearLayout backlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        initializeViews();
    }

    private void initializeViews() {
        ActionBar bar=getSupportActionBar();
        bar.hide();

        // navigation drawaer implementation -----------------------------------------------------------------

        drawer = (DrawerLayout) findViewById(R.id.rootlayout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.rootlayouts);
        backlayout = (LinearLayout) findViewById(R.id.backlayout);
        backlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        mDrawerToggle = new android.support.v4.app.ActionBarDrawerToggle(this, drawer,
                R.drawable.drawer_icon, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                setTitle("closed");
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                setTitle("opened");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                drawer.getChildAt(0).setTranslationX(slideOffset * drawerView.getWidth());
                coordinatorLayout.setTranslationX(slideOffset * drawerView.getWidth());
                drawer.bringChildToFront(drawerView);
                drawer.requestLayout();
            }

        };

        drawer.setScrimColor(getResources().getColor(android.R.color.transparent));
        drawer.setDrawerListener(mDrawerToggle);

        //----------------------------------------------------------------------------------------------------------------











    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
