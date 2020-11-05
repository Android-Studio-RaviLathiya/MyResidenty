package com.residency.myresidency.AppInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.residency.myresidency.R;

public class AppInfoThreeActivity extends Fragment {

    ImageView logo;
    TextView text_one, text_two;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public AppInfoThreeActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_appinfo_three, container, false);

        logo = view.findViewById(R.id.logo);
        text_one = view.findViewById(R.id.text_one);
        text_two = view.findViewById(R.id.text_two);

        return view;
    }

}

