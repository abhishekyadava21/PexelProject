package com.example.pexel.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pexel.repository.PhotoRepository;
import com.example.pexel.response.PhotoResponse;


public class PhotoViewModel extends AndroidViewModel {

    private PhotoRepository articleRepository;
    private LiveData<PhotoResponse> articleResponseLiveData;

    public PhotoViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new PhotoRepository();
        this.articleResponseLiveData = articleRepository.getPexelPhotos();
    }

    public LiveData<PhotoResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
