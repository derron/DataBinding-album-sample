package com.example.databinding.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.databinding.BR;
import com.example.databinding.R;
import com.example.databinding.activity.CreateEditAlbumActivity;
import com.example.databinding.activity.ViewAlbumActivity;
import com.example.databinding.model.Album;
import com.example.databinding.store.AlbumStore;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;

public class ViewAlbumsViewModel extends BaseObservable {

    private final AlbumStore albumStore;

    public ViewAlbumsViewModel(AlbumStore albumStore) {
        this.albumStore = albumStore;
    }

    public final ObservableList<Album> albums = new ObservableArrayList<>();
    public final ItemViewSelector<Album> itemView = new ItemViewSelector<Album>() {
        @Override
        public void select(ItemView itemView, int position, Album item) {
            itemView.set(BR.item, item.isClassical() ? R.layout.album_row2 : R.layout.album_row);
        }

        @Override
        public int viewTypeCount() {
            return 2;
        }
    };

    public void refreshAlbums() {
        albums.clear();
        albums.addAll(albumStore.getAll());
    }

    public void createAlbum(View view) {
        Context context = view.getContext();
        context.startActivity(new Intent(context, CreateEditAlbumActivity.class));
    }

    public void viewAlbum(AdapterView<?> parent, View view, int position, long id) {
        Context context = view.getContext();
        Album album = albumStore.getByIndex(position);
        Intent intent = new Intent(context, ViewAlbumActivity.class);
        intent.putExtra(ViewAlbumActivity.ALBUM_ID, album.getId());
        context.startActivity(intent);
    }

}
