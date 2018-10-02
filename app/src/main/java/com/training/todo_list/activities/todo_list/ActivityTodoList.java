package com.training.todo_list.activities.todo_list;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.training.todo_list.R;
import com.training.todo_list.TodoListApplication;
import com.training.todo_list.model.models.Todo;
import com.training.todo_list.model.models.TodoType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ActivityTodoList extends ListActivity implements AdapterView.OnItemClickListener{
    ListView mListView;
    private ArrayList<String> mArrayList;
    private ArrayAdapter<String> mAdapter;
    String[] mSItems = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_act_todo_list);

        mListView = (ListView) findViewById(android.R.id.list);
        mListView.setOnItemClickListener(ActivityTodoList.this);



        String a = addTodo();
        mArrayList = new ArrayList<String>(Arrays.asList(mSItems));
        mAdapter = new ArrayAdapter<String>(this, R.layout.list_items, R.id.txtitem, mArrayList);
        mListView.setAdapter(mAdapter);


        mArrayList.add(a);
        mAdapter.notifyDataSetChanged();


        addTodo();
    }





    public void askAddTodo(View pView) {
        Toast.makeText(this, "Ask add todo", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ActivityTodoList.this, ActivityTodoAdd.class);
        startActivity(intent);

    }


    public void askSurprise(View pView) {
        AlertDialog.Builder tBuilder = new AlertDialog.Builder(this);
        tBuilder.setTitle(R.string.dialog_title_surprise);
        tBuilder.setMessage(R.string.dialog_message_surprise);
        tBuilder.setPositiveButton(R.string.confirm, null);
        tBuilder.show();
    }


    public String addTodo() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("mykey");
           return  value;

        }else {
            return "";
        }

    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(ActivityTodoList.this,ActivityTodoAdd.class);
        startActivity(intent);


    }
}