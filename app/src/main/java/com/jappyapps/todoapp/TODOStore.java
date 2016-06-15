package com.jappyapps.todoapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by harash on 02/06/16.
 */
public class TODOStore {

    class TODOItem implements Comparable {
        String text;
        int votes;
        boolean completed;

        public TODOItem(String text, int votes, boolean completed) {
            this.text = text;
            this.votes = votes;
            this.completed = completed;
        }

        @Override
        public int compareTo(Object another) {
            TODOItem item = (TODOItem) another;
            if (completed && !item.completed)
                return 1;
            else if (!completed && item.completed)
                return -1;
            else if (votes > item.votes)
                return -1;
            else if (votes < item.votes)
                return 1;
            else
                return text.compareTo(item.text);
        }

        // we are greater = -1;

    }

    ArrayList<TODOItem> todos;

    private static TODOStore store = new TODOStore();

    private TODOStore() {
        todos = new ArrayList<TODOItem>();

    }

    public void addTodo(String text) {
        todos.add(new TODOItem(text , 0, false));
        sort();
    }

    public void deleteTodo(int index) {
        todos.remove(index);
        sort();
    }

    public boolean isCompleted(int index){
        return todos.get(index).completed;
    }

    public void toggleCompleted(int index){
        todos.get(index).completed = !todos.get(index).completed;
        sort();
    }

    public int countTodos() {
        return todos.size();
    }

    public String getTodo(int index) {
        return todos.get(index).text;
    }

    public void sort(){
        Collections.sort(todos);
    }

    public int getVote(int index) {
        return todos.get(index).votes;
    }

    public void vote(int index) {
        todos.get(index).votes++;
        sort();
    }

    public static TODOStore getInstance() {
        return store;
    }

//    public static void main(String args[]){
//        TODOStore store = new TODOStore();
//        store.addTodo("A TODO");
//        store.addTodo("B TODO");
//        System.out.println(store.getTodo(0));
//        store.vote(1);
//        System.out.println(store.getTodo(0));
//        store.deleteTodo(0);
//        System.out.println(store.getTodo(0));
//    }
}
