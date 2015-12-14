package com.example.databinding.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.adapters.TextViewBindingAdapter;
import android.text.Editable;
import android.view.View;
import android.widget.CompoundButton;

import com.example.databinding.BR;
import com.example.databinding.model.Album;
import com.example.databinding.store.AlbumStore;

public class CreateEditAlbumViewModel extends BaseObservable {

    private final AlbumStore albumStore;
    private final Album.Builder albumBuilder;

    public CreateEditAlbumViewModel(AlbumStore albumStore,
                                    Album.Builder albumBuilder) {
        this.albumStore = albumStore;
        this.albumBuilder = albumBuilder;
    }

    public void save(View view) {
        albumStore.save(albumBuilder.create());
        ((Activity)view.getContext()).finish();
    }

    public String getTitle() {
        return albumBuilder.getTitle();
    }

    public TextViewBindingAdapter.AfterTextChanged titleChanged = new TextViewBindingAdapter.AfterTextChanged() {
        @Override
        public void afterTextChanged(Editable s) {
            albumBuilder.setTitle(s.toString());
        }
    };

    public String getArtist() {
        return albumBuilder.getArtist();
    }

    public TextViewBindingAdapter.AfterTextChanged artistChanged = new TextViewBindingAdapter.AfterTextChanged() {
        @Override
        public void afterTextChanged(Editable s) {
            albumBuilder.setArtist(s.toString());
        }
    };

    public boolean isClassical() {
        return albumBuilder.isClassical();
    }

    public CompoundButton.OnCheckedChangeListener classicalChanged = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            albumBuilder.setClassical(isChecked);
            notifyPropertyChanged(BR.composerEnabled);
        }
    };

    @Bindable
    public boolean isComposerEnabled() {
        return isClassical();
    }

    public String getComposer() {
        return albumBuilder.getComposer();
    }

    public TextViewBindingAdapter.AfterTextChanged composerChanged = new TextViewBindingAdapter.AfterTextChanged() {
        @Override
        public void afterTextChanged(Editable s) {
            albumBuilder.setComposer(s.toString());
        }
    };

}