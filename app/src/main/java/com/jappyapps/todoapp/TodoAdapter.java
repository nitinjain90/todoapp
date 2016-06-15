package com.jappyapps.todoapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by harash on 02/06/16.
 */
public class TodoAdapter extends BaseAdapter {

    TODOStore store;
    Context mContext;

    public TodoAdapter(Context context){
        store = TODOStore.getInstance();
        mContext = context;

    }


    @Override
    public int getCount() {
        return store.countTodos();
    }

    @Override
    public Object getItem(int position) {
        return store.getTodo(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.todo_list_view, parent, false);
        }
        TextView todo_title = (TextView) convertView.findViewById(R.id.todo_title);
        TextView todo_votes = (TextView) convertView.findViewById(R.id.todo_votes);
        ImageView favourite = (ImageView) convertView.findViewById(R.id.todo_favourite);

        todo_title.setText(store.getTodo(position));
        todo_votes.setText(store.getVote(position) + " Votes");

        if(store.isCompleted(position)){
            convertView.setBackgroundColor(Color.LTGRAY);
        }else{
            convertView.setBackgroundColor(Color.WHITE);
        }

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store.vote(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
