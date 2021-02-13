package com.example.pexel.retrofit;

import com.example.pexel.constants.AppConstant;
import com.example.pexel.response.PhotoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiRequest {

    @Headers("Authorization: 563492ad6f917000010000013f8cf904642e45afb9a26c066d8a6079")
    @GET(AppConstant.PHOTO_END_POINT_URL)
    Call<PhotoResponse> getPexelPhotos();
}
