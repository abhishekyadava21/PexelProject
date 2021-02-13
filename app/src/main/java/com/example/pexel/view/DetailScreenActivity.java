package com.example.pexel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pexel.R;

public class DetailScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        Bundle b = getIntent().getExtras();

    }
}