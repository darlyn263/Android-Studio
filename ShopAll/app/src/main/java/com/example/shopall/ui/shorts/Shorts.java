package com.example.shopall.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shopall.R;
import com.example.shopall.databinding.FragmentHomeBinding;
import com.example.shopall.databinding.FragmentShorts2Binding;
import com.example.shopall.ui.home.HomeViewModel;

public class Shorts extends Fragment {

    private FragmentShorts2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentShorts2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textShorts;
        ShortsViewModelhor ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}