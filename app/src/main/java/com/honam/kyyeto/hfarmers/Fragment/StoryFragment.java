package com.honam.kyyeto.hfarmers.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honam.kyyeto.hfarmers.R;

/**
 * Created by kyyet on 2019-01-22.
 */

public class StoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        return view;
    }

}