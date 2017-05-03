package com.bignerdranch.android.mymobiletrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.KeyEvent;

import java.io.IOException;


public class LoginActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    int Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       /* TextView textUsername = (TextView)findViewById(R.id.textUsername);
        textUsername.getText();
        TextView textPassword= (TextView)findViewById(R.id.textPassword);
        textPassword.getText();*/



        Button mLogin = (Button) findViewById(R.id.login_button);
        mLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Username = (EditText) findViewById(R.id.editTextUsername);
                Password = (EditText) findViewById(R.id.editTextPassword);


                String username= String.valueOf(Username.getText().toString());
                String password= String.valueOf(Password.getText().toString());


                if (username.equals(getString(R.string.user_name)) && password.equals(getString(R.string.password))) {

                    Intent intent = new Intent(LoginActivity.this, BillingActivity.class);
                    startActivity(intent);
                } else {
                    Message = R.string.unsuccessful_login;
                    Toast.makeText(LoginActivity.this, Message, Toast.LENGTH_SHORT).show();
                }

            }
            /*
            public void sendButton(View view) {
                Intent intent = new Intent(LoginActivity.this, ListCustomers.class);
                startActivity(intent);
            }*/
        });



    }

}





