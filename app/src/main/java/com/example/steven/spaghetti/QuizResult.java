package com.example.steven.spaghetti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.steven.spaghetti.Common.Common;
import com.example.steven.spaghetti.Model.QuestionScore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuizResult extends AppCompatActivity {

    Button btnRetake;
    TextView txtResultScore;
    TextView getTxtResultScore;
    ProgressBar progressBar;

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Question_Score");

        txtResultScore = (TextView)findViewById(R.id.txtTotalScore);
        getTxtResultScore = (TextView)findViewById(R.id.txtTotalQuestion);

        progressBar = (ProgressBar)findViewById(R.id.doneProgressBar);

        btnRetake = (Button)findViewById(R.id.btnTryAgain);

        btnRetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizResult.this, Homepage.class);
                startActivity(intent);
                finish();
            }
        });

        //Retrieve data from bundle and set to view
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int score = extra.getInt("SCORE");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            txtResultScore.setText(String.format("SCORE: %d", score));
            getTxtResultScore.setText(String.format("PASSED: %d / %d", correctAnswer, totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            //UPDATE score to database
            mReference.child(String.format("%s_%s", FirebaseAuth.getInstance().getUid(),
                                                    Common.quizId))
                    .setValue(new QuestionScore(String.format("%s_%s", FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                            Common.quizId),
                            FirebaseAuth.getInstance().getCurrentUser().getUid(),
                            String.valueOf(score),
                            Common.quizId,
                            Common.quizName));
        }
    }
}
