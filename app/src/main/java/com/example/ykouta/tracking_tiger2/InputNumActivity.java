package com.example.ykouta.tracking_tiger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Y.Kouta on 2017/11/09.
 */

public class InputNumActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syaryonum_input);

        editText = (EditText)findViewById(R.id.inputEdit);

        Button send = findViewById(R.id.sendButton);
        send.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                if(editText.getText() != null) {
                    String syaryoNum = editText.getText().toString();
                    intent.putExtra("syaryoNum", syaryoNum);

                /*intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);*/
                }
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
