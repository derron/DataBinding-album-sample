package com.example.databinding.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.databinding.databinding.ActivityHomeBinding;
import com.example.databinding.viewmodel.HomeViewModel;

public class HomeActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, com.example.databinding.R.layout.activity_home);
        binding.setViewModel(new HomeViewModel());
    }

}
