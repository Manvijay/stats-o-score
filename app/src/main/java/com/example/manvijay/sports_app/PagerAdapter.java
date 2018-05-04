package com.example.manvijay.sports_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: TestRankings epl= new TestRankings();
                    return epl;
            case 1: ODIRankings laliga= new ODIRankings();
                    return laliga;
            case 2: T20Rankings bundesliga= new T20Rankings();
                    return bundesliga;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
