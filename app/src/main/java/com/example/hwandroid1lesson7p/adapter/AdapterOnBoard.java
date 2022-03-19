package com.example.hwandroid1lesson7p.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hwandroid1lesson7p.ui.fragments.OnBoardFragment;
import com.example.hwandroid1lesson7p.model.OnBoardModel;

import java.util.ArrayList;

public class AdapterOnBoard extends FragmentStateAdapter {
    ArrayList<OnBoardModel> list = new ArrayList<>();

    public AdapterOnBoard(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<OnBoardModel> list) {
        super(fragmentManager, lifecycle);
        this.list = list;

    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new OnBoardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putString(OnBoardFragment.DESCRIPTION, list.get(position).getDescription());
        bundle.putString(OnBoardFragment.DESCRIPTION, list.get(position).getDescription());
        bundle.putString(OnBoardFragment.DESCRIPTION, list.get(position).getDescription());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
