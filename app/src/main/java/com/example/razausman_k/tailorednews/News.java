package com.example.razausman_k.tailorednews;

public class News {

    private String Title ;
    private String News ;
    private String PictureURL ;
    private String URL ;
    private String Content ;


    News(String title , String news, String pictureURL , String content , String url )
    {
        Title = title ;
        News = news ;
        PictureURL = pictureURL ;
        Content = content ;
        URL = url ;
    }
    public String getNews() {
        return News;
    }

    public void setNews(String news) {
        News = news;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPictureURL() {
        return PictureURL;
    }

    public void setPictureURL(String pictureURL) {
        PictureURL = pictureURL;
    }

    public String getContent() {
        return Content;
    }

    public String getURL() {
        return URL;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
