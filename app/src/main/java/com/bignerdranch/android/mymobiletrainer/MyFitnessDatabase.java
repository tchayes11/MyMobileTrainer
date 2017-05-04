package com.bignerdranch.android.mymobiletrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by TinaCH on 4/26/2017.
 */

public class MyFitnessDatabase {

    public static final String KEY_ID = "id";

    //Name and column index of each column
    public static final String KEY_FIRST_NAME_COLUMN = "FIRST_NAME";
    public static final String KEY_LAST_NAME_COLUMN = "LAST_NAME";
    public static final String KEY_EMAIL_ADDRESS_COLUMN = "EMAIL_ADDRESS";
    public static final String KEY_FITNESS_LEVEL_COLUMN = "FITNESS_LEVEL";

    private FitnessDBOpenHelper fitnessDBOpenHelper;

    public MyFitnessDatabase(Context context) {
        fitnessDBOpenHelper = new FitnessDBOpenHelper(context, FitnessDBOpenHelper.DATABASE_NAME, null,
                FitnessDBOpenHelper.DATABASE_VERSION);

        addNewCustomer("Mark ","Walberg","mw@hotmail.com","High");
        addNewCustomer("Adrian", "Washington", "therealdenzel@liar.com", "Low");
//        SQLiteDatabase db = fitnessDBOpenHelper.getReadableDatabase();
    }

    public void closeDatabase() {

        fitnessDBOpenHelper.close();
    }

    private Cursor getAccessibleFitness() {

        String[] result_columns = new String[]{
                KEY_ID, KEY_FIRST_NAME_COLUMN, KEY_LAST_NAME_COLUMN, KEY_EMAIL_ADDRESS_COLUMN, KEY_FITNESS_LEVEL_COLUMN};

        String where = null;
        String whereArgs[] = null;
        String groupBy = null;
        String having = null;
        String order = null;


        SQLiteDatabase db = fitnessDBOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(FitnessDBOpenHelper.DATABASE_TABLE, result_columns, where, whereArgs, groupBy, having, order);

        return cursor;
    }

    public void addNewCustomer(String firstName, String lastName, String emailAdd, String fitLevel) {
        ContentValues newValues = new ContentValues();

        //Assign values for each row.
        newValues.put(KEY_FIRST_NAME_COLUMN, firstName);
        newValues.put(KEY_LAST_NAME_COLUMN, lastName);
        newValues.put(KEY_EMAIL_ADDRESS_COLUMN, emailAdd);
        newValues.put(KEY_FITNESS_LEVEL_COLUMN, fitLevel);

        SQLiteDatabase db = fitnessDBOpenHelper.getWritableDatabase();
        db.insert(FitnessDBOpenHelper.DATABASE_TABLE, null, newValues);
    }


    public static class FitnessDBOpenHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "fitnessDatabase.db";
        private static final String DATABASE_TABLE = "CustomerList";
        private static final int DATABASE_VERSION = 1;

        //SQL Statement to create a new database.
        private static final String DATABASE_CREATE = "create table" +
                DATABASE_TABLE + "(" + KEY_ID + "int primary key autoincrement, " +
                KEY_FIRST_NAME_COLUMN + "text not null," +
                KEY_LAST_NAME_COLUMN + "text not null," +
                KEY_EMAIL_ADDRESS_COLUMN + "text not null," +
                KEY_FITNESS_LEVEL_COLUMN + "text not null);";

    public FitnessDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }



        @Override
    public void onCreate(SQLiteDatabase db){
            db.execSQL(DATABASE_CREATE);

    }
    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w("TaskDBAdapter","Upgrading from version" +oldVersion +"to"+newVersion + ", which will destroy all old data");
    }
}




    }


