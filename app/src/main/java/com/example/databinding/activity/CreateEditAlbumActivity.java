package com.example.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityCreateEditAlbumBinding;
import com.example.databinding.model.Album;
import com.example.databinding.viewmodel.CreateEditAlbumViewModel;


public class CreateEditAlbumActivity extends AbstractActivity {

    public static final String ALBUM_ID = "ALBUM_ID";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long albumId = getIntent().getLongExtra(ALBUM_ID, Album.NO_ID);

        String title;
        Album.Builder albumBuilder;
        if (Album.isNew(albumId)) {
            albumBuilder = new Album.Builder();
            title = getString(R.string.create_album);
        }
        else {
            Album album = getAlbumStore().get(albumId);
            albumBuilder = album.createBuilder();
            title = album.isClassical() ? "Edit Classical Album" : "Edit Album";
        }
        setTitle(title);

        ActivityCreateEditAlbumBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_create_edit_album);
        binding.setViewModel(new CreateEditAlbumViewModel(getAlbumStore(), albumBuilder));
    }

}