package com.example.dynamicviewapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dynamicviewapp.R;

public class JobViewHolder extends RecyclerView.ViewHolder {

    TextView tvprofile, tvexp;

    public JobViewHolder(@NonNull View itemView) {
        super(itemView);
        tvprofile = itemView.findViewById(R.id.tvprofile);
        tvexp = itemView.findViewById(R.id.tvexp);
    }
}
