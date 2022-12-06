package com.example.saidcn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Hooks
    TextView tvResult;
    Button btnSubmit, btnCancel;
    EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clickled", Toast.LENGTH_SHORT).show();
                String id = etId.getText().toString();

                if(id.length()!=13)
                {
                    Toast.makeText(MainActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String dob = id.substring(0,6);
                    int gen = Integer.parseInt(id.substring(6,10));
                    char citizenFlag = id.charAt(10);
                    char validityFlag = id.charAt(12);

                    String year = "19"+dob.substring(0,2);
                    String months[] = {"January", "February" , "M","A","May","J","July","Aug","Sept","Oct","Nov","Dec"};

                    String month = months[Integer.parseInt(dob.substring(2,4))];
                    String day = dob.substring(4,6);

                    String gender = "";
                    String citizenship = "";
                    String validity = "";

                    if(gen>0 && gen<5000)
                    {
                        gender = "Female";
                    }
                    else
                    {
                        gender = "Male";
                    }

                    if(citizenFlag == '0')
                    {
                        citizenship="SA Citizen";
                    }
                    else if(citizenFlag == '1')
                    {
                        citizenship = "Permanent Resident";
                    }

                    if(validityFlag == '0')
                    {
                        validity = "Invalid Card";
                    }
                    else
                    {
                        validity = "Valid Card";
                    }

                    tvResult.setText("Date of Birth : "+day+"-"+month+"-"+year+
                                     "\nGender      : "+gender+
                                     "\nCitizenship : "+citizenship+
                                     "\nValidity    : "+validity);

                    tvResult.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    public void init()
    {
        tvResult = findViewById(R.id.tvResult);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
        etId = findViewById(R.id.etId);

    }
}