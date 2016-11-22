package com.leo.vino12;


import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RedWine extends AppCompatActivity {


    String[] CrvenaVina = {"Crljenak", "Dobričić", "Frankovka", "Hrvatica", "Merlot", "Plavac mali", "Teran"};
    int[] slikeCrvena = {R.drawable.crljenak, R.drawable.dobricic, R.drawable.frankovka, R.drawable.hrvatica,
            R.drawable.merlot, R.drawable.plavac, R.drawable.teran};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_wine);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter leoAdapter = new customadapter(this, CrvenaVina, slikeCrvena);

        ListView RedWineListView = (ListView) findViewById(R.id.RedWineListView);
        RedWineListView.setAdapter(leoAdapter);


        RedWineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(RedWine.this, detaljicvina.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
