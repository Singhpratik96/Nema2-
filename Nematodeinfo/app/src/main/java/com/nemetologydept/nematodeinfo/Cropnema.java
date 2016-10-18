package com.nemetologydept.nematodeinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.nemetologydept.nematodeinfo.ScrollableTabs.TabFragmentsLandingPage;


public class Cropnema extends AppCompatActivity {
    ListView list;
    String[] web;
    int value;


    Integer[] imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropnema);
      //  Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    //        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            value = extras.getInt("key");
            Log.e("tag1",""+value);

        }
        else{
            Log.e("tag1","NO");
        }
        switch(value)
        {
            case 1:
                String[] webr = {
                        "M.Graminicola","Nema2","Nema3","Nema3","Nema4","Nema4"
                } ;
                Integer[] imageIdr = {
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                };

                web=webr;
                imageId=imageIdr;
                break;
            case 2:
                String[] webw = {
                        "W1","W2","W3","W4","W5"
                } ;
                Integer[] imageIdw = {
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                };

                web=webw;
                imageId=imageIdw;
                break;
            case 3:
                String[] webra = {
                        "B1","Nema2","Nema3","Nema3","Nema4","Nema4"
                } ;
                Integer[] imageIdra = {
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                };

                web=webra;
                imageId=imageIdra;

                break;
            case 4:
                String[] webb = {
                        "B2 ","Nema2","Nema3","Nema3","Nema4","Nema4"
                } ;
                Integer[] imageIdb = {
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                        R.drawable.rice,
                };

                web=webb;
                imageId=imageIdb;
                break;
            default:
                break;
        }




        //Getting actionbar for back button





       // setSupportActionBar(toolbar);



        custom_list adapter = new
                custom_list(Cropnema.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(Cropnema.this , TabFragmentsLandingPage.class);
                int pass[]={value,position+1};

               i.putExtra("key",pass);


                startActivity(i);

            }
        });

    }


    @Override
    public void onBackPressed() {


        Intent MainActivityIntent = new Intent(Cropnema.this, MainActivity.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m1, menu);//Menu Resource, Menu
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                Intent i= new Intent(this,settings.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



}