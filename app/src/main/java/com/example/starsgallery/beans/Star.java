package com.example.starsgallery.beans;

public class Star {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int thumbnail;
    private float rating;

    public Star(String name, int thumbnail, float rating) {
        this.id = ++idCounter;
        this.name = name;
        this.thumbnail = thumbnail;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " - " + rating + " ⭐";
    }
}