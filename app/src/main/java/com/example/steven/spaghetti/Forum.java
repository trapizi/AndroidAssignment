package com.example.steven.spaghetti;

/**
 * Created by harwinsetyawan on 15/10/17.
 */

public class Forum {
    private String zid, fullname, email, topic, discussion;



    public Forum() {
    }


    public Forum(String zid, String fullname, String email, String topic, String discussion) {
        this.zid = zid;
        this.fullname = fullname;
        this.email = email;
        this.topic = topic;
        this.discussion = discussion;
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
