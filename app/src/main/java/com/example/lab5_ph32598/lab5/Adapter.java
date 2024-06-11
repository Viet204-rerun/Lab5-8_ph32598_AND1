package com.example.lab5_ph32598.lab5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5_ph32598.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<app> list;

    public Adapter(Context context, ArrayList<app> list) {
        this.context = context;
        this.list = list;
    }
    //lay ve tong so item
    @Override
    public int getCount() {
        return list.size();
    }
    //lay ve du lieu cua 1 item
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //lay ve id cua 1 item
    @Override
    public long getItemId(int position) {
        return position;
    }
    //taoview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //b1-Ve layout va anh xa layout
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();//sinh layout
        convertView=inflater.inflate(R.layout.item_view,parent,false);//anh xa layout
        //b2- anh xa thanh phan cua layout
        ImageView imglogo = convertView.findViewById(R.id.fb);
        TextView textview = convertView.findViewById(R.id.tv2);
        imglogo.setImageResource(list.get(position).getImg());
        textview.setText(list.get(position).getText());
        return convertView;
    }
}
