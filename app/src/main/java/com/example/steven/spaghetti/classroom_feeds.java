package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 11/10/17.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

public class classroom_feeds extends Fragment {

    private EditText topic, discussion;
    private ListView listforum;
    private Button add;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.classroom_feeds, container, false);

        return rootView;
    }






}
