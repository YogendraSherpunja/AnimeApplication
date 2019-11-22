package com.coventry.animeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnimeLogin extends AppCompatActivity {
    Button login;
    EditText username, password;
    String uusername, upassword;

    @Override
    protected void onCreate(Bundle btnSavedInstanceState) {
        super.onCreate(btnSavedInstanceState);
        setContentView(R.layout.activity_anime_login);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uusername = username.getText().toString();
                upassword = password.getText().toString();


              if (uusername.equals("naruto") && upassword.equals("sasuke")) {
                    Intent intent = new Intent(AnimeLogin.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AnimeLogin.this, "username or password incoorect",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}


