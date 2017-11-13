package com.example.ykouta.tracking_tiger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Y.Kouta on 2017/11/04.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
            }
        });
    }
}
