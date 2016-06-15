package com.jappyapps.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    TodoAdapter tadapter;
    TODOStore  store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.todoList);
        tadapter = new TodoAdapter(this);
        store = TODOStore.getInstance();
        list.setAdapter(tadapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                store.toggleCompleted(position);
                tadapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int clicked = item.getItemId();
        switch(clicked) {
            case R.id.add_todo :
                Intent i = new Intent(this , TodoActivity.class);
                startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
