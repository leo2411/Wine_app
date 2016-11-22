package com.leo.vino12;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class detaljicvina extends AppCompatActivity {

    String[] CrvenaVina = {"Crljenak", "Dobričić", "Frankovka", "Hrvatica", "Merlot", "Plavac mali", "Teran"};
    int[] slikeCrvena = {R.drawable.crveno1, R.drawable.crveno2, R.drawable.crveno3, R.drawable.crveno4,
            R.drawable.crveno5, R.drawable.crveno1, R.drawable.crveno5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaljivina);


        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 78);
        Log.d("pozicija", "" + position);

        TextView info = (TextView) findViewById(R.id.InfoC);
        TextView sljub = (TextView) findViewById(R.id.SljubC);
        TextView svojstva = (TextView) findViewById(R.id.SvojstvaC);
        ImageView regija = (ImageView) findViewById(R.id.RegijaC);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(CrvenaVina[position]);


        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageDrawable(getResources().getDrawable(slikeCrvena[position]));


        Resources res1 = getResources();
        TypedArray vinainfo = res1.obtainTypedArray(R.array.InfoC);
        info.setText(vinainfo.getResourceId(position, 100));
        vinainfo.recycle();

        Resources res2 = getResources();
        TypedArray vinasvojstva = res2.obtainTypedArray(R.array.SvojstvaC);
        svojstva.setText(vinainfo.getResourceId(position, 0));
        vinasvojstva.recycle();

        Resources res3 = getResources();
        TypedArray vinasljub = res3.obtainTypedArray(R.array.SljubC);
        sljub.setText(vinainfo.getResourceId(position, 0));
        vinasljub.recycle();

        Resources res4 = getResources();
        TypedArray vinaregija = res4.obtainTypedArray(R.array.RegijaC);
        regija.setImageResource(vinaregija.getResourceId(position, 100));
        vinaregija.recycle();

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

