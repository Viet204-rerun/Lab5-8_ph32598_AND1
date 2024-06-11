package com.example.lab5_ph32598.lab5;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.example.lab5_ph32598.R;
import com.example.lab5_ph32598.dangnhap.dangnhap;
import com.example.lab5_ph32598.lab8.ReadWriteStudent;

import java.util.ArrayList;

public class bai2 extends AppCompatActivity {
    Button btn1 , btn2;
    ListView listview;
    Toolbar toolbar;
    adapter2 adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        btn1 = findViewById(R.id.btn2);
        btn2 = findViewById(R.id.btn3);
        listview = findViewById(R.id.listview);
        Context context=this;
        ArrayList<dssv> list = new ArrayList<>();
        ReadWriteStudent readWriteStudent = new ReadWriteStudent(context);
        list = readWriteStudent.readALlStudent(context,"student.txt");
//        list.add(new dssv("Fpoly Hà Nội","Họ tên: Nguyễn Văn B","Địa chỉ: Lào Cai"));
//        list.add(new dssv("Fpoly Đà Nẵng","Họ tên: Nguyễn Văn C","Địa chỉ: Đà Nẵng"));
//        list.add(new dssv("Fpoly Tây Nguyên","Họ tên: Nguyễn Văn D","Địa chỉ: Tây Nguyên"));
//        list.add(new dssv("Fpoly Cần Thơ","Họ tên: Nguyễn Văn E","Địa chỉ: Cần Thơ"));

        ArrayList<dssv> finalList = list;
        ArrayList<dssv> finalList1 = list;
        adapter = new adapter2(this, list, new deleteItem() {
            @Override
            public void onClickForDelete(int pos) {
                ReadWriteStudent readWriteStudent1 = new ReadWriteStudent(context);
                readWriteStudent1.deleteOneStudent(context, finalList1,pos,"student.txt");

            }
        }, new updateItem() {
            @Override
            public void onClickForUpdate(int pos, String thanhPho, String hoTen, String diaChi) {
                ReadWriteStudent readWriteStudent1 = new ReadWriteStudent(context);
                readWriteStudent1.updateStudentAtPosition(context, finalList,pos,new dssv(thanhPho,hoTen,diaChi),"student.txt");
            }
        });
        listview.setAdapter(adapter);
        ArrayList<dssv> finalList2 = list;
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                finalList2.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        ArrayList<dssv> finalList3 = list;
        ActivityResultLauncher<Intent> getData = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==2){
                            Intent intent = result.getData();
                            Bundle bundle = intent.getExtras();
                            String thanhpho = bundle.getString("thanhpho");
                            String hoten = bundle.getString("hoten");
                            String diachi = bundle.getString("diachi");
                            finalList3.add(new dssv(thanhpho,hoten,diachi));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
        );
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai2.this,bai1.class);
                getData.launch(intent);
            }
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem myAcctionMenuItem = menu.findItem(R.id.Search);
        searchView=(SearchView) myAcctionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter((newText));
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.DangXuat){
            Intent intent = new Intent(bai2.this, dangnhap.class);
            startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.LichHoc){

        }
        return super.onOptionsItemSelected(item);
    }
}