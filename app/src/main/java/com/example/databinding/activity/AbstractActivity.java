package com.example.databinding.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.databinding.R;
import com.example.databinding.store.AlbumStore;

public abstract class AbstractActivity extends AppCompatActivity {

    private AlbumApp getAlbumApp() {
        return (AlbumApp) getApplicationContext();
    }

    public AlbumStore getAlbumStore() {
        return getAlbumApp().getAlbumStore();
    }

}
