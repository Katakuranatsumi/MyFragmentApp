package com.example.katakuranatsumi.myfragmentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    public DetailFragment(){}

    public static DetailFragment newInstance(int position){
       DetailFragment detailFragment = new DetailFragment();
       Bundle args = new Bundle();
       args.putInt("position", position);
       detailFragment.setArguments(args);
       return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View datailView = inflater.inflate(R.layout.view_detail, container, false);
        ((TextView) datailView.findViewById(R.id.detailText))
                .setText(News.Details[getArguments().getInt("position")]);
        return datailView;
    }
}
