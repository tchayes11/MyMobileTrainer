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

public class PictureActivity extends AppCompatActivity {
    private Button mViewCustomerPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        mViewCustomerPic = (Button) findViewById(R.id.view_customer_pic);
        mViewCustomerPic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(PictureActivity.this, LoginActivity.class);
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
            Toast.makeText(PictureActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PictureActivity.this, LoginActivity.class);
            startActivity(intent);

        }


        return true;
    }
}
