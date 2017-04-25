package com.bignerdranch.android.mymobiletrainer;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        mCreditCard = (Button) findViewById(R.id.credit_card);
        mCreditCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, SessionsActivity.class);
                startActivity(intent);
            }
        });
        mPrinter = (Button) findViewById(R.id.print_reciept);
        mPrinter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, SessionsActivity.class);
                startActivity(intent);
            }
        });
        mEmail = (Button) findViewById(R.id.email_receipt);
        mEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(BillingActivity.this, SessionsActivity.class);
                startActivity(intent);
            }
        });

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
            Toast.makeText(BillingActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(BillingActivity.this, LoginActivity.class);
            startActivity(intent);

        }


        return true;
    }
}