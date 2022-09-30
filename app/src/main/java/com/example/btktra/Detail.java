package com.example.btktra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tv = (TextView) findViewById(R.id.detail);
        Intent intent= getIntent();
        tv.setText(intent.getStringExtra("ten"));
    }
}