package com.xtha.zujal.testapplication;

import com.google.gson.annotations.SerializedName;

public class ResultModel
{
    @SerializedName("id")
    private int id;
    @SerializedName("body")
    private String body;
    @SerializedName("title")
    private String title;
    @SerializedName("userId")
    private String userId;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", body = "+body+", title = "+title+", userId = "+userId+"]";
    }
}
