package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 11/10/17.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class classroom_feeds extends Fragment {
    
    public static classroom_feeds activity;
    private EditText topic, discussion;
    private ListView listforum;
    private Button postBtn;
    private List<Forum> forumList = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.classroom_feeds, container, false);

        topic = (EditText)rootView.findViewById(R.id.topic);
        discussion = (EditText)rootView.findViewById(R.id.discussion);
        listforum = (ListView) rootView.findViewById(R.id.listforum);
        postBtn = (Button)rootView.findViewById(R.id.postBtn);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Forum");

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(rootView);
                addEventFirebaseListener();
            }
        });

        return rootView;


    }




    public void post (View view){
        DatabaseReference id = databaseReference.push();
        id.child("Forum").setValue(topic.getText().toString());
        id.child("Discussion").setValue(discussion.getText().toString());

        topic.setText("");
        discussion.setText("");
    }


    private void addEventFirebaseListener(){
        listforum.setVisibility(View.VISIBLE);
        databaseReference.child("Forum").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (forumList.size()>0){
                    forumList.clear();
                    for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                        Forum forum = postSnapshot.getValue(Forum.class);
                        forumList.add(forum);
                    }
                    ListViewAdapter adapter = new ListViewAdapter(classroom_feeds.this, forumList);
                    listforum.setAdapter(adapter);

                    listforum.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}

