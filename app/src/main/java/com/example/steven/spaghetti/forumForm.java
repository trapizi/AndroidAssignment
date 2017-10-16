package com.example.steven.spaghetti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class forumForm extends AppCompatActivity {

    private EditText topic, discussion;
    private ListView list;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_form);

        //Control
        topic = (EditText) findViewById(R.id.topic);
        discussion = (EditText) findViewById(R.id.discussion);



    }

    private boolean onOptionItemSelected (MenuItem item){
        if(item.getItemId() == R.id.post)
        {
            createPost();
        }

    }

    private void createPost(){
        Post post = new Post (UUID.randomUUID().toString(), topic.getText().toString(), discussion.getText().toString());
        mDatabaseReference.child("forum").child(post.getUid()).setValue(post);
    }
}
