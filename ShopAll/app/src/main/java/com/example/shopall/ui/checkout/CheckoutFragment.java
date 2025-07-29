package com.example.shopall.ui.checkout;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopall.R;
import com.example.shopall.databinding.FragmentCheckoutBinding;
import com.example.shopall.databinding.FragmentGalleryBinding;

public class CheckoutFragment extends Fragment {



    private FragmentCheckoutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



     binding = FragmentCheckoutBinding.inflate(inflater,container,false);
        View root = binding.getRoot();





        return  root;



    }



}