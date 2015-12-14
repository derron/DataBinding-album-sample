package com.example.databinding.viewmodel;

import android.view.View;

import com.example.databinding.model.Album;
import com.example.databinding.store.AlbumStore;

public class DeleteAlbumViewModel {
    private final DeleteAlbumView view;
    private final AlbumStore albumStore;
    private final Album album;

    public DeleteAlbumViewModel(DeleteAlbumView view, AlbumStore albumStore, Album album) {
        this.view = view;
        this.albumStore = albumStore;
        this.album = album;
    }

    public void deleteAlbum(View view) {
        albumStore.delete(album);
        this.view.deleted();
    }

    public void dismissDialog(View view) {
        this.view.cancelOperation();
    }

    public String getAlbumTitle() {
        return album.getTitle();
    }

    public String getAlbumArtist() {
        return album.getArtist();
    }
}
