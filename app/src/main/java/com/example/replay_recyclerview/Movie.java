package com.example.replay_recyclerview;

public class Movie {
    private String title,subtitle;
    private int picture;

    public Movie(String title, String subtitle, int picture) {
        this.title = title;
        this.subtitle = subtitle;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
