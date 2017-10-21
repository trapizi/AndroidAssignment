package com.example.steven.spaghetti.Model;

/**
 * Created by Steven on 20-Oct-17.
 */

public class Ranking {
    private String Uid;
    private long score;

    public Ranking() {
    }

    public Ranking(String uid, long score) {
        Uid = uid;
        this.score = score;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
