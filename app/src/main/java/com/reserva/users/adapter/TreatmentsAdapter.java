package com.reserva.users.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.reserva.users.BodyCareFragment;
import com.reserva.users.HairCareFragment;
import com.reserva.users.Treatment;

import java.util.ArrayList;
import java.util.List;

public class TreatmentsAdapter extends FragmentPagerAdapter {
    private Treatment myContext;
    int totalTabs;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    public TreatmentsAdapter(Treatment context, FragmentManager fragmentManager, int totalTabs) {
        super(fragmentManager);

        myContext = context;
        this.totalTabs = totalTabs;
    }
    public void addFragment(Fragment HairCareFragment, String title) {
        mFragmentList.add(HairCareFragment);
        mFragmentTitleList.add(title);
    }




    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HairCareFragment hairCareFragment = new HairCareFragment();

                return hairCareFragment;
            case 1:
                BodyCareFragment bodyCareFragment = new BodyCareFragment();
                return bodyCareFragment;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return totalTabs;
    }

}
