package com.example.pexel.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pexel.repository.PhotoRepository;
import com.example.pexel.response.PhotoResponse;


public class PhotoViewModel extends AndroidViewModel {

    private PhotoRepository photoRepository;
    private LiveData<PhotoResponse> responseLiveData;

    public PhotoViewModel(@NonNull Application application) {
        super(application);

        photoRepository = new PhotoRepository();
        this.responseLiveData = photoRepository.getPexelPhotos();
    }

    public LiveData<PhotoResponse> getArticleResponseLiveData() {
        return responseLiveData;
    }
}
