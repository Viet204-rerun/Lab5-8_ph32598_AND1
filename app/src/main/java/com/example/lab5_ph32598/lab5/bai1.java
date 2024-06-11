package com.example.lab5_ph32598.lab5;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.textservice.SentenceSuggestionsInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lab5_ph32598.R;
import com.example.lab5_ph32598.lab8.ReadWriteStudent;

import java.util.ArrayList;

public class bai1 extends AppCompatActivity {

    TextView tv1;
    Spinner spn;
    EditText edt1,edt2;
    Button btn;
    String selectedItemSpinner="";
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        tv1 = findViewById(R.id.tv1);
        spn = findViewById(R.id.spn);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn = findViewById(R.id.btn1);
        ArrayList<app> list = new ArrayList<>();
        list.add(new app(R.drawable.facebook,"FaceBook"));
        list.add(new app(R.drawable.android,"Android"));
        list.add(new app(R.drawable.ioslogo,"Ios"));
        list.add(new app(R.drawable.instagram,"Instagram"));
        Adapter adapter = new Adapter(this,list);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemSpinner=((app)spn.getItemAtPosition(position)).getText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadWriteStudent readWriteStudent = new ReadWriteStudent(context);
                readWriteStudent.writeStudent(context,"student.txt",
                        new dssv(selectedItemSpinner,"Họ Tên:"+edt1.getText().toString(),"Địa Chỉ"+edt2.getText().toString()));
                Intent intent = new Intent(bai1.this,bai2.class);
                Bundle bundle = new Bundle();
                bundle.putString("thanhpho",selectedItemSpinner);
                bundle.putString("hoten","Họ Tên:"+edt2.getText().toString());
                bundle.putString("diachi","Địa Chỉ"+edt1.getText().toString());
                intent.putExtras(bundle);
                setResult(2,intent);
                 finish();
    }
        });
    }}