package com.du4r.soccernews.ui.domains;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("title")
    public String Title;
    @SerializedName("description")
    public String Description;
    @SerializedName("image")
    public String Image;
    @SerializedName("link")
    public String Link;

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setLink(String link) {
        this.Link = link;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getImage() {
        return Image;
    }

    public String getLink() {
        return Link;
    }

}

