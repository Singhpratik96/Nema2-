package com.nemetologydept.nematodeinfo.ScrollableTabs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


import com.nemetologydept.nematodeinfo.R;
import com.nemetologydept.nematodeinfo.settings;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class TabFragmentsLandingPage extends ActionBarActivity implements MaterialTabListener {

    private MaterialTabHost tabHost;
    private ViewPager pager;
    String value;
    int num;

    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.tab_layout);
        Bundle extras = getIntent().getExtras();

        value=extras.getString("key");
        num= extras.getInt("nema");





        //Getting actionbar for back button
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        tabHost = (MaterialTabHost) findViewById(R.id.materialTabHost);
        pager = (ViewPager) findViewById(R.id.viewPager);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                if(position<5)
                tabHost.setSelectedNavigationItem(position);
            }
        });

        // insert all tabs from pagerAdapter data

            tabHost.addTab(
                    tabHost.newTab()
                            .setText("Introduction")
                            .setTabListener(this)
            );

        tabHost.addTab(
                tabHost.newTab()
                        .setText("Spread")
                        .setTabListener(this)
        );
        tabHost.addTab(
                tabHost.newTab()
                        .setText("Symptoms")
                        .setTabListener(this)
        );
        tabHost.addTab(
                tabHost.newTab()
                        .setText("Protection and Control")
                        .setTabListener(this)
        );

        tabHost.addTab(
                tabHost.newTab()
                        .setText("Pictures")
                        .setTabListener(this)
        );



    }


    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int num) {


            if(num==0)
            return new Tab1();
            else if(num==1)
            return new Tab2();
            else if(num==2)
                return new Tab3();
            else if(num==3)
                return new Tab4();
            else
                return new Tab5();



        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "tab";
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case R.id.settings:
                Intent i= new Intent(this,settings.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



}
