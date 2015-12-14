package com.example.databinding.activity;

import android.app.Application;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.databinding.R;
import com.example.databinding.store.AlbumStore;
import com.example.databinding.store.MemoryAlbumStore;

public class AlbumApp extends Application {
    private AlbumStore albumStore;
    private static AlbumApp sInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        
        albumStore = new MemoryAlbumStore();
        
        TestData testData = new TestData();
        testData.setUp(albumStore);
    }

    public static AlbumApp getInstance() {
        return sInstance;
    }

    public AlbumStore getAlbumStore() {
        return albumStore;
    }

    @BindingConversion
    public static View convertResIdToLayout(int resId) {
        return View.inflate(AlbumApp.getInstance(), resId, null);
    }

}
