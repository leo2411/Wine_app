package com.leo.vino12;


import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class detaljiBvina extends AppCompatActivity {

    String[] PopisBijela = {"Bogdanuša", "Cetinka", "Debit", "Graševina", "Grk", "Jarbola", "Žlahtina"};
    int[] SlikeBijela = {R.drawable.bijelo1, R.drawable.bijelo2, R.drawable.bijelo3, R.drawable.bijelo2,
            R.drawable.bijelo5, R.drawable.bijelo1, R.drawable.bijelo2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalji_bijela_vina);


        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 78);
        Log.d("pozicija", "" + position);


        TextView info = (TextView) findViewById(R.id.InfoBB);
        TextView sljub = (TextView) findViewById(R.id.SljubB);
        TextView svojstva = (TextView) findViewById(R.id.SvojstvaB);
        ImageView regija = (ImageView) findViewById(R.id.RegijaB);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(PopisBijela[position]);


        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageDrawable(getResources().getDrawable(SlikeBijela[position]));


        Resources res1 = getResources();
        TypedArray vinainfo = res1.obtainTypedArray(R.array.InfoB);
        info.setText(vinainfo.getResourceId(position, 100));
        vinainfo.recycle();

        Resources res2 = getResources();
        TypedArray vinasvojstva = res2.obtainTypedArray(R.array.SvojstvaB);
        svojstva.setText(vinainfo.getResourceId(position, 0));
        vinasvojstva.recycle();

        Resources res3 = getResources();
        TypedArray vinasljub = res3.obtainTypedArray(R.array.SljubB);
        sljub.setText(vinainfo.getResourceId(position, 0));
        vinasljub.recycle();

        Resources res4 = getResources();
        TypedArray vinaregija = res4.obtainTypedArray(R.array.RegijaB);
        regija.setImageResource(vinaregija.getResourceId(position, 100));
        vinaregija.recycle();


    }


}

