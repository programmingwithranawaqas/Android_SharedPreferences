package com.example.saidcn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.AlgorithmConstraints;

public class Home extends AppCompatActivity {

    TextView tvEmail, tvName, tvDob;

    Button btnGoback, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvDob = findViewById(R.id.tvDob);
        tvName = findViewById(R.id.tvUsername);

        tvEmail = findViewById(R.id.tvEmail);
        btnGoback = findViewById(R.id.btnGoBackToRegistration);
        btnLogout = findViewById(R.id.btnLogout);

        SharedPreferences sp = getSharedPreferences(Login.FILENAME,MODE_PRIVATE);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.apply();
                editor.commit();

                Intent i = new Intent(Home.this, Login.class);
                startActivity(i);
                finish();
            }
        });



        tvName.setText(sp.getString("username", ""));
        tvDob.setText(sp.getString("userdob", ""));
        tvEmail.setText(sp.getString("useremail", ""));


btnGoback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(Home.this, Registration.class);
        startActivity(i);
        finish();
    }
});


    }
}