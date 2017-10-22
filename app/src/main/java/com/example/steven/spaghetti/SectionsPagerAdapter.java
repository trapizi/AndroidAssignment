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
                QuizSelectionFragment tab2 = new QuizSelectionFragment();
                return tab2;

            case 3:
                RankingFragment tab3 = new RankingFragment();
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
                return "LEADERBOARD";

        }
        return null;
    }
}
