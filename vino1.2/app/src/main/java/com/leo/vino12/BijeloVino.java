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


public class BijeloVino extends AppCompatActivity {

    String[] PopisBijela = {"Bogdanuša", "Cetinka", "Debit", "Graševina", "Grk", "Jarbola", "Žlahtina"};
    int[] SlikeBijela = {R.drawable.bogdanusa, R.drawable.cetinka, R.drawable.debit, R.drawable.grasevina,
            R.drawable.grk, R.drawable.jarabola, R.drawable.zlahtina};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bijela_vina);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter bijeloAdapter = new customadapter(this, PopisBijela, SlikeBijela);
        ListView BijelaVinaListView = (ListView) findViewById(R.id.BijelaVinaListView);
        BijelaVinaListView.setAdapter(bijeloAdapter);


        BijelaVinaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(BijeloVino.this, detaljiBvina.class);
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
