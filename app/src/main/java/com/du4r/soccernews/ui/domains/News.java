package com.du4r.soccernews.ui.domains;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class News {
    @PrimaryKey
    public int Id;

    @SerializedName("title")
    public String Title;
    @SerializedName("description")
    public String Description;
    @SerializedName("image")
    public String Image;
    @SerializedName("link")
    public String Link;
    public Boolean Favorite = false;


}

