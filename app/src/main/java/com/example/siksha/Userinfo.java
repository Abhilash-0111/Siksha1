package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userinfo extends AppCompatActivity {
TextView name, fname, address, dob, admndt, mobile,gender,lasti ;
    private FirebaseAuth mAuth;
    private String uid;
    private StudInfo s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        name = findViewById(R.id.name);
        fname = findViewById(R.id.namef);
        gender = findViewById(R.id.gender);
        lasti = findViewById(R.id.lastinstitute);
        admndt = findViewById(R.id.admndt);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        mobile = findViewById(R.id.mobile);
      /*  Bundle bundle = getIntent().getExtras();
        String a1 = bundle.getString("name");
        String a2 = bundle.getString("fname");
        String a3 = bundle.getString("gender");
        String a4 = bundle.getString("dob");
        String a5 = bundle.getString("mobile");
        String a6 = bundle.getString("admitdate");*/


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        uid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mData1 = database.getReference("studinfo").child(MainActivity.s1.mobile);
        mData1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                s1 = dataSnapshot.getValue(StudInfo.class);
                try{
                name.setText(s1.name);
                fname.setText(s1.fname);
                gender.setText(s1.gender);
               //  lasti.setText(s1.getLastintitute());
                admndt.setText(s1.admisiondate);
                dob.setText(s1.dob);
             //   address.setText(s1.getAddress());
                mobile.setText(s1.mobile);}
                catch (NullPointerException e){
                    Toast.makeText(Userinfo.this, "  exceptiion : "+e.toString()+s1.toString(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Can not show detail", Toast.LENGTH_SHORT).show();
            }

        });





   /*     try {

}
catch (NullPointerException e){
    Toast.makeText(Userinfo.this, "  exceptiion : "+e.toString(), Toast.LENGTH_LONG).show();

}*/

    }
}
