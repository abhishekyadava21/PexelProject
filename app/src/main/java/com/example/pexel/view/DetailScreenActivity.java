package com.example.pexel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.pexel.R;
import com.example.pexel.constants.AppConstant;

public class DetailScreenActivity extends AppCompatActivity {
    AppCompatImageView imgViewCover;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        imgViewCover = findViewById(R.id.detail_img_view);
        Intent intent = getIntent();
        String strImage = intent.getStringExtra(AppConstant.DATA);
        String toolBarTitle = intent.getStringExtra(AppConstant.TOOLBAR_TITLE);
        Log.d("LOG_TAG", strImage);
        Glide.with(this)
                .load(strImage)
                .into(imgViewCover);

        setTitle(toolBarTitle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}