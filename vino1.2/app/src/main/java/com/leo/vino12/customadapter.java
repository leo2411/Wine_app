package com.leo.vino12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class customadapter extends ArrayAdapter<String> {


    int[] images;
    String[] names;


    customadapter(Context context, String[] ime, int[] imgs) {
        super(context, R.layout.custom_row, R.id.imevina, ime);
        this.names = ime;
        this.images = imgs;
    }

    class MyViewHolder {

        TextView imevina;
        ImageView imageView;

        MyViewHolder(View v) {
            imevina = (TextView) v.findViewById(R.id.imevina);
            imageView = (ImageView) v.findViewById(R.id.slikeCrvena);
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        MyViewHolder holder = null;

        if (row == null) {
            LayoutInflater layInflater = LayoutInflater.from(getContext());
            row = layInflater.inflate(R.layout.custom_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }

        String itemListe = getItem(position);
        holder.imevina.setText(itemListe);
        holder.imageView.setImageResource(images[position]);

        return row;


    }
}
