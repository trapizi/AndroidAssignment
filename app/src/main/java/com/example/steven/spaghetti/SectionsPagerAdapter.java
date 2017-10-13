package com.example.steven.spaghetti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                classroom_feeds tab1 = new classroom_feeds();
                return tab1;

            case 1:
                fragment_quiz tab2 = new fragment_quiz();
                return tab2;

            case 3:
                fragment_chat tab3 = new fragment_chat();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "CLASSROOM FEEDS";
            case 1:
                return "QUIZ";
            case 2:
                return "CHAT ROOM";

        }
        return null;
    }
}
