package com.nemetologydept.nematodeinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.nemetologydept.nematodeinfo.ScrollableTabs.TabFragmentsLandingPage;


public class Cropnema extends AppCompatActivity {
    ListView list;
    String[] web;
    String value;

    Integer[] imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

        }
        switch(value)
        {
            case "rice":
                String[] webr = {
                        "M.Graminicola ","Nema2","Nema3","Nema3","Nema4","Nema4"
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
            case "wheat":
                String[] webw = {
                        "W1 ","W2","W3","W4","W5"
                } ;
                Integer[] imageIdw = {
                        R.drawable.wheat,
                        R.drawable.wheat,
                        R.drawable.wheat,
                        R.drawable.wheat,
                        R.drawable.wheat,
                };

                web=webw;
                imageId=imageIdw;
                break;
            case "raagi":
                String[] webra = {
                        "M.Graminicola ","Nema2","Nema3","Nema3","Nema4","Nema4"
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
            case "bajra":
                String[] webb = {
                        "M.Graminicola ","Nema2","Nema3","Nema3","Nema4","Nema4"
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
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        custom_list adapter = new
                custom_list(Cropnema.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(Cropnema.this , TabFragmentsLandingPage.class);
                i.putExtra("key",value);
                i.putExtra("nema",position);
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
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

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