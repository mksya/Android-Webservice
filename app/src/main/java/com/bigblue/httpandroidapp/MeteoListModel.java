package com.bigblue.httpandroidapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeteoListModel extends ArrayAdapter<MeteoItem> {

    private List<MeteoItem> listItems;
    private int resource;
    public static Map<String,Integer> images=new HashMap<>();

    static{
        images.put("Sunny",R.drawable.sunny);
        images.put("Cloudy",R.drawable.cloudy);
        images.put("Rainy",R.drawable.rainy);
    }

    public MeteoListModel(@NonNull Context context, int resource,List<MeteoItem> data) {
        super(context, resource, data);
        Log.i("Size:", String.valueOf(data.size()));
        this.listItems = data;
        this.resource = resource;
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Log.i("MyLog","......."+position);
        View listItem=convertView;
        if (listItem==null)
            listItem= LayoutInflater.from(getContext()).inflate(resource,parent,false);
            ImageView imageView=listItem.findViewById(R.id.imageView);
            TextView textViewTempMax=listItem.findViewById((R.id.textViewMax));
            TextView textViewTempMin=listItem.findViewById((R.id.textViewMin));
            TextView textViewPression=listItem.findViewById(R.id.textViewPression);
            TextView textViewHumidite=listItem.findViewById((R.id.textViewHumidite));
            TextView textViewDate=listItem.findViewById((R.id.textViewDate));
            String key=listItem.get(position).image;
            if (key!=null)imageView.setImageResource(images.get(key));
            textViewTempMax.setText(String.valueOf(listItems.get(position).tempMax)+"°C");
            textViewTempMin.setText(String.valueOf(listItems.get(position).tempMin)+"°C");
            textViewPression.setText(String.valueOf(listItems.get(position).pression)+"hPa");
            textViewHumidite.setText(String.valueOf(listItems.get(position).humidite)+"%");
            textViewDate.setText(String.valueOf(listItems.get(position).date));
            return listItem;

    }

}
