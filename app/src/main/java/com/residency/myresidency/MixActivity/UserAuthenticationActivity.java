package com.residency.myresidency.MixActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnBackPressListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.residency.myresidency.AppInfo.AppInfoFourActivity;
import com.residency.myresidency.AppInfo.AppInfoOneActivity;
import com.residency.myresidency.AppInfo.AppInfoThreeActivity;
import com.residency.myresidency.AppInfo.AppInfoTwoActivity;
import com.residency.myresidency.R;
import com.residency.myresidency.ResidencySecretery.RSSinginActivity;
import com.residency.myresidency.WatchMan.DaynemicAdapter;
import com.residency.myresidency.WatchMan.DaynemicItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserAuthenticationActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    Button btn_residency_secretery, btn_resident_member;
    Animation topanim;
    TextView appinfotitle, change_language;
    ImageView logo;

    String checkedItem_string;
    int checkedItem_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);

        btn_residency_secretery = findViewById(R.id.btn_residency_secretery);
        btn_resident_member = findViewById(R.id.btn_resident_member);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        appinfotitle = findViewById(R.id.appinfotitle);
        logo = findViewById(R.id.logo);
        change_language = findViewById(R.id.change_language);
        loadLocal();


        /*ANIMATION*/
        topanim = AnimationUtils.loadAnimation(UserAuthenticationActivity.this, R.anim.top_animations);
        btn_residency_secretery.setAnimation(topanim);
        btn_resident_member.setAnimation(topanim);
        appinfotitle.setAnimation(topanim);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setVisibility(View.VISIBLE);
                appinfotitle.setVisibility(View.GONE);
                logo.setVisibility(View.GONE);
            }
        }, 1000);

        /*BTN CLICK*/

        btn_residency_secretery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAuthenticationActivity.this, RSSinginActivity.class);
                startActivity(intent);

            }
        });


        btn_resident_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAuthenticationActivity.this, AllSigninActivity.class);
                startActivity(intent);

            }
        });

        change_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkedItem_string = MyPrefrence.getSelected_Language();
                checkedItem_int = Integer.parseInt(checkedItem_string);

                showchangelaunguse();

//                topdialog();
            }
        });

        /*view pager and docs*/
        setupViewPager(viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        viewPager.setAdapter(adapter);
        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    /*view pager*/
    private void setupViewPager(ViewPager viewPager) {


        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AppInfoOneActivity(), "");
        adapter.addFragment(new AppInfoTwoActivity(), "");
        adapter.addFragment(new AppInfoThreeActivity(), "");
        adapter.addFragment(new AppInfoFourActivity(), "");
        viewPager.setAdapter(adapter);
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

    /*backpress*/
    boolean staus = false;

    @Override
    public void onBackPressed() {

        if (staus) {
//            super.onBackPressed();


        } else {
            ActivityCompat.finishAffinity(UserAuthenticationActivity.this);


//            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please press again to exit", Snackbar.LENGTH_LONG);
//            snackbar.show();
//            staus = true;
        }

    }


    /*change launguse*/
    private void showchangelaunguse() {


        AlertDialog.Builder builder = new AlertDialog.Builder(UserAuthenticationActivity.this);
        builder.setTitle("Choose Language...");

        final String[] listItems = {"English", "हिंदी", "ગુજરતી"};

        builder.setSingleChoiceItems(listItems, checkedItem_int, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if (i == 0) {
                    setLocate("en");
                    MyPrefrence.setSelected_Language("0");
                } else if (i == 1) {
                    setLocate("hi");
                    MyPrefrence.setSelected_Language("1");

                } else if (i == 2) {
                    setLocate("gu");
                    MyPrefrence.setSelected_Language("2");

                }

            }
        });
        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                // user clicked OK

                startActivity(new Intent(UserAuthenticationActivity.this, UserAuthenticationActivity.class));
                dialog.dismiss();


            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void setLocate(String lang) {


        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration conf = new Configuration();
        conf.locale = locale;
        getBaseContext().getResources().updateConfiguration(conf, getBaseContext().getResources().getDisplayMetrics());


//        MyPrefrence.setLanguage(lang);
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();


    }

    public void loadLocal() {

        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocate(language);

    }


}