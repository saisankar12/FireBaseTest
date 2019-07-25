package com.books.firebasetest;

import android.content.Intent;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText mobile,pass;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobile=findViewById(R.id.loginmobile);
        pass=findViewById(R.id.loginpassword);

    }

    public void Login(View view)
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                flag=false;
                User user=null;
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    user=snapshot.getValue(User.class);
                    //Toast.makeText(MainActivity.this, ""+user.getMobileNumber(), Toast.LENGTH_SHORT).show();
                    if (user.getMobileNumber().equals(mobile.getText().toString())
                            && user.getPassword().equals(pass.getText().toString())){
                        flag=true;
                        if (flag){
                            Intent welcome=new Intent(MainActivity.this,WelcomeActivity.class);
                            welcome.putExtra("key",mobile.getText().toString());
                            startActivity(welcome);
                        }
                        break;
                    }

                }
                if(!flag)
                    Toast.makeText(MainActivity.this, "Inavlid Login", Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void register(View view)
    {
        Intent welcome=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(welcome);
    }
}
