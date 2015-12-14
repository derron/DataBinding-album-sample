package com.example.databinding.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.example.databinding.activity.CreateEditAlbumActivity;
import com.example.databinding.activity.DeleteAlbumDialog;
import com.example.databinding.model.Album;

public class ViewAlbumViewModel extends BaseObservable {
    private final Album album;

    public ViewAlbumViewModel(Album album) {
        this.album = album;
    }

    public void editAlbum(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, CreateEditAlbumActivity.class);
        intent.putExtra(CreateEditAlbumActivity.ALBUM_ID, album.getId());
        context.startActivity(intent);
    }

    public void deleteAlbum(View view) {
        DeleteAlbumDialog deleteAlbumDialog = new DeleteAlbumDialog((Activity)view.getContext(), album);
        deleteAlbumDialog.show();
    }

}
