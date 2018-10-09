package com.example.razausman_k.tailorednews;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TechnologyFragment extends Fragment {
    ListView listView ;
    NewsCustomAdapter adapter;

    public TechnologyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TechnologyFragment.NewsAsyncTask newsAsyncTask = new TechnologyFragment.NewsAsyncTask();
        newsAsyncTask.execute() ;

        listView = (ListView) view.findViewById(R.id.NewsListView);
        adapter = new NewsCustomAdapter(getActivity(), new ArrayList<News>());
        listView.setAdapter(adapter);

        return view ;

    }

    public class NewsAsyncTask extends AsyncTask<Void , Void , List<News>>
    {
        @Override
        protected List<News> doInBackground(Void... voids) {
            List<News> News = HelperFunctions.fetchNewsData("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=81d6974107fa425e9f86766cab89b964");
            return News ;
        }

        @Override
        protected void onPostExecute(List<News> news) {
            adapter.clear();
            adapter.addAll(news);
        }
    }
}