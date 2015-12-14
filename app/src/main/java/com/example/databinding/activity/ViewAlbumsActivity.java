package com.example.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityViewAlbumsBinding;
import com.example.databinding.viewmodel.ViewAlbumsViewModel;

public class ViewAlbumsActivity extends AbstractActivity {
    protected ViewAlbumsViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewAlbumsViewModel(getAlbumStore());
        ActivityViewAlbumsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_albums);
        binding.setViewModel(mViewModel);
        binding.albumListView.setEmptyView(binding.emptyView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.refreshAlbums();
    }

}