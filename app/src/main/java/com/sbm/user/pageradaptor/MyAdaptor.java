package com.sbm.user.pageradaptor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
// ...
    public class MyAdaptor extends FragmentStatePagerAdapter {
        ArrayList<PageWrapper> countries= new ArrayList();
        int mCount;

        public MyAdaptor(FragmentManager fm, ArrayList<PageWrapper> countries) {
            super(fm);
            this.countries = countries;
         }
        @Override
        public int getCount() {
            //notifyDataSetChanged();
          mCount=countries.size();
            return mCount;
        }
        public Fragment getItem(int ps) {
            return Firstfragment.newInstance(countries.get(ps));
        }
    }

