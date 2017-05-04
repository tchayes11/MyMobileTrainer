package com.bignerdranch.android.mymobiletrainer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by TinaCH on 5/2/2017.
 */

public class CustomerLab {
    private static CustomerLab sCustomerLab;


    private int DATABASE_VERSION;
    private SQLiteDatabase myHelper;
    private Context mContext;

    public static CustomerLab get(Context context){
        if(sCustomerLab ==null){
            sCustomerLab= new CustomerLab(context);
        }
    return sCustomerLab;
    }
    private CustomerLab(Context context){
        this.mContext = context;
       // myHelper = new MyFitnessDatabase(mContext);
        myHelper = new MyFitnessDatabase.FitnessDBOpenHelper(mContext, null, null, DATABASE_VERSION).getWritableDatabase();

    }

        };



