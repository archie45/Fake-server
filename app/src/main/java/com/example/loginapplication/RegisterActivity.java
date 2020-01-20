package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText Name,pass;

    private Button reg;
    FakeServer fakeServer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fakeServer = new FakeServer();

        Name = findViewById(R.id.etName);
        pass = findViewById(R.id.etpass);
        reg = findViewById((R.id.btnRegister));
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = Name.getText().toString();
                String upass = pass.getText().toString();
                checkRegisterUser(uname,upass);
                Intent intent = new Intent(RegisterActivity.this,LogInActivity.class);
                intent.putExtra("a",fakeServer);
                startActivity(intent);
            }
        });
    }
    public void checkRegisterUser (String uname,String upass)
    {

        if (uname.isEmpty() || upass.isEmpty()) {
            Toast.makeText(this, "Name or Password can't be empty", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Registering", Toast.LENGTH_SHORT).show();
            fakeServer.registeruser(uname, upass);


        }


    }
}











