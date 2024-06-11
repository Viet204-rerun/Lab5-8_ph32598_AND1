package com.example.lab5_ph32598.lab8;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class writereadobject {
    Context context;

    public writereadobject(Context context) {
        this.context = context;
    }

    public void writeruser(Context context, String filename, user user){
        ArrayList<user> list = new ArrayList<>();
        try{
            FileOutputStream fos = context.openFileOutput(filename,context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            list.add(user);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<user> readuser(Context context,String filename){
        ArrayList<user> list = new ArrayList<>();
        try {
            FileInputStream fis = context.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<user>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
