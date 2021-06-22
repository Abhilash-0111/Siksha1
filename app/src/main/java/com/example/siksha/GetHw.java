package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GetHw extends AppCompatActivity {

    DatabaseReference db;
    DatabaseReference mData ;
    Boolean saved=null;
    List<homeworkd> homeworks=new ArrayList<>();
    String c ="1",d ;
    Button b1 ;
    FirebaseAuth auth ;
    String mobilenum ;
    MyListAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_hw);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String uid1 = user.getUid();


            FirebaseDatabase database = FirebaseDatabase.getInstance();




        db = FirebaseDatabase.getInstance().getReference().child("homework").child("1");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                homeworks.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    homeworkd h1 = postSnapshot.getValue(homeworkd.class);
                    homeworks.add(h1);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


///////////////

        b1 = (Button) findViewById(R.id.btngethw);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                // startActivity(getIntent());
            load1(recyclerView);
            }
        });
    }
public void load1(RecyclerView recyclerView){

            adapter = new MyListAdapter(homeworks,this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }







}
