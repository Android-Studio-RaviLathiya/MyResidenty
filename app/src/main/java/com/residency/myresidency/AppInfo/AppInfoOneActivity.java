package com.residency.myresidency.AppInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.residency.myresidency.R;

public class AppInfoOneActivity extends Fragment {

    ImageView logo;
    TextView appinfotitle_one;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public AppInfoOneActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_appinfo_one, container, false);

        logo = view.findViewById(R.id.logo);
        appinfotitle_one = view.findViewById(R.id.appinfotitle_one);

        return view;
    }
}
