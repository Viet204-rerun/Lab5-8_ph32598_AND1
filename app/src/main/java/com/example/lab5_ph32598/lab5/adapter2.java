package com.example.lab5_ph32598.lab5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.lab5_ph32598.R;

import java.util.ArrayList;

public class adapter2 extends BaseAdapter
implements Filterable{

    private Context context;
    private ArrayList<dssv> list,listOld;
    deleteItem deleteItem;
    updateItem updateItem;


    public adapter2(Context context, ArrayList<dssv> list) {
        this.context = context;
        this.listOld=list;
        this.list = list;
    }
    public adapter2(Context context, ArrayList<dssv> list,deleteItem deleteItem,updateItem updateItem) {
        this.context = context;
        this.listOld=list;
        this.list = list;
        this.deleteItem = deleteItem;
        this.updateItem = updateItem;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item2,parent,false);
        TextView textView1 = convertView.findViewById(R.id.tv3danhsachsinhvien);
        TextView textView2 = convertView.findViewById(R.id.tv4hoten);
        TextView textView3 = convertView.findViewById(R.id.tv5diachi);
        Button btnupdate = convertView.findViewById(R.id.btn4update);
        Button btndelete = convertView.findViewById(R.id.btn5delete);
        textView1.setText(list.get(position).getThanhpho());
        textView2.setText(list.get(position).getHoten());
        textView3.setText(list.get(position).getDiachi());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater1=((Activity)context).getLayoutInflater();
                View view = inflater1.inflate(R.layout.diglog,null);
                builder.setView(view);
               final EditText txtTen = view.findViewById(R.id.edt8);
                final EditText txtDiaChi = view.findViewById(R.id.edt9);
                builder.setTitle("Cập nhật Form");
                builder.setPositiveButton("Cập Nhật", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ten = txtTen.getText().toString();
                        String diachi = txtDiaChi.getText().toString();
                        updateItem.onClickForUpdate(position,"Hà Nội",ten,diachi);
                    }
                });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    notifyDataSetChanged();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem.onClickForDelete(position);
            }
        });
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if(s.isEmpty()){
                    list = listOld;
                }else{
                    ArrayList<dssv> lists = new ArrayList<>();
                    for(dssv ds : listOld){
                        if(ds.getHoten().toLowerCase().contains((s.toLowerCase()))){
                            lists.add(ds);
                        }

                    }
                    list=lists;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=list;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                 list=(ArrayList<dssv>) results.values;
                 notifyDataSetChanged();
            }
        };
    }
}
