package com.nemetologydept.nematodeinfo;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import com.nemetologydept.nematodeinfo.ScrollableTabs.TabFragmentsLandingPage;


public class Rice extends AppCompatActivity {
    ListView list;
    String[] web = {
            "M.Graminicola ","Nema2","Nema3","Nema3","Nema4","Nema4"
    } ;
    Integer[] imageId = {
            R.drawable.rice,
            R.drawable.rice,
            R.drawable.rice,
            R.drawable.rice,
            R.drawable.rice,
            R.drawable.rice,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);


       //Getting actionbar for back button
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        custom_list adapter = new
                custom_list(Rice.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Rice.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Rice.this , TabFragmentsLandingPage.class);
                startActivity(i);

            }
        });

    }


    @Override
    public void onBackPressed() {


            Intent MainActivityIntent = new Intent(Rice.this, MainActivity.class);
            startActivity(MainActivityIntent);
            super.onBackPressed();

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