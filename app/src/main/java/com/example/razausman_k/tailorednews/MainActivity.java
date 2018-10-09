package com.example.razausman_k.tailorednews;

import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    NewsCustomAdapter adapter;
    SearchView searchView;
    public static List<News> NewsData ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchView =findViewById(R.id.searchView);
        searchView.setQueryHint("Search Here");
        searchView.setIconifiedByDefault(false);
        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder , new SearchFragment(query) ).commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.FragmentPlaceHolder, new FirstFragment()).commit();
                return false ;
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.FragmentPlaceHolder, new FirstFragment()).commit();


        TextView GeneralTextView = (TextView) findViewById(R.id.General);
        TextView SportsTextView = (TextView) findViewById(R.id.Sports);
        TextView BusinessTextView = (TextView) findViewById(R.id.Business);
        TextView EntertainmentTextView = (TextView) findViewById(R.id.Entertainment);
        TextView TechnologyTextView = (TextView) findViewById(R.id.Technology);
        TextView ScienceTextView = (TextView) findViewById(R.id.Science);
        TextView HealthTextView = (TextView) findViewById(R.id.Health);

        GeneralTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new FirstFragment() ).commit();
            }
        });

        SportsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new SportsFragment()).commit();
            }
        });

        BusinessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new BusinessFragment() ).commit();
            }
        });

        EntertainmentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new EntertainmentFragment()).commit();
            }
        });

        TechnologyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new TechnologyFragment()).commit();
            }
        });

        ScienceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new ScienceFragment()).commit();
            }
        });

        HealthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.FragmentPlaceHolder, new HealthFragment()).commit();
            }
        });

    }






}
