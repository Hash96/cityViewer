package com.example.city;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class FavDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "cityDB";
    private static String Table_NAME = "CityTable";
    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemTitle";
    public static String ITEM_IMAGE = "itemImage";
    public static String CITY_STATUS = "status";

    private static String CREATE_TABLE = "CREATE TABLE " + Table_NAME + "("
            + KEY_ID + " TEXT," + ITEM_TITLE+ " TEXT,"
            + ITEM_IMAGE + " TEXT," + CITY_STATUS+" TEXT)";

    public FavDB(Context context) {super(context,DATABASE_NAME, null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        for(int x = 1; x<5; x++){
            cv.put(KEY_ID, x);
            cv.put(CITY_STATUS, "0");

            db.insert(Table_NAME, null, cv);
        }
    }
    //insert data into database
    public void insertIntoTheDatabase(String item_title, int item_image, String id, String city_status){
        SQLiteDatabase db;
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE, item_title);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(KEY_ID, id);
        cv.put(CITY_STATUS, city_status);
        db.insert(Table_NAME, null, cv);
        Log.d("FavDB Status", item_title +", citystatus -"+city_status+" -. " + cv);
    }
    public Cursor read_all_data(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from" + Table_NAME + "where" + KEY_ID+"="+id+"";
        return db.rawQuery(sql, null, null);
    }

}
