
package com.example.lab5_ph32598.dangnhap;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab5_ph32598.R;
import com.example.lab5_ph32598.lab5.bai1;
import com.example.lab5_ph32598.lab5.bai2;
import com.example.lab5_ph32598.lab8.user;
import com.example.lab5_ph32598.lab8.writereadobject;

import java.util.ArrayList;

public class dangnhap extends ComponentActivity {
    EditText edt1, edt2;
    Button btn1, btn2;
    Intent intent;
    String u = "", p = "";
    CheckBox chk;

    private Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        edt1=findViewById(R.id.edt3);
        edt2=findViewById(R.id.edt4);
        btn1 = findViewById(R.id.btn6);
        btn2=findViewById(R.id.btn7);
        chk = findViewById(R.id.chkremember);
        intent = getIntent();
        checkRemember();
        if(intent!=null){
            Bundle bundle =intent.getExtras();
            if(bundle!=null){
                u=bundle.getString("u");
                p=bundle.getString("p");
            }
        }


        btn2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(dangnhap.this,dangnhap2.class);
                startActivity(intent1);
            }
        }));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<user> list = new ArrayList<>();
                writereadobject writereadobject = new writereadobject(context);
                list = writereadobject.readuser(context,"lab8.txt");
                Boolean isU = list.get(0).getTk().equals(edt1.getText().toString());
                Boolean isP = list.get(0).getMk().equals(edt2.getText().toString());
                if(edt1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Chưa nhập username!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(edt2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Chưa nhập password!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(isU&&isP&&list.get(0).getTk()!=""&&list.get(0).getMk()!=""){
                    remember(list.get(0).getTk(),list.get(0).getMk(),true);
                    Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(dangnhap.this, bai2.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Đăng Nhập Không Thành Công",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }  //ham luu du lieu vào share khi đăng nhap thanh cong
    public void remember(String tk, String mk,boolean chkRemember){
        SharedPreferences sharedPreferences = getSharedPreferences("lab8.txt",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",tk);
        editor.putString("pass",mk);
        editor.putBoolean("checkbook",chkRemember);
        editor.apply();
    }
    //ham kiem tra checkbook ( goi khi khoi dong activity tức là chua chon checkbook)
    public void checkRemember(){
        SharedPreferences sharedPreferences = getSharedPreferences("lab8.txt",MODE_PRIVATE);
        String tk = sharedPreferences.getString("user","");
        String mk = sharedPreferences.getString("pass","");
        Boolean isChkRemember = sharedPreferences.getBoolean("checkbook",false);
        chk.setChecked(isChkRemember);
        if(chk.isChecked()){
            edt1.setText(tk);
            edt2.setText(mk);
        }
    }
}