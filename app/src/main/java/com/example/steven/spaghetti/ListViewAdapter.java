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
    List<Forum> listForum;
    LayoutInflater inflater;

    public ListViewAdapter(classroom_feeds activity, List<Forum> lstForum) {
        this.activity = activity.getActivity();
        this.listForum = lstForum;
    }

    @Override
    public int getCount() {
        return listForum.size();
    }

    @Override
    public Object getItem(int position) {
        return listForum.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater)activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_forum,null);


        TextView txtTopic = (TextView)itemView.findViewById(R.id.list_topic);
        TextView txtDiscussion = (TextView)itemView.findViewById(R.id.list_discussion);

        int posisiKebalik = listForum.size()-(position+1);
        txtTopic.setText(listForum.get(posisiKebalik).getTopic());
        txtDiscussion.setText(listForum.get(posisiKebalik).getDiscussion());

        return itemView;
    }

}
