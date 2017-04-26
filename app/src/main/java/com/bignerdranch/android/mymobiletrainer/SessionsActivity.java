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

public class SessionsActivity extends AppCompatActivity {
    private Button mViewSessions;
    private Button mEditSessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);
        mViewSessions = (Button) findViewById(R.id.view_sessions);
        mViewSessions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(SessionsActivity.this, BillingActivity.class);
                startActivity(intent);
            }
        });
        mEditSessions = (Button) findViewById(R.id.edit_sessions);
        mEditSessions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(SessionsActivity.this, BillingActivity.class);
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
            Toast.makeText(SessionsActivity.this, "Logging You Off", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SessionsActivity.this, LoginActivity.class);
            startActivity(intent);

        }


        return true;
    }

    }

