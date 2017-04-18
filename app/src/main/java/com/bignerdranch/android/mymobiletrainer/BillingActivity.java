package com.bignerdranch.android.mymobiletrainer;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.id;

public class BillingActivity extends AppCompatActivity {
    private Button mCreditCard;
    private Button mPrinter;
    private Button mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

       /* FragmentManager fm = getFragmentManager();
        CustomerFragment customerFragment =
                (CustomerFragment)fm.findFragmentById(R.id.CustomerFragment);


        if(customerFragment==null){
            FragmentTransaction trans = fm.beginTransaction();
            ft.add(R.id.customer_fragment, new CustomerFragment());
            ft.commit();
*/

      /*  mCreditCard = (Button) findViewById(R.id.credit_card);
        mCreditCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mPrinter = (Button) findViewById(R.id.print_reciept);
        mPrinter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mEmail = (Button) findViewById(R.id.email_receipt);
        mEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/


    }}