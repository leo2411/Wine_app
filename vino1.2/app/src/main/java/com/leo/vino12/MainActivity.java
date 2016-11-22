package com.leo.vino12;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    CardView crvenoVinoButton, bijeloVinoButton;
    TextView n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        crvenoVinoButton = (CardView) findViewById(R.id.cardView);
        bijeloVinoButton = (CardView) findViewById(R.id.cardView1);

        n = (TextView) findViewById(R.id.Vinaletitle);
        Typeface customfont = Typeface.createFromAsset(getAssets(), "fonts/font2.otf");
        n.setTypeface(customfont);

    }

    //on click metoda
    public void CrvenoVino(View view) {
        Intent i = new Intent(this, RedWine.class);
        startActivity(i);
    }

    // on click metoda
    public void BijeloVino(View view) {
        Intent i = new Intent(this, BijeloVino.class);
        startActivity(i);
    }


}
