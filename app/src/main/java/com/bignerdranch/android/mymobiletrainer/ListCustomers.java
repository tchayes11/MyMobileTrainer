package com.bignerdranch.android.mymobiletrainer;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import static android.R.attr.value;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_EMAIL_ADDRESS_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_FIRST_NAME_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_FITNESS_LEVEL_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_LAST_NAME_COLUMN;

public class ListCustomers extends AppCompatActivity {

    private Button mViewCustomers;
    private Button mAddNewCustomer;
    private Button mSave;


    private EditText FirstName;
    private EditText LastName;
    private EditText EmailAddress;
    private EditText FitnessLevel;
    //private MyFitnessDatabase myfDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);

        final MyFitnessDatabase db = new MyFitnessDatabase(this);

        FirstName = (EditText) findViewById(R.id.customer_first_name);
        LastName = (EditText) findViewById(R.id.customer_last_name);
        EmailAddress = (EditText) findViewById(R.id.customer_emailAdd);
        FitnessLevel = (EditText) findViewById(R.id.customer_fit_level);


        mViewCustomers = (Button) findViewById(R.id.view_customer);
        mViewCustomers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                addNewCustomer("Mark ","Walberg","mw@hotmail.com","High");
                addNewCustomer("Adrian", "Washington", "therealdenzel@liar.com", "Low");
                Intent intent = new Intent(ListCustomers.this, CustomerLab.class);
                startActivity(intent);
            }
        });


        mAddNewCustomer = (Button) findViewById(R.id.addNewCustomer);
        mAddNewCustomer.setOnClickListener(new View.OnClickListener() {











            /*String firstName = String.valueOf(FirstName.getText().toString());
            String lastName= String.valueOf(LastName.getText().toString());
            String emailAdress = String.valueOf(EmailAddress.getText().toString());
            String fitLevel= String.valueOf(FitnessLevel.getText().toString());*/

            @Override
            public void onClick(View view) {




                Bundle args = new Bundle();
                args.putString(SampleFragment.KEY_TITLE, "Customer List");


                SampleFragment fragment = new SampleFragment();
                fragment.setArguments(args);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();


                Intent intent = new Intent(ListCustomers.this, SampleFragment.class);

                startActivity(intent);
            }
        });


    }


           /* mContext = context.getApplicationContext();
            myHelper = new MyFitnessDatabase.FitnessDBOpenHelper(mContext, null, null, DATABASE_VERSION).getWritableDatabase();
            myfDB = new MyFitnessDatabase(this);
*/




           public void addNewCustomer(String firstName, String lastName, String emailAdd, String fitLevel) {
                   ContentValues newValues = new ContentValues();

                //Assign values for each row.
                newValues.put(KEY_FIRST_NAME_COLUMN, firstName);
                newValues.put(KEY_LAST_NAME_COLUMN, lastName);
                newValues.put(KEY_EMAIL_ADDRESS_COLUMN, emailAdd);
                newValues.put(KEY_FITNESS_LEVEL_COLUMN, fitLevel);



            }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
       MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logoff_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.LogOff) {
            Toast.makeText(ListCustomers.this, "Logging You Off", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ListCustomers.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
        }
    }