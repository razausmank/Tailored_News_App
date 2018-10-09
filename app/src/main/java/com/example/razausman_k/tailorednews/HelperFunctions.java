package com.example.razausman_k.tailorednews;

import android.util.Log;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HelperFunctions {

    private HelperFunctions()
    { }

    public static List<News> fetchNewsData (String API_URL )
    {
        List<News> News = new ArrayList<>() ;

        URL url = null ;

        try {
            url = new URL( API_URL );
        } catch (MalformedURLException e) {
        }

        String jsonResponse = null ;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
           e.printStackTrace();
        }


        News = extractDataFromJson(jsonResponse);

        return News ;
    }

    public static String makeHttpRequest( URL url ) throws IOException {
        String jsonResponse = "" ;

        if (url == null)
        {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null ;
        InputStream inputStream = null ;

        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);
        urlConnection.setConnectTimeout(10000);
        urlConnection.connect();

        StringBuilder stringBuilder = new StringBuilder() ;
        if (urlConnection.getResponseCode() == 200)
        {
            inputStream = urlConnection.getInputStream();

            if( inputStream != null )
            {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String Line = reader.readLine();

                while ( Line != null )
                {
                    stringBuilder.append(Line);
                    Line = reader.readLine();
                }

                jsonResponse = stringBuilder.toString();
            }


        }

        return jsonResponse;
    }

    public  static List<News> extractDataFromJson (String jsonResponse ) {
        ArrayList<News> News = new ArrayList<>();

        try {


            JSONObject rootJsonResponse = new JSONObject(jsonResponse);
            JSONArray articlesArray = rootJsonResponse.getJSONArray("articles");

            for (int i = 0; i < articlesArray.length(); i++) {
                JSONObject currentArticle = articlesArray.getJSONObject(i);

                String Title = currentArticle.getString("title");
                String Description = currentArticle.getString("description");
                String PictureURL = currentArticle.getString("urlToImage");
                String Content = currentArticle.getString("content");
                String URL = currentArticle.getString("url");

                News.add(new News(Title, Description,PictureURL,Content,URL));
            }
        }
        catch (JSONException e)
        {

            e.printStackTrace();
        }
        return  News ;
    }


}
