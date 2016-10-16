package com.palle.annu.palletodogrocery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by annu on 14/10/16.
 */
public class MyDatabase {
    MyHelper myhelper;
    SQLiteDatabase s;

    public MyDatabase(Context c)
    {
        myhelper = new MyHelper(c,"techpalle.db",null,1);
    }

public class MyHelper extends SQLiteOpenHelper{

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table groceries(_id integer primary key, item text, quantity integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
    public void open(){
        s= myhelper.getWritableDatabase();

    }
    public void InsertItem(String itemName,Integer itemQuntity)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item",itemName);
        contentValues.put("quantity",itemQuntity);
        s.insert("groceries",null,contentValues);

    }
    public Cursor getItem()
    {
        Cursor c = null;
        c = s.query("groceries",null,null,null,null,null,null);
        return c;
    }
    public  void close()
    {
        s.close();
        
    }
}
