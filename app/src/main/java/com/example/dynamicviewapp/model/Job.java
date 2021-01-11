package com.example.dynamicviewapp.model;

import java.io.Serializable;

public class Job implements Serializable {

    private String profile;
    private String experience;

    public Job()
    {

    }
    public Job(String profile, String experience) {
        this.profile = profile;
        this.experience = experience;
    }

    public String getProfile() {
        return profile;
    }

    public String getExperience() {
        return experience;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
