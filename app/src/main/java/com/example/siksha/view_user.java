package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class view_user extends AppCompatActivity {


    StudInfo obj1 ;
    EditText et1 ;
    TextView t1,t2 ;
    Button b1 ;
    DatabaseReference ref1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);


        et1 = (EditText)findViewById(R.id.id1);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        b1 = (Button)findViewById(R.id.button1);





        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String s1 = et1.getText().toString() ;
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("studinfo").child(s1);

                myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   obj1 = dataSnapshot.getValue(StudInfo.class);
                    t1.setText(obj1.getinfo());
             //  String s12 = dataSnapshot.getValue(String.class) ;
              // t1.setText(s12);
                         t2.setText(obj1.getName()+"abcdefgh");

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Can not show detail",Toast.LENGTH_SHORT ).show();
                }

            }) ;



            }});


    }






}
