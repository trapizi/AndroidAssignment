package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 15/10/17.
 */

public class Forum {
    private String zid, topic, discussion;



    public Forum() {
    }


    public Forum(String zid, String topic, String discussion) {
        this.zid = zid; // Primary Key
        this.topic = topic;
        this.discussion = discussion;
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }
}
