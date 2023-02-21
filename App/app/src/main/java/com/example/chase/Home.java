package com.example.chase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void solutionsubmit(View view) {
        Intent iinent= new Intent(Home.this,H3.class);
        startActivity(iinent);


    }

    @SuppressLint("ResourceAsColor")
    public void problemsubmit(View view) {
        Intent iinent= new Intent(Home.this,H2.class);
        startActivity(iinent);
       /* Button h1=findViewById(R.id.solutionneed);
        Button h2=findViewById(R.id.problemsubmit);
        Button h3=findViewById(R.id.solutionsubmit);
        Button h4=findViewById(R.id.expertnames);

        h2.setBackgroundColor(R.color.teal_200);
        h1.setBackgroundColor(R.color.white);
        h4.setBackgroundColor(R.color.white);
        h3.setBackgroundColor(R.color.white);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Problems");

        myRef.setValue("Hello, World!");*/
    }

    @SuppressLint("ResourceAsColor")
    public void ExpertsNum(View view) {

        Intent iinent= new Intent(Home.this,H4.class);
        startActivity(iinent);





    }

    public void logout(View view) {
        Intent iinent= new Intent(Home.this,Login.class);
        startActivity(iinent);
    }

    public void solutionneed(View view) {
        Intent iinent= new Intent(Home.this,H1.class);
        startActivity(iinent);
    }

    public void problemview(View view) {
        //H5
        Intent iinent= new Intent(Home.this,H5.class);
        startActivity(iinent);

    }
}