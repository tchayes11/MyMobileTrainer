package com.bignerdranch.android.mymobiletrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class ListCustomers extends AppCompatActivity {

    private Button mViewCustomers;
    private Button mAddNewCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);

        mViewCustomers = (Button) findViewById(R.id.view_customer);
        mViewCustomers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ListCustomers.this, BillingActivity.class);
                startActivity(intent);
            }
        });

        mAddNewCustomer = (Button) findViewById(R.id.addNewCustomer);
        mAddNewCustomer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListCustomers.this, BillingActivity.class);
                startActivity(intent);
            }
        });
        //Intent intent= getIntent();
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