package com.vietnamrubbergroup;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vietnamrubbergroup.databinding.ActivityLoginBinding;
import com.vietnamrubbergroup.utils.ScreenSupport;

/**
 * Created by Nguyen Kim Khanh on 7/29/2020.
 */
public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //get height status bar
        ScreenSupport.getStatusBarHeight(this);
    }
}
