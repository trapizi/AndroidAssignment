package com.example.steven.spaghetti;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by harwinsetyawan on 15/10/17.
 */

public class ListViewAdapter extends BaseAdapter {

    Activity activity;
    List<Forum> lstForum;
    LayoutInflater inflater;


    @Override
    public int getCount() {
        return lstForum.size();
    }

    @Override
    public Object getItem(int position) {
        return lstForum.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater)activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_forum,null);

        TextView txtFullName = (TextView)itemView.findViewById(R.id.listFullName);
        TextView txtEmail = (TextView)itemView.findViewById(R.id.list_email);
        TextView txtTopic = (TextView)itemView.findViewById(R.id.list_topic);
        TextView txtDiscussion = (TextView)itemView.findViewById(R.id.list_discussion);

        txtFullName.setText(lstForum.get(position).getFullname());
        txtEmail.setText(lstForum.get(position).getEmail());
        txtTopic.setText(lstForum.get(position).getTopic());
        txtDiscussion.setText(lstForum.get(position).getDiscussion());

        return itemView;
    }

}
