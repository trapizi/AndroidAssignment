package com.example.steven.spaghetti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class forumForm extends AppCompatActivity {

    private EditText topic, discussion;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_form);

        //Control
        topic = (EditText) findViewById(R.id.topic);
        discussion = (EditText) findViewById(R.id.discussion);
        list = (ListView) findViewById(R.id.list);

    }
}
