package com.example.chase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class Login extends AppCompatActivity {
    public static String names="";
    public static String identitys="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ToggleButton toggle = (ToggleButton) findViewById(R.id.type);
        EditText identity=(EditText) findViewById(R.id.identity);
        EditText phone=(EditText) findViewById(R.id.phone);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    toggle.setText("বিশেষজ্ঞ");

                    identity.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);


                } else {
                    // The toggle is disabled
                    toggle.setText("চাষী");
                    identity.setVisibility(View.GONE);
                    phone.setVisibility(View.GONE);
                }
            }
        });

    }

    public void login(View view) {

        EditText nameget=findViewById(R.id.name);
        ToggleButton identityget=findViewById(R.id.type);
        names=nameget.getText().toString();
        identitys=identityget.getText().toString();


        Intent iinent= new Intent(Login.this,Home.class);
        startActivity(iinent);
    }
}