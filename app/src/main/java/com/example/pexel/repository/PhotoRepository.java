package com.example.pexel.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pexel.response.PhotoResponse;
import com.example.pexel.retrofit.ApiRequest;
import com.example.pexel.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    private static final String TAG = PhotoRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public PhotoRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<PhotoResponse> getPexelPhotos() {
        final MutableLiveData<PhotoResponse> data = new MutableLiveData<>();
        apiRequest.getPexelPhotos()
                .enqueue(new Callback<PhotoResponse>() {


                    @Override
                    public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            Log.d(TAG, "articles size:: " + response.body().getPhotos().size());
                            Log.d(TAG, "articles title pos 0:: " + response.body().getPhotos().get(0).getPhotographer());
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
