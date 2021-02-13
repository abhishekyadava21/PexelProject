package com.example.pexel.listener;

import com.example.pexel.model.Photos;

import java.util.ArrayList;

public interface OnItemClick {
    public void onItemClicked(ArrayList<Photos> photoList, int position);
}
