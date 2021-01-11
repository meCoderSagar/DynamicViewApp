package com.example.dynamicviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dynamicviewapp.adapter.JobAdapter;
import com.example.dynamicviewapp.model.Job;

import java.util.ArrayList;

public class DataShowActivity extends AppCompatActivity {

    TextView name, education;
    String mname,meducation;
    RecyclerView recyclerView;
    ArrayList<Job> jobs = new ArrayList<Job>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        name = findViewById(R.id.tvname);
        education = findViewById(R.id.tveducation);
        recyclerView = findViewById(R.id.recyclerview);
        mname = (String) getIntent().getExtras().getString("name");
        meducation = (String) getIntent().getExtras().getString("education");
        name.setText(mname);
        education.setText(meducation);
        jobs = (ArrayList<Job>) getIntent().getExtras().getSerializable("joblist");

        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        JobAdapter jobAdapter = new JobAdapter(this,jobs);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(jobAdapter);



    }
}