package com.example.steven.spaghetti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.steven.spaghetti.Common.Common;
import com.example.steven.spaghetti.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

public class StartQuiz extends AppCompatActivity {

    Button btnPlay;

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Questions");

        loadQuestion(Common.quizId);

        btnPlay = (Button)findViewById(R.id.btnStartQuiz);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartQuiz.this, Playing.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadQuestion(String quizId) {

        if(Common.questionList.size() > 0) {
            Common.questionList.clear();
        }

        mReference.orderByChild("QuizId").equalTo(quizId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Question question = postSnapshot.getValue(Question.class);
                            Common.questionList.add(question);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        //Shuffle questions
        Collections.shuffle(Common.questionList);
    }
}
