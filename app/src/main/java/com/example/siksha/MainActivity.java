package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    CardView hw , info, exam , fees  ;
    private FirebaseAuth mAuth ;
    DatabaseReference dbref ;
    static StudInfo s1 ;
    static String mobilenum ;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    static String  uid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hw =(CardView)findViewById(R.id.homework) ;
        info =(CardView)findViewById(R.id.ainfo) ;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        Bundle bundle = getIntent().getExtras();
        String s2 = bundle.getString("mobilenum");

        uid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

       DatabaseReference mData1 = database.getReference("studinfo").child(uid);
       if(s2!=null) {
            mData1 = database.getReference("studinfo").child(s2);
       }

        mData1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                s1 = dataSnapshot.getValue(StudInfo.class);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Can not show detail", Toast.LENGTH_SHORT).show();
            }

        });



        hw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openhw() ;
            }
        } );

        info.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openinfo() ;
            }
        } );



    }


    public void openhw(){
        Intent intent1 = new Intent(this, GetHw.class);

        startActivity(intent1);
    }

    public void openinfo(){

        Intent intent1 = new Intent(this, Userinfo.class);
       /* intent1.putExtra("name", s1.name);
        intent1.putExtra("fname", s1.fname);
        intent1.putExtra("admitdate", s1.admisiondate);
        intent1.putExtra("mobile", s1.mobile);
        intent1.putExtra("address", s1.address);
        intent1.putExtra("dob", s1.dob);
        intent1.putExtra("gender", s1.gender);*/
        startActivity(intent1);
    }



}
