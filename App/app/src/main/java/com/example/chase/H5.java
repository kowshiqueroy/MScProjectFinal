package com.example.chase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class H5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);


        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Problems");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("FBread", "Value is: " + value);
                String v2=value.replace(">","\n");
                TextView ans= (TextView)findViewById(R.id.h5ans);
                ans.setText(v2);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FBread", "Failed to read value.", error.toException());
            }
        });








    }

    public void back(View view) {


        Intent iinent= new Intent(H5.this,Home.class);
        startActivity(iinent);
    }
}