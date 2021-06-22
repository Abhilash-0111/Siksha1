package com.example.siksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Admin_act extends AppCompatActivity {

    CardView tc,tv,tf,tl,thw ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_act);

        tc = (CardView) findViewById(R.id.create) ;
        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createuser();
            }
        });



        tv =(CardView) findViewById(R.id.viewu) ;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewuser();
            }
        });





        tf = (CardView)findViewById(R.id.viewl) ;
        tf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewlist();
            }
        });

        thw = (CardView)findViewById(R.id.updatehw) ;
        thw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatehw();
            }
        });


    }

    public void createuser(){
        Intent intent1 = new Intent(this, CreateUser.class);
        startActivity(intent1);
    }


    public void viewuser(){
        Intent intent1 = new Intent(this, view_user.class);
        startActivity(intent1);
    }

    public void viewfees(){
        Intent intent1 = new Intent(this, User_list.class);
        startActivity(intent1);
    }

    public void viewlist(){
        Intent intent1 = new Intent(this, User_list.class);
        startActivity(intent1);
    }


    public void updatehw(){
        Intent intent1 = new Intent(this, UpdateHw.class);
        startActivity(intent1);
    }


}

