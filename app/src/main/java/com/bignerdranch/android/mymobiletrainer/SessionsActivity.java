package com.bignerdranch.android.mymobiletrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SessionsActivity extends AppCompatActivity {
    private Button mViewSessions;
    private Button mEditSessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);
        /*mViewSessions = (Button) findViewById(R.id.view_sessions);
        mViewSessions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(SessionsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mEditSessions = (Button) findViewById(R.id.edit_sessions);
        mEditSessions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(SessionsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/
    }

    }

