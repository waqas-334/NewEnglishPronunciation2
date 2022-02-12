package com.androidbull.mypronounce;

/**
 * Created by Lincoln on 18/05/16.
 */
public class RowItem {
    private String name;
    private String lesson;

    public RowItem() {
    }

    public RowItem(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLesson() {
        return lesson;
    }

    public void setName(String name) {
        this.name = name;
    }

}
