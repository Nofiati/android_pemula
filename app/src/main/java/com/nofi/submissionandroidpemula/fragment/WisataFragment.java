package com.nofi.submissionandroidpemula.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.adapter.tablayout.TabAdapter;

public class WisataFragment extends Fragment {

    public WisataFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wisata_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = view.findViewById(R.id.tab);

        ViewPager viewPager = view.findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabAdapter(getChildFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);
    }
}
