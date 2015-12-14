package com.example.databinding.viewmodel;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.databinding.activity.ViewAlbumsActivity;


public class HomeViewModel {

    public void showAlbums(View view) {
        Context context = view.getContext();
        context.startActivity(new Intent(context, ViewAlbumsActivity.class));
    }
}
