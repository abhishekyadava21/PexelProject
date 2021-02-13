package com.example.pexel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pexel.R;
import com.example.pexel.adapter.PhotoAdapter;
import com.example.pexel.constants.AppConstant;
import com.example.pexel.listener.OnItemClick;
import com.example.pexel.model.Photos;
import com.example.pexel.view_model.PhotoViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView my_recycler_view;
    private ProgressBar progressBar;
    private LinearLayoutManager layoutManager;
    private PhotoAdapter adapter;
    private ArrayList<Photos> photo = new ArrayList<>();
    ArrayList<Photos> photos;
    PhotoViewModel articleViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getPexelPhotos();
    }

    private void initialization() {
        progressBar = findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);
        adapter = new PhotoAdapter(MainActivity.this, photo);
        my_recycler_view.setAdapter(adapter);
        articleViewModel = ViewModelProviders.of(this).get(PhotoViewModel.class);
    }

    private void getPexelPhotos() {
        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {

                progressBar.setVisibility(View.GONE);
                List<Photos> articles = articleResponse.getPhotos();
                photo.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(MainActivity.this,DetailScreenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.DATA,photos.get(position).getPhotographer());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}