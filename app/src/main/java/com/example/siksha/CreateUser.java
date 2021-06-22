package com.example.siksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class CreateUser extends AppCompatActivity {

    EditText email, password, session , mpregno , name, fname , dob, category ,gender,mobile, shift, unit,admndt,fees, feesd,qresult,qexam,tcno, address, dgtregno, uid, board, lasti,hq;
    private FirebaseAuth mAuth;
    DatePicker dobpick ;
     Button btn1 ;
    private static final String TAG = "Createuser" ;
    DatabaseReference mDatabase ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

       email =(EditText) findViewById(R.id.email) ;
       password =(EditText) findViewById(R.id.password) ;
       session =(EditText) findViewById(R.id.Session) ;
       mpregno =(EditText) findViewById(R.id.mpregno) ;
       name =(EditText) findViewById(R.id.name) ;
       fname =(EditText) findViewById(R.id.fname) ;
       dob =(EditText) findViewById(R.id.dob) ;
       category =(EditText) findViewById(R.id.category) ;
       gender =(EditText) findViewById(R.id.gender) ;
       mobile =(EditText) findViewById(R.id.mobile) ;
       shift =(EditText) findViewById(R.id.Shift) ;
       unit =(EditText) findViewById(R.id.unit) ;
       admndt =(EditText) findViewById(R.id.Admndt) ;
       fees =(EditText) findViewById(R.id.fees) ;
       feesd =(EditText) findViewById(R.id.feesd) ;
       board =(EditText) findViewById(R.id.board) ;
       hq =(EditText) findViewById(R.id.hq) ;
       qexam =(EditText) findViewById(R.id.qexam) ;
       qresult =(EditText) findViewById(R.id.qresult) ;
       lasti =(EditText) findViewById(R.id.lastinstitute) ;
       uid =(EditText) findViewById(R.id.uid) ;
       address =(EditText) findViewById(R.id.address) ;
       tcno =(EditText) findViewById(R.id.tcno) ;
       dgtregno =(EditText) findViewById(R.id.dgtregno) ;
///////

       btn1 = (Button) findViewById(R.id.submit) ;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final StudInfo d1 = new StudInfo();
                d1.admisiondate = admndt.getText().toString();
                d1.category = category.getText().toString();
                d1.dob = dob.getText().toString();
                d1.email = email.getText().toString();
                d1.fees = 00;
                d1.feesd = 00 ;
                d1.fname = fname.getText().toString();
                d1.gender = gender.getText().toString();
                d1.mobile = mobile.getText().toString();
                d1.mpregno = mpregno.getText().toString();
                d1.name = name.getText().toString();
                d1.password = password.getText().toString();
                d1.session = session.getText().toString();
                d1.shift = shift.getText().toString();
                d1.uid = uid.getText().toString();
                d1.hq = hq.getText().toString();
                d1.address = address.getText().toString();
                d1.qresut = qresult.getText().toString();
                d1.qexam = qexam.getText().toString();
                d1.lastintitute = lasti.getText().toString();
                d1.board = board.getText().toString();
                d1.tcno = tcno.getText().toString();
                d1.dgtregno = dgtregno.getText().toString();


                //validtion



                if (TextUtils.isEmpty(d1.email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(d1.password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

              /*  if (!isValidMobile(d1.mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter correct mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidFormat("dd/MM/yyyy", d1.dob)) {
                    Toast.makeText(getApplicationContext(), "Enter date in correct format ", Toast.LENGTH_SHORT).show();
                    return;
                }

               /* if (d1.session!="2017-2018" || d1.session!="2018-2019" ||d1.session!="2019-2020"||d1.session!="2020-2021" ) {
                    Toast.makeText(getApplicationContext(), "Enter correct session ", Toast.LENGTH_LONG).show();
                    return;
                }
                */

                /*if(!d1.name.matches("[a-zA-Z ]+"))
                {
                    name.requestFocus();
                    Toast.makeText(getApplicationContext(), "Enter only alphabet in name ", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!d1.fname.matches("[a-zA-Z ]+"))
                {
                   fname.requestFocus();
                    Toast.makeText(getApplicationContext(), "Enter only alphabet in name ", Toast.LENGTH_LONG).show();
                    return;
                }

*/

// ...
// Initialize Firebase Auth
                mAuth = FirebaseAuth.getInstance();


                mAuth.createUserWithEmailAndPassword(d1.email, d1.password)
                        .addOnCompleteListener(CreateUser.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(CreateUser.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String uid = user.getUid();


                                    mDatabase = FirebaseDatabase.getInstance().getReference();
                                    mDatabase.child("studinfo").child(d1.mobile).setValue(d1);
                                    mDatabase.child("studinfo").child(uid).setValue(d1);
                                    mDatabase.child("uidmobile").child(uid).setValue(d1.mobile);



                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(CreateUser.this, "Authentication failed."+task.getException(),
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });

            }
            });

    }

    private boolean isValidMobile(String phone) {
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() == 10;
        }
        return false;
    }


    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }


    }