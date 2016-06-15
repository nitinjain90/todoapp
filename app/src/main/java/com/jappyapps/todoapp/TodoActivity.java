package com.jappyapps.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class TodoActivity extends AppCompatActivity {

      EditText todo;
      TODOStore store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        todo = (EditText) findViewById(R.id.enter_todo);
        store = TODOStore.getInstance();

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_todo , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.save_todo :
                String  s = todo.getText().toString();
                store.addTodo(s);
                Intent i = new Intent(this , MainActivity.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
