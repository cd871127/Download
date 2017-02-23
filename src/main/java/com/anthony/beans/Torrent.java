package com.anthony.beans;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class Torrent {
    private String postPageUrl;
    private String title;
    private String rmdownUrl;
    private String rmdownPage;
    private String postPage;
    private String downloadUrl;

    public String getPostPageUrl() {
        return postPageUrl;
    }

    public void setPostPageUrl(String postPageUrl) {
        this.postPageUrl = postPageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRmdownUrl() {
        return rmdownUrl;
    }

    public void setRmdownUrl(String rmdownUrl) {
        this.rmdownUrl = rmdownUrl;
    }

    public String getRmdownPage() {
        return rmdownPage;
    }

    public void setRmdownPage(String rmdownPage) {
        this.rmdownPage = rmdownPage;
    }

    public String getPostPage() {
        return postPage;
    }

    public void setPostPage(String postPage) {
        this.postPage = postPage;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "Torrent{" +
                "postPageUrl='" + postPageUrl + '\'' +
                ", title='" + title + '\'' +
                ", rmdownUrl='" + rmdownUrl + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
