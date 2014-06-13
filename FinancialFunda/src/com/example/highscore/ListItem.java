package com.example.highscore;

public class ListItem {

    public int itemId;
    public String itemName;
    public int ratingValue;

    // constructor
    public ListItem(String itemName,int ratingValue) {
       // this.itemId = itemId;
        this.itemName = itemName;
        this.ratingValue=ratingValue;
    }

}
