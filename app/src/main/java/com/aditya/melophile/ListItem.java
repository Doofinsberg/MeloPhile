package com.aditya.melophile;

import android.widget.TextView;

import java.util.List;

public class ListItem {
    private String name;

    public ListItem(String name) {
        this.name = name;
    }

    public ListItem() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
