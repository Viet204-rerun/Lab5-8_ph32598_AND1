package com.example.lab5_ph32598.lab8;

import android.content.Context;

import com.example.lab5_ph32598.lab5.bai1;
import com.example.lab5_ph32598.lab5.dssv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadWriteStudent {
    Context context;

    public ReadWriteStudent(Context context) {
        this.context = context;
    }
    public ArrayList<dssv> readALlStudent(Context context,String filename){
       ArrayList<dssv> list = new ArrayList<>();
       try {
           FileInputStream fileInputStream = context.openFileInput(filename);
           ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
           list = (ArrayList<dssv>) objectInputStream.readObject();
           objectInputStream.close();
           fileInputStream.close();

    } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }   return list;}

        public  void writeStudent(Context context,String filename,dssv dssv ){
        ArrayList<dssv> list = new ArrayList<>();
        try {
            FileOutputStream fos = context.openFileOutput(filename, context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            list.add(dssv);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public  void deleteOneStudent(Context context, ArrayList<dssv> list , int pos , String filename){
        list.remove(pos);
        try{
            FileOutputStream fos = context.openFileOutput(filename,context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void updateStudentAtPosition(Context context,ArrayList<dssv> list, int pos, dssv dssv,String filename){
        list.remove(pos);
        list.add(pos,dssv);
        try{
            FileOutputStream fos = context.openFileOutput(filename,context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
