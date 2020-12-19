package com.test.todoapplication.fragment;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.test.todoapplication.R;
import com.test.todoapplication.model.TodoData;
import com.test.todoapplication.viewmodel.ToDoViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddToDoFragment extends Fragment {

    private ToDoViewModel mViewModel;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private Calendar calendar;



    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calendar = Calendar.getInstance();
        mViewModel = ViewModelProviders.of(this).get(ToDoViewModel.class);

        appCompatEditTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        appCompatEditTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker();
                }
            }
        });

        mViewModel.enteredTodo.setValue(appCompatEditTextTodo.getText().toString().trim());

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = appCompatEditTextTodo.getText().toString().trim();
                String date = appCompatEditTextDate.getText().toString().trim();
                if (todo.isEmpty() && date.isEmpty()) {
                    Toast.makeText(getActivity(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    //save to db
                    TodoData todoData = new TodoData();
                    todoData.setTodo(todo);
                    todoData.setDate(date);
                    todoData.setStatus("Pending");
                    mViewModel.insert(todoData);
                    Toast.makeText(getActivity(), "Saved todo successfully", Toast.LENGTH_SHORT).show();
                    appCompatEditTextTodo.setText("");
                    appCompatEditTextDate.setText("");
                }
            }
        });
    }


}
