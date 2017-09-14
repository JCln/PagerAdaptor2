package com.sbm.user.pageradaptor;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdaptor myadaptor;
    ArrayList<PageWrapper> countries = new ArrayList<>();
    MyAsynctask ma;
    ViewPager viewpager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager= (ViewPager) findViewById(R.id.viewpager);
       // viewpager.setAdapter(myadaptor);
        ma= new MyAsynctask();
        ma.execute();
    }
    private void initializeCountry() {
        PageWrapper iran = new PageWrapper();
        PageWrapper germany = new PageWrapper();
        PageWrapper england = new PageWrapper();
        nameCountries(iran , germany , england);
    }
    private void nameCountries(PageWrapper iran , PageWrapper germany , PageWrapper england) {
        iran.county = "iran";
        iran.capital = "Tehran";
        iran.imageId = R.drawable.imagesiran;

        germany.county = "Germany";
        germany.capital = "Berlin";
        germany.imageId = R.drawable.imagesgermany;

        england.county = "england";
        england.capital = "London";
        england.imageId = R.drawable.imagesengland;

        countries.add(iran);
        countries.add(germany);
        countries.add(england);
    }
    private void addExtra() {
        for (int i = 1; i <= 5000; i++) {
            PageWrapper fictionCountry = new PageWrapper();
            countries.add(fictionCountry);
            countryFictions(fictionCountry , i);
            SystemClock.sleep(0);
        }
    }
    private void countryFictions(PageWrapper fictionCountry , int i){
        fictionCountry.county = "fictionCountry" + "  " + i;
        fictionCountry.capital = "fictionCapital" + "   " + i;
        fictionCountry.imageId = R.drawable.imagesengland;
    }
    private class MyAsynctask extends AsyncTask<String,Integer,String > {
        LinearLayout lnprogressbar = (LinearLayout) findViewById(R.id.progressbar);

        @Override
        protected String doInBackground(String... params) {
            //Debug.waitForDebugger();
            initializeCountry();
            addExtra();
            myadaptor = new MyAdaptor(getSupportFragmentManager(), countries);
            return null;
        }
        @Override
        protected void onPreExecute() {
            lnprogressbar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String aVoid) {
            lnprogressbar.setVisibility(View.GONE);
            viewpager.setAdapter(myadaptor);
        }
    }
}
