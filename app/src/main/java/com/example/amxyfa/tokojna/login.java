package com.example.amxyfa.tokojna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.edittext);
        e2 = (EditText)findViewById(R.id.edittext2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(login.this,register.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(email,password);
                if (chkemailpass==true ){
                    if(chkemailpass != null){
                        Intent i = new Intent(login.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "coblagi", Toast.LENGTH_SHORT).show();
                    }
                        Toast.makeText(getApplicationContext(), "Succesfully login", Toast.LENGTH_SHORT).show();
                    }else
                    Toast.makeText(getApplicationContext(),"Wrong email or Password",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
