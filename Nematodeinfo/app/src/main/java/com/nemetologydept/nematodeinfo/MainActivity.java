package com.nemetologydept.nematodeinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {
    GridView grid;
    String[] web = {
            "RICE","WHEAT","RAAGI","BAJRA"

    } ;
    int[] imageId = {
            R.drawable.rice,
            R.drawable.wheat,
            R.drawable.raagi,
            R.drawable.bajra


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.gridview);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                    Intent i= new Intent(MainActivity.this,Cropnema.class);
                switch(position)
                {
                    case 1:
                       i.putExtra("key","rice");
                        break;
                    case 2:
                        i.putExtra("key","wheat");
                        break;
                    case 3:
                        i.putExtra("key","raagi");
                        break;
                    case 4:
                        i.putExtra("key","baajra");
                        break;


                }
                    startActivity(i);



            }
        });

    }

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