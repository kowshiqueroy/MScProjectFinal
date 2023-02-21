package com.example.chase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class H3 extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Solutions");
    String v="";
    int f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h3);




    }
    public void back(View view) {
        Intent iinent= new Intent(H3.this,Home.class);
        startActivity(iinent);
    }

    public void solsub(View view) throws InterruptedException {


        EditText c= findViewById(R.id.crop);
        EditText p= findViewById(R.id.prb);
        EditText s= findViewById(R.id.sol);

        myRef.child(c.getText().toString()).child(p.getText().toString()).child(s.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                 String v2 = dataSnapshot.getValue(String.class);
                Log.d("FBread", "Value is: fire " + v2);
                v=v2;
                f=1;
                //  TextView ans= (TextView)findViewById(R.id.h5ans);
                //  ans.setText(value);
               // v=value;
             //   myRef.child(c.getText().toString()).child(p.getText().toString()).child(s.getText().toString()).setValue(v+">"+Login.identitys+ " : "+Login.names);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FBread", "Failed to read value.", error.toException());
                myRef.child(c.getText().toString()).child(p.getText().toString()).child(s.getText().toString()).setValue(">"+Login.identitys+ " : "+Login.names);


            }
        });


     //   myRef.setValue("hi");
Thread.sleep(2000);
       String v3= v +">"+Login.identitys+ " : "+Login.names;
        Log.d("FBread", "Value is: v3 " + v3);
     myRef.child(c.getText().toString()).child(p.getText().toString()).child(s.getText().toString()).setValue(v3);



    }
}