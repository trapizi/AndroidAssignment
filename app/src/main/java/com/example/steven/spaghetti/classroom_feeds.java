package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 11/10/17.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class classroom_feeds extends Fragment {

    //final static String DB_URL="https://spaghetti-68866.firebaseio.com/";
    private EditText topic, discussion;
    private RecyclerView listforum;
    private Button postBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.classroom_feeds, container, false);

        topic = (EditText)rootView.findViewById(R.id.topic);
        discussion = (EditText)rootView.findViewById(R.id.discussion);
        listforum = (RecyclerView)rootView.findViewById(R.id.listforum);
        postBtn = (Button)rootView.findViewById(R.id.postBtn);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(rootView);
            }
        });

        return rootView;


    }



    public void post (View view){
        DatabaseReference id = databaseReference.push();
        id.child("Topic").setValue(topic.getText().toString());
        id.child("Discussion").setValue(discussion.getText().toString());

        topic.setText("");
        discussion.setText("");
    }



}
