package com.materialdoc.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChildItem {

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("image")
    public String image;

    @SerializedName("itemsArr")
    public List<ChildItem> mParentItemList;
}