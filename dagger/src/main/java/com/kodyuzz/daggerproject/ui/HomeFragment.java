package com.kodyuzz.daggerproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kodyuzz.daggerproject.MyApplication;
import com.kodyuzz.daggerproject.R;
import com.kodyuzz.daggerproject.di.component.DaggerFragmentComponent;
import com.kodyuzz.daggerproject.scope.FragmentScope;

import javax.inject.Inject;

@FragmentScope
public class HomeFragment extends Fragment {

    @Inject
    HomeViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication) getActivity().getApplication()).getApplicationComponent())
//                .fragmentModule(new FragmentModule())
                .build()
                .inject(this);
        viewModel.updateView();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
