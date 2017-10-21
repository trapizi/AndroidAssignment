package com.example.steven.spaghetti.Model;

/**
 * Created by Steven on 16-Oct-17.
 */

public class QuestionScore {
    private String Question_Score;
    private String User;
    private String Score;
    private String QuizId;
    private String QuizName;

    public QuestionScore() {
    }

    public QuestionScore(String question_Score, String user, String score, String quizId, String quizName) {
        Question_Score = question_Score;
        User = user;
        Score = score;
        QuizId = quizId;
        QuizName = quizName;
    }

    public String getQuestion_Score() {
        return Question_Score;
    }

    public void setQuestion_Score(String question_Score) {
        Question_Score = question_Score;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getQuizId() {
        return QuizId;
    }

    public void setQuizId(String quizId) {
        QuizId = quizId;
    }

    public String getQuizName() {
        return QuizName;
    }

    public void setQuizName(String quizName) {
        QuizName = quizName;
    }
}
