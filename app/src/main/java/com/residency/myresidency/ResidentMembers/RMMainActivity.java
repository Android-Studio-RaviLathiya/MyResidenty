package com.residency.myresidency.ResidentMembers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.residency.myresidency.AppInfo.AppInfoFourActivity;
import com.residency.myresidency.AppInfo.AppInfoOneActivity;
import com.residency.myresidency.AppInfo.AppInfoThreeActivity;
import com.residency.myresidency.AppInfo.AppInfoTwoActivity;
import com.residency.myresidency.MixActivity.UserAuthenticationActivity;
import com.residency.myresidency.R;

import java.util.ArrayList;
import java.util.List;

public class RMMainActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolbar_layout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPagers;

    private int[] tabIcons = {
            R.drawable.flat,
            R.drawable.ic_arrow_back_black_24dp,
            R.drawable.ic_date_range_black_24dp,
            R.drawable.bungalow
    };


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        toolbar_layout.setTitle("Name");


        viewPagers = (ViewPager) findViewById(R.id.viewpagers);
        setupViewPager(viewPagers);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagers);
        setupTabIcons();


    }

    private void setupViewPager(ViewPager viewPagers) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AppInfoFourActivity(), "Balance");
        adapter.addFragment(new AppInfoTwoActivity(), "Expence");
        adapter.addFragment(new AppInfoThreeActivity(), "Announce");
        adapter.addFragment(new AppInfoFourActivity(), "Complain");
        viewPagers.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}



