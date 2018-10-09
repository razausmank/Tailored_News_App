package com.example.razausman_k.tailorednews;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.ContactsContract;
import android.renderscript.ScriptGroup;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class NewsCustomAdapter extends ArrayAdapter<News> {
    Boolean state = true ;
    public InputStream inputStream ;
    public NewsCustomAdapter(@NonNull Context context, List<News> News) {
        super(context, 0, News);
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        View listItemView = convertView ;
        if ( listItemView == null )
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_custom_listview,parent, false);
        }

        final News currentNews = getItem(position);
        final Button button = (Button) listItemView.findViewById(R.id.SeeMoreButton);
        TextView NewsTitle = listItemView.findViewById(R.id.NewsTitle);

        final TextView News  = listItemView.findViewById(R.id.News);
        final TextView Content = listItemView.findViewById(R.id.content);
        final TextView URL = listItemView.findViewById(R.id.url);

        button.setBackgroundColor(Color.TRANSPARENT) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == true )
                {

                    Content.setText(currentNews.getContent());
                    Content.setVisibility(View.VISIBLE);
                    URL.setText("Read More Here");
                    URL.setVisibility(View.VISIBLE);
                    button.setText("See Less");
                    News.setVisibility(View.GONE);
                    state = false ;

                }
                else if(state == false )
                {
                    state = true ;
                    Content.setVisibility(View.GONE);
                    URL.setVisibility(View.GONE);
                    button.setText("See More");
                    News.setVisibility(view.VISIBLE);

                }

            }
        });

        URL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentNews.getURL()));
                getContext().startActivity(intent);
            }
        });

        Button shareButton = listItemView.findViewById(R.id.Whatsapp);
        shareButton.setBackgroundColor(Color.TRANSPARENT) ;

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.putExtra(Intent.EXTRA_TEXT, currentNews.getURL());
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.whatsapp");
                sendIntent.setType("text/plain");
                getContext().startActivity(sendIntent);
            }
        });
            ImageView imageView = listItemView.findViewById(R.id.NewsPicture);
            final String url = currentNews.getPictureURL();

        Glide.with(getContext()).load(url).into(imageView);


        NewsTitle.setText(currentNews.getTitle());

        News.setText(currentNews.getNews());



        return listItemView ;
    }


}
