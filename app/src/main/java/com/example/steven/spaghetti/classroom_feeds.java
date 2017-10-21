package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 11/10/17.
 */


import android.nfc.Tag;
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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


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

        Log.d("spagetthi-log-tag","on create view triggered");

        topic = (EditText)rootView.findViewById(R.id.topic);
        discussion = (EditText)rootView.findViewById(R.id.discussion);
        listforum = (ListView) rootView.findViewById(R.id.listforum);
        postBtn = (Button)rootView.findViewById(R.id.postBtn);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Forum");

        List<Forum> forumList=new ArrayList<Forum>();
        listforum.setAdapter(new ListViewAdapter(this,forumList));

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("spaghetti-log-tag", "onChildAdded:" +dataSnapshot.getKey());

                Forum forum = dataSnapshot.getValue(Forum.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(rootView);

            }
        });

        return rootView;


    }




    public void post (View view){
        String idStr = databaseReference.push().getKey();
        Forum forum = new Forum();
        forum.setTopic(topic.getText().toString());
        forum.setDiscussion(discussion.getText().toString());
        databaseReference.child(idStr).setValue(forum);


        /*DatabaseReference id = databaseReference.push();
        id.child("Forum").setValue(topic.getText().toString());
        id.child("Discussion").setValue(discussion.getText().toString());*/

        topic.setText("");
        discussion.setText("");
        //addEventFirebaseListener();
    }


    private void addEventFirebaseListener(){
        listforum.setVisibility(View.VISIBLE);
        databaseReference.child("Forum").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                        Forum forum = dataSnapshot.getValue(Forum.class);
                        forumList.add(forum);
                    }
                    ListViewAdapter adapter = new ListViewAdapter(classroom_feeds.this, forumList);
                    listforum.setAdapter(adapter);

                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}

