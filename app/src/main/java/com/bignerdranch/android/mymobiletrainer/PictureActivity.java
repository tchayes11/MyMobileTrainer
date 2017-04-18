package com.bignerdranch.android.mymobiletrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PictureActivity extends AppCompatActivity {
    private Button mViewCustomerPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        /*mViewCustomerPic = (Button) findViewById(R.id.view_customer_pic);
        mViewCustomerPic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(PictureActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/

    }
}
