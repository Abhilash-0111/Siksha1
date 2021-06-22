package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User_list extends AppCompatActivity {
    TextView t1 ;
    String s1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);


        t1  = (TextView)findViewById(R.id.text1) ;
        final List<StudInfo> namelist = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("studinfo");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namelist.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren() ) {

                    StudInfo studentinfo = postSnapshot.getValue(StudInfo.class);
                    namelist.add(studentinfo);
                     s1 = s1+studentinfo.name + "  :  "+studentinfo.mobile + "\n\n" ;
                }

                t1.setText(s1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
