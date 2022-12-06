package com.example.saidcn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    // Hooks
    Button btnCancelReg, btnSubmitReg;
    EditText etName, etEmail, etPass, etCpass, etDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();

        btnCancelReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSubmitReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, pass, cpass, email, dob;
                name = etName.getText().toString();
                pass = etPass.getText().toString();
                cpass = etCpass.getText().toString();
                email = etEmail.getText().toString();
                dob = etDob.getText().toString();

                if(name.isEmpty() || pass.isEmpty() || cpass.isEmpty() || email.isEmpty() ||dob.isEmpty())
                {
                    Toast.makeText(Registration.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(cpass))
                    {
                        SharedPreferences sp = getSharedPreferences(Login.FILENAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("username", name);
                        editor.putString("userdob", dob);
                        editor.putString("userpassword", pass);
                        editor.putString("useremail", email);
                        editor.apply();
                        editor.commit();

                        Intent intent = new Intent(Registration.this, Login.class);
                        startActivity(intent);
                        finish(); // to shutdown prevous activity
                    }
                    else
                    {
                        Toast.makeText(Registration.this, "Password and confirm password mismatched", Toast.LENGTH_SHORT).show();
                    }



                }

            }
        });




    }

    public void init()
    {
        btnCancelReg = findViewById(R.id.btnCancelReg);
        btnSubmitReg = findViewById(R.id.btnSubmitReg);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPassword);
        etCpass = findViewById(R.id.etConPassword);
        etDob = findViewById(R.id.etDob);
    }
}