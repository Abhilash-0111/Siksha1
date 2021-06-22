package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class Adminlogin extends AppCompatActivity {
EditText e1 ;
Button b1 ;
String password, passworddb ;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
b1 = (Button) findViewById(R.id.btn_login) ;
e1 = (EditText)findViewById(R.id.password) ;


        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("password");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                passworddb = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Can not show detail",Toast.LENGTH_SHORT ).show();
            }

        }) ;


        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                password = e1.getText().toString() ;
                if(password.equals(passworddb))
                openadmin() ;
                else{
                    Toast.makeText(getApplicationContext(), "Oops! network error",Toast.LENGTH_SHORT ).show();
                }
            }
        } );


    }

    void openadmin(){

        Intent intent1 = new Intent(this, Admin_act.class);
        startActivity(intent1);

    }

}