package com.example.katakuranatsumi.myfragmentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    public final static String EXTRA_POSITION =
            "com.example.katakuranatsumi.myfragmentapp.POSITION";

    private OnTitleSelectedListener listener;

    public TitlesFragment(){}

    public interface OnTitleSelectedListener {
      public void onTitleSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
          listener = (OnTitleSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() +
            " must inplement onTitleSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                News.Titles
        ));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), SubActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        startActivity(intent);
    }
}
