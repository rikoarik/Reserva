package com.reserva.users;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.reserva.R;
import com.reserva.users.adapter.TreatmentsAdapter;

public class Treatment extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Hair Care"));
        tabLayout.addTab(tabLayout.newTab().setText("Body Care"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final TreatmentsAdapter adapter = new TreatmentsAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        adapter.addFragment(new HairCareFragment(), "Hair Care");
        adapter.addFragment(new BodyCareFragment(), "Body Care");
        viewPager.setAdapter(adapter);





        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

}