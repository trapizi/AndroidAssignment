package com.example.steven.spaghetti;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by harwinsetyawan on 15/10/17.
 */

public class Forum {
    private String user;



    private Date postDate;
    private String topic;
    private String discussion;



    public Forum() {
    }

    public Forum(String user, Date postDate, String topic, String discussion) {
        this.user = user;
        this.postDate = postDate;
        this.topic = topic;
        this.discussion = discussion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
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
