package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {
    TextView accessData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        accessData = (TextView)findViewById(R.id.showBTData);
        Bundle transferredData = getIntent().getExtras();
        String s = transferredData.getString("BT_data");
        String txt = "Your input body temperature is" + s;
        accessData.setText(txt);
    }

    public void backToHome(View view) {
        Intent backHome = new Intent(this, MainActivity.class);
        startActivity(backHome);
    }
}