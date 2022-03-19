package com.example.hwandroid1lesson7p.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hwandroid1lesson7p.databinding.FragmentOnBoardBinding;


public class OnBoardFragment extends Fragment {
    private FragmentOnBoardBinding binding;
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            binding.tvDescription.setText(getArguments().getString(DESCRIPTION));
            binding.tvTitle.setText(getArguments().getString(TITLE));
            binding.imAvatar.setImageResource(getArguments().getInt(IMAGE));
            binding.tvDescription.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}