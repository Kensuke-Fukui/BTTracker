package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogActivity extends AppCompatActivity {

EditText userInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        userInput = (EditText)findViewById(R.id.LoginputData);
    }

    public void confirmBT(View view) {
        Intent toCinfirm = new Intent (this, ConfirmActivity.class);
        toCinfirm.putExtra("BT_data", userInput.getText().toString());
        startActivity(toCinfirm);
    }
}
