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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class H1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h1);

    }

    public void back(View view) {
        Intent iinent= new Intent(H1.this,Home.class);
        startActivity(iinent);
    }

    public void psub(View view) {
        EditText c= findViewById(R.id.cp);
        EditText p= findViewById(R.id.pp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Solutions");
        myRef.child(c.getText().toString()).child(p.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
             //   Iterable<DataSnapshot> value = dataSnapshot.getChildren();
String a="";
                List<DataSnapshot> lastDataSnapshot = null;
                Iterable<DataSnapshot>  iterable= dataSnapshot.getChildren();
                for (DataSnapshot snapshot : iterable) {
                    lastDataSnapshot= Collections.singletonList(snapshot);
                    a= String.format("%s %s", a, lastDataSnapshot);
                    Log.d("FBread", "Value is: in loop " + lastDataSnapshot);

                }

                Log.d("FBread", "Value is: " + lastDataSnapshot);
                  TextView ans= (TextView)findViewById(R.id.h1ans);
                  String v2= a;
                          String v3=v2.replace("[","").replace("]","").replace(">","\n").replace("key =","\n").replace("DataSnapshot { ","").replace("}","").replace(", value =","");
                  ans.setText(v3);




            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FBread", "Failed to read value.", error.toException());

                TextView ans= (TextView)findViewById(R.id.h1ans);

                ans.setText("আমি এমন কিছুর উত্তর খুঁজে পাই নি। ");

            }
        });



    }
}