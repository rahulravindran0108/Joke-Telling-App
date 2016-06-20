package com.rahulravindran.udacity.backend;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String text;

    public Joke(String text) {
        this.text = text;
    }

    public String getData() {
        return text;
    }

    public void setData(String data) {
        text = data;
    }
}