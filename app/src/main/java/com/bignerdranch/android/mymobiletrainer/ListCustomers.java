package com.bignerdranch.android.mymobiletrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListCustomers extends AppCompatActivity {
    private Button mViewCustomers;
    private Button mAddNewCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);

       /* mViewCustomers = (Button) findViewById(R.id.view_customer);
        mViewCustomers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(ListCustomers.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mAddNewCustomer = (Button) findViewById(R.id.addNewCustomer);
        mAddNewCustomer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(ListCustomers.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/
    }

    }

