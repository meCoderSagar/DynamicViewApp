package com.example.dynamicviewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dynamicviewapp.R;
import com.example.dynamicviewapp.model.Job;

import java.util.List;



public class JobAdapter extends RecyclerView.Adapter<JobViewHolder> {

    Context context;
    List<Job> jobs;

    public JobAdapter(Context context, List<Job> jobs) {
        this.context = context;
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_experience_show,parent,false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.tvprofile.setText(jobs.get(position).getProfile());
        holder.tvexp.setText(jobs.get(position).getExperience());

    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}
