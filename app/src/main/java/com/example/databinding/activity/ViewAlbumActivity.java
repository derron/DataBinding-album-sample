package com.example.databinding.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.databinding.databinding.ActivityViewAlbumBinding;
import com.example.databinding.model.Album;
import com.example.databinding.viewmodel.ViewAlbumViewModel;

public class ViewAlbumActivity extends AbstractActivity {
    public static final String ALBUM_ID = "album_id";
    private ActivityViewAlbumBinding mBinding;
    private long mAlbumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        long albumId = intent.getLongExtra(ALBUM_ID, Album.NO_ID);

        if (albumId == Album.NO_ID) {
            throw new IllegalArgumentException("No album id is given");
        }
        mAlbumId = albumId;
        Album album = getAlbumStore().get(albumId);
        mBinding = ActivityViewAlbumBinding.inflate(getLayoutInflater());
        mBinding.setHandler(new ViewAlbumViewModel(album));
        mBinding.setAlbum(album);
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.setAlbum(getAlbumStore().get(mAlbumId));
    }

}
