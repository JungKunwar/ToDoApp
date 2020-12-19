package com.test.todoapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.test.todoapplication.R;
import com.test.todoapplication.fragment.AddToDoFragment;
import com.test.todoapplication.fragment.ToDoListFragment;
import com.test.todoapplication.adapter.SectionsPagerAdapter;
import com.test.todoapplication.viewmodel.ToDoViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments = new ArrayList<>();

   Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragments.clear();
        fragments.add(new AddToDoFragment());
        fragments.add(new ToDoListFragment());





    }


}