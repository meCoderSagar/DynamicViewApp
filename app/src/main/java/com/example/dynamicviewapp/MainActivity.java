package com.example.dynamicviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dynamicviewapp.model.Job;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutlist;
    String name,education;
    EditText etname;
    Button btnadd, btnremove, btnsubmit;
    Spinner spinneredu;
    List<String> educationlist;
    List<View> removelist = new ArrayList<View>();;
    ArrayList<Job> jobs = new ArrayList<Job>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.etname);
        layoutlist = findViewById(R.id.layout_list);
        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);
        btnsubmit = findViewById(R.id.btnsubmit);
        spinneredu = findViewById(R.id.spinnereducation);

        
        setspinneredu();
        addView();
        btnadd.setOnClickListener(this);
        btnremove.setOnClickListener(this);
        btnsubmit.setOnClickListener(this);
    }

    public void setspinneredu()
    {
        educationlist = new ArrayList<String>();
        educationlist.add("Select Education");
        educationlist.add("No formal education");
        educationlist.add("Primary Education");
        educationlist.add("Secondary Education");
        educationlist.add("Bachelor's Degree");
        educationlist.add("Master's Degree");
        educationlist.add("Doctorate or higher");

        ArrayAdapter arrayAdapter =new ArrayAdapter(this, android.R.layout.simple_spinner_item,educationlist);
        spinneredu.setAdapter(arrayAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnadd:
                addView();
                break;
            case R.id.btnremove:
                removeListView();
                break;
            case R.id.btnsubmit:
                if(checkAndRead())
                {
                    Intent showdata = new Intent(MainActivity.this,DataShowActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("education",education);
                    bundle.putSerializable("joblist", jobs);
                    showdata.putExtras(bundle);
                    startActivity(showdata);
                }
                else {
                    Toast.makeText(this, "Please Fill Form Properly", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    private Boolean checkAndRead() {
        jobs.clear();
        Boolean result = true;
        if (!etname.getText().toString().trim().equals(""))
        {
            name = etname.getText().toString().trim();
            if (spinneredu.getSelectedItemPosition()!=0)
            {
                education=educationlist.get(spinneredu.getSelectedItemPosition());
                for (int i=0; i<layoutlist.getChildCount();i++)
                {
                    View jobview = layoutlist.getChildAt(i);
                    EditText etprofile = jobview.findViewById(R.id.etprofile);
                    EditText etexp = jobview.findViewById(R.id.etexp);

                    Job job = new Job();
                    if (!etprofile.getText().toString().trim().equals(""))
                    {
                        job.setProfile(etprofile.getText().toString().trim());

                    }else {
                        return false;
                    }
                    if (!etexp.getText().toString().trim().equals(""))
                    {
                        job.setExperience(etexp.getText().toString().trim());

                    }else {
                        return false;
                    }
                    jobs.add(job);
                }

            }else {
                return false;
            }
        }else {
            return false;
        }


        return result;
    }

    private void removeListView() {
        int count = layoutlist.getChildCount();
        removelist.clear();
        for(int i=0;i<count;i++){
            View jobview = layoutlist.getChildAt(i);
            CheckBox cbselect = jobview.findViewById(R.id.cbselect);
            if(cbselect.isChecked())
            {
                removelist.add(jobview);
            }
        }
        removeView();
    }

    private void addView() {
        View jobview = getLayoutInflater().inflate(R.layout.row_experience_add,null,false);

        layoutlist.addView(jobview);

    }

    private void removeView(){
        for (View view:removelist){
            layoutlist.removeView(view);
        }
    }
}