package com.example.databinding.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;

import com.example.databinding.R;
import com.example.databinding.databinding.DialogDeleteAlbumBinding;
import com.example.databinding.model.Album;
import com.example.databinding.viewmodel.DeleteAlbumView;
import com.example.databinding.viewmodel.DeleteAlbumViewModel;

public class DeleteAlbumDialog extends Dialog implements DeleteAlbumView {
    private final Activity activity;

    public DeleteAlbumDialog(Activity activity, Album album) {
        super(activity);
        this.activity = activity;
        setCancelable(true);
        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                navigateToAlbums();
            }
        });

        DeleteAlbumViewModel deleteAlbumDialogViewModel = new DeleteAlbumViewModel(
                this, getAlbumApp().getAlbumStore(), album);
        setTitle(R.string.delete_album);
        DialogDeleteAlbumBinding binding = DialogDeleteAlbumBinding.inflate(getLayoutInflater());
        binding.setAlbum(album);
        binding.setHandler(deleteAlbumDialogViewModel);
        setContentView(binding.getRoot());
    }

    private AlbumApp getAlbumApp() {
        return (AlbumApp) getContext().getApplicationContext();
    }

    @Override
    public void deleted() {
        navigateToAlbums();
    }

    private void navigateToAlbums() {
        dismiss();
        activity.finish();
    }

    @Override
    public void cancelOperation() {
        dismiss();
    }

}
