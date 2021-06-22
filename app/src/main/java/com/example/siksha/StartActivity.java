package com.example.siksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StartActivity extends AppCompatActivity {

    ListView list1 ;
    String notifications[] = {"  ","  "," ","  ","  "} ;
Button btn1,btn2 ;
    int currentPage = 0 ;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        /////////






      //  new abcd().execute() ;








        ///////////



        //slider
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);



        //slider



btn1 = (Button) findViewById(R.id.studin) ;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  new abcd().execute() ;
                openstudin();
            }
        });


        btn2 =(Button) findViewById(R.id.adminin) ;
try {
    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            openadminin();
            int a = 5;
        }
    });
}
catch (Exception e){
    openstudin();
}



        int count = 1 ;
        while(count<5) {

            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Notifications").child(String.valueOf(count));


            // Read from the database
            final int finalCount = count;
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
             notifications[finalCount-1] = value ;

                    list1 = (ListView)findViewById(R.id.list1);
                    CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),notifications);
                    list1.setAdapter((ListAdapter) customAdapter);

                }




                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Failed to read value.", error.toException());
                }
            });
            count++ ;

        }





    }


    public void openstudin(){
        Intent intent1 = new Intent(this, StudIn.class);
        startActivity(intent1);
    }

    public void openadminin(){
        Intent intent1 = new Intent(this, Adminlogin.class);
        startActivity(intent1);
    }


    static public String sendsms() {
        try {
            // Construct data
            String apiKey = "apikey=" + "ZOUGzTMIcjQ-bLsDCvWAtipswBT5ALB7Y2QBu6Q4en";
            String message = "&message=" + "This is your message";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "919752218855";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }


}
class abcd extends AsyncTask<String,String,Integer>{


    @Override
    protected Integer doInBackground(String... strings) {
        StartActivity.sendsms() ;

        return null;
    }
}
