package com.example.chase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class H2 extends AppCompatActivity {
    public String v="";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Problems");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h2);

        // Read from the database

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("FBread", "Value is: " + value);
                //  TextView ans= (TextView)findViewById(R.id.h5ans);
                //  ans.setText(value);
                v=value;



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FBread", "Failed to read value.", error.toException());

            }
        });
    }

    public void back(View view) {
        Intent iinent= new Intent(H2.this,Home.class);
        startActivity(iinent);
    }

    public void prbsub(View view) {
        EditText p=findViewById(R.id.ps);
        myRef.setValue(v+">"+Login.identitys+" :"+Login.names+" "+p.getText().toString());

        Log.d("FBread", "Value is: " + v);




    }
}