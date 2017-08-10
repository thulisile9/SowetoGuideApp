package com.example.android.sowetoguideapp;

/**
 * Created by Admin on 8/3/2017.
 */

public class Tour {
    private String description;
    private String head;
    private String photoUrl;



    public Tour(String head, String description, String photoUrl) {
        this.description = description;
        this.head = head;
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }


    public String getHead() {
        return head;
    }






    public Tour(String head, String description) {
      this.description = description;
      this.head = head;
    }

    public Tour() {

    }

    public String getPhotoUrl() {
        return photoUrl;
    }


}


