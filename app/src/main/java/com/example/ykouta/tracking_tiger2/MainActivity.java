package com.example.ykouta.tracking_tiger2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int RESULT_INPUTNUMBER = 1000;
    static ArrayList<NimotuInfo>  syaryoInfoList;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        syaryoInfoList = new ArrayList<>();
        tableLayout = (TableLayout)findViewById(R.id.nimotuTable);

        Button inputNum = findViewById(R.id.syaryoNumInput);
        inputNum.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent(getApplication(), InputNumActivity.class);
                startActivityForResult(intent,RESULT_INPUTNUMBER);
            }
        });

        Button qrReader = findViewById(R.id.tumikomi);
        qrReader.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                /*Intent intent = new Intent(getApplication(), QrReadActivity.class);
                startActivity(intent);*/
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setBeepEnabled(false);
                integrator.initiateScan();
            }
        });

        Button tracking = findViewById(R.id.trackingStart);
        tracking.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent(getApplication(), TrackingActivity.class);
                startActivity(intent);
            }
        });




    }

    //メニューボタン
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        TextView textView = (TextView)findViewById(R.id.textView);
        switch (item.getItemId()){
            case R.id.logout:
                textView.setText(R.string.logout);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);

        if (requestCode == RESULT_INPUTNUMBER && resultCode == RESULT_OK && null != intent) {
            String resNum = intent.getStringExtra("syaryoNum");
            TextView textView = (TextView) findViewById(R.id.inputNumber);
            textView.setText(resNum);
        }else if(requestCode != RESULT_INPUTNUMBER && intent != null){
            String str = intentResult.getContents();
            NimotuInfo nimotuInfo = new NimotuInfo();
            nimotuInfo.setNimotuNum(str);

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            TextView nimotuNum = new TextView(this);
            nimotuNum.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
            nimotuNum.setTextSize(25);
            nimotuNum.setPadding(5,5,5,5);
            nimotuNum.setText(str);
            tableRow.addView(nimotuNum);

            tableLayout.addView(tableRow);


        }


    }

}
