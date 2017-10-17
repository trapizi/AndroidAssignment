package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 11/10/17.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

public class classroom_feeds extends Fragment {

    private EditText topic, discussion;
    private ListView listforum;
    private Menu menu_forum;


    //Add Toolbar

    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.classroom_feeds, container, false);

        return rootView;
    }




   @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_forum,menu);
        //return true;
    }




}
