package com.example.steven.spaghetti;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.steven.spaghetti.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import static com.example.steven.spaghetti.R.id.question_text;

public class Playing extends AppCompatActivity implements View.OnClickListener{

    final static long INTERVAL = 1000; // 1 second
    final static long TIMEOUT = 60000; // 1 minute
    int progressValue = 0;

    CountDownTimer mCountDown;

    int index = 0;
    int score = 0;
    int thisQuestion = 0;
    int totalQuestion;
    int correctAnswer;

    FirebaseDatabase database;
    DatabaseReference mReference;

    ProgressBar progressBar;
    ImageView questionImage;
    Button btnA, btnB, btnC, btnD;
    TextView textScore, textQuestionNum,questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //Connecting database
        database = FirebaseDatabase.getInstance();
        mReference = database.getReference("Questions");

        textScore = (TextView)findViewById(R.id.txtScore);
        textQuestionNum = (TextView)findViewById(R.id.txtTotalQuestion);
        questionText = (TextView)findViewById(question_text);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        btnA = (Button)findViewById(R.id.btnAnswerA);
        btnB = (Button)findViewById(R.id.btnAnswerB);
        btnC = (Button)findViewById(R.id.btnAnswerC);
        btnD = (Button)findViewById(R.id.btnAnswerD);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        mCountDown.cancel();
        if(index < totalQuestion) {
            Button clickedButton = (Button) view;
            if(clickedButton.getText().equals(Common.questionList.get(index).getCorrectAnswer())) {
                //Pick correct answer
                score+=10;
                correctAnswer++;
                showQuestion(++index); //go to next question
            } else {
                //Pick incorrect answer
                Intent intent= new Intent(this, QuizResult.class);
                Bundle dataSend = new Bundle();
                dataSend.putInt("SCORE", score);
                dataSend.putInt("TOTAL", totalQuestion);
                dataSend.putInt("CORRECT", correctAnswer);
                intent.putExtras(dataSend);
                startActivity(intent);
                finish();
            }

            textScore.setText(String.format("%d", score));
        }

    }

    private void showQuestion(int index) {
        if(index < totalQuestion) {
            thisQuestion++;
            textQuestionNum.setText(String.format("%d / %d", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue=0;

            if(Common.questionList.get(index).getIsImageQuestion().equals("true")) {
                //If the quiz has image
                Picasso.with(getBaseContext())
                        .load(Common.questionList.get(index).getQuestion())
                        .into(questionImage);
                questionImage.setVisibility(View.VISIBLE);
                questionText.setVisibility(View.INVISIBLE);
            } else {
                questionText.setText(Common.questionList.get(index).getQuestion());
                questionImage.setVisibility(View.VISIBLE);
                questionText.setVisibility(View.INVISIBLE);
            }
            btnA.setText(Common.questionList.get(index).getAnswerA());
            btnB.setText(Common.questionList.get(index).getAnswerB());
            btnC.setText(Common.questionList.get(index).getAnswerC());
            btnD.setText(Common.questionList.get(index).getAnswerD());

            mCountDown.start();
        } else {
            Intent intent= new Intent(this, QuizResult.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE", score);
            dataSend.putInt("TOTAL", totalQuestion);
            dataSend.putInt("CORRECT", correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        totalQuestion = Common.questionList.size();

        mCountDown = new CountDownTimer(TIMEOUT, INTERVAL) {
            @Override
            public void onTick(long minisec) {
                progressBar.setProgress(progressValue);
                progressValue++;
            }

            @Override
            public void onFinish() {
                mCountDown.cancel();
                showQuestion(++index);
            }
        };
        showQuestion(++index);
    }
}
