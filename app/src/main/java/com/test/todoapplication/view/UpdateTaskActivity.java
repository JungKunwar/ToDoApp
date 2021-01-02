package com.test.todoapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.todoapplication.R;
import com.test.todoapplication.model.TodoData;
import com.test.todoapplication.viewmodel.ToDoViewModel;

public class UpdateTaskActivity extends AppCompatActivity {
    private ToDoViewModel mViewModel;

    private AppCompatEditText mEditTextDate, mEditTextTodo;
    private AppCompatButton mBtnEdit;
    TodoData mTodoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        mViewModel = ViewModelProviders.of(this).get(ToDoViewModel.class);
        mEditTextDate = findViewById(R.id.et_edit_date);
        mEditTextTodo = findViewById(R.id.et_edit_todo);
        mBtnEdit = findViewById(R.id.btn_edit_save);

        mTodoData = getIntent().getParcelableExtra("todo");
        mEditTextTodo.setText(mTodoData.getTodo());
        mEditTextDate.setText(mTodoData.getDate());

        Toolbar toolbar = findViewById(R.id.toolbar_update);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
