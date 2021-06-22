package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class UpdateHw extends AppCompatActivity {

    EditText hwc, hwl, hwm ;
    DatabaseReference refhw ;
    Button b1 ;
    String clas ;
    String message, link ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hw);

        hwc = (EditText)findViewById(R.id.hwc) ;
        hwl = (EditText)findViewById(R.id.hwl) ;
        hwm = (EditText)findViewById(R.id.hwm) ;
        b1 = (Button)findViewById(R.id.submit) ;

        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                message = hwm.getText().toString();
                link = hwl.getText().toString();
                clas = hwc.getText().toString();
                updatehomework(message,link,clas) ;
            }
        } );



    }
long count = 0 ;
    void updatehomework(String m, String l, String c ){


      /*  refhw.child("homework").child(c).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count = dataSnapshot.getChildrenCount() ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }) ;

*/
        count++ ;
       homeworkd hw = new homeworkd(message,link) ;
        refhw = FirebaseDatabase.getInstance().getReference();
        refhw.child("homework").child(c).push().setValue(hw);
       // refhw.child("homework").child(c).push().child("message").setValue(m);
       // refhw.child("homework").child(c).push().child("link").setValue(l);
        Toast.makeText(UpdateHw.this, "  Updated  ", Toast.LENGTH_LONG).show();




    }



}
