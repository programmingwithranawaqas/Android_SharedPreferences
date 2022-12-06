package com.example.saidcn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static final String FILENAME = "application";

    EditText etemail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etEmailLogin);
        etPassword = findViewById(R.id.etPasswordLogin);

        SharedPreferences sPre = getSharedPreferences(FILENAME, MODE_PRIVATE);
        boolean flag = sPre.getBoolean("flag", false);

        if(flag)
        {
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        }

    }

    public void login(View v)
    {

        String email =etemail.getText().toString();
        String password = etPassword.getText().toString();

        if(email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Email or password is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            SharedPreferences readingCredentials = getSharedPreferences(FILENAME, MODE_PRIVATE);


            String savedEmail = readingCredentials.getString("useremail", null);
            String savedPassword = readingCredentials.getString("userpassword", null);

            if(email.equals(savedEmail) && password.equals(savedPassword))
            {
                SharedPreferences sp = getSharedPreferences(FILENAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("flag", true);
                editor.apply();
                editor.commit();
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
                finish();

            }
            else
            {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void cancel(View v)
    {
        finish();
    }

    public void newUser(View v)
    {
        Intent intent = new Intent(Login.this, Registration.class);
        startActivity(intent);
        finish();
    }

}