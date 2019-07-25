package com.books.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText name,email,pass,cpass,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.reguname);
        email=findViewById(R.id.regemail);
        pass=findViewById(R.id.regpassword);
        cpass=findViewById(R.id.confirmpassword);
        mobile=findViewById(R.id.regmobile);

    }

    public void register(View view)
    {
        String n = name.getText().toString();
        String m = mobile.getText().toString();
        String e = email.getText().toString();
        String p = pass.getText().toString();
        User u = new User(m,e,n,p);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        ref.child(m).setValue(u);

    }
}
