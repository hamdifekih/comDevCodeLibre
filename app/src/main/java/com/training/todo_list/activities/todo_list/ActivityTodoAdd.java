package com.training.todo_list.activities.todo_list;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import com.training.todo_list.R;


import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;




public class ActivityTodoAdd extends Activity {
        EditText  mEditText;
        Button mButton;
        CalendarView mCalendarView;
        TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_act_todo_add);

        mEditText=(EditText) findViewById(R.id.edt_add_todo);

        mButton=(Button) findViewById(R.id.btn_validate);
        mCalendarView=(CalendarView) findViewById(R.id.calendarView);
        mTextView=(TextView) findViewById(R.id.tv_date);


        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                mTextView.setText(date);
            }

        });

    }

public void addTodo(android.view.View view) {
    String s0=mEditText.getText().toString();
    String s1=mTextView.getText().toString();
    String s=s0+" "+s1;

    Intent intent=new Intent(ActivityTodoAdd.this,ActivityTodoList.class);
    intent.putExtra("mykey", s);
    startActivity(intent);

    }
}
