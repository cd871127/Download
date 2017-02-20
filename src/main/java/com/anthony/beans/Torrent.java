package com.anthony.beans;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class Torrent {
    private String postPageUrl;
    private String title;
    private String downloadPageUrl;
    private String postPage;
    private String downloadPage;
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

    public String getDownloadPageUrl() {
        return downloadPageUrl;
    }

    public void setDownloadPageUrl(String downloadPageUrl) {
        this.downloadPageUrl = downloadPageUrl;
    }

    public String getPostPage() {
        return postPage;
    }

    public void setPostPage(String postPage) {
        this.postPage = postPage;
    }

    public String getDownloadPage() {
        return downloadPage;
    }

    public void setDownloadPage(String downloadPage) {
        this.downloadPage = downloadPage;
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
                ", downloadPageUrl='" + downloadPageUrl + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
