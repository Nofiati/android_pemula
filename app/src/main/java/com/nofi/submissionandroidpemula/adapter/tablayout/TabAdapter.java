package com.nofi.submissionandroidpemula.adapter.tablayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nofi.submissionandroidpemula.fragment.WisataKudusFragment;
import com.nofi.submissionandroidpemula.fragment.KulinerKudusFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new WisataKudusFragment();
        }
        return new KulinerKudusFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Wisata";
        }
        return "Kuliner";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
