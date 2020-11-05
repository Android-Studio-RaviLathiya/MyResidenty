package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.residency.myresidency.R;

import java.util.List;
import java.util.Locale;

public class RSResidentInfoAddActivity extends AppCompatActivity implements LocationListener {

    EditText et_residencyname, et_area, et_city, et_state, et_county, et_pincode;
    Button btn_next;
    String residencyname, area, city, state, county, pincode;
    private ScrollView mScrollView;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_resident_info_add);

        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mScrollView.setSmoothScrollingEnabled(true);

        et_residencyname = findViewById(R.id.et_residencyname);
        et_area = findViewById(R.id.et_area);
        et_city = findViewById(R.id.et_city);
        et_state = findViewById(R.id.et_state);
        et_county = findViewById(R.id.et_county);
        et_pincode = findViewById(R.id.et_pincode);

        btn_next = findViewById(R.id.btn_next);

        residencyname = et_residencyname.getText().toString().trim();
        area = et_area.getText().toString().trim();
        city = et_city.getText().toString().trim();
        state = et_state.getText().toString().trim();
        county = et_county.getText().toString().trim();
        pincode = et_pincode.getText().toString().trim();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (residencyname.isEmpty()) {

                    et_residencyname.setError("");

                } else if (area.isEmpty()) {
                    et_area.setError("");

                } else if (city.isEmpty()) {
                    et_city.setError("");

                } else if (state.isEmpty()) {
                    et_state.setError("");

                } else if (county.isEmpty()) {
                    et_county.setError("");

                } else if (pincode.isEmpty()) {
                    et_pincode.setError("");

                } else {


                }


                startActivity(new Intent(RSResidentInfoAddActivity.this, RSPasnalInfoActivity.class));

            }
        });



//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(getApplicationContext(),
//                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
//                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
//
//        }


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationEnabled();
        getLocation();

    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(RSResidentInfoAddActivity.this)
                    .setTitle("Enable GPS Service")
                    .setMessage("We need your GPS location to show Near Places around you.")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            et_city.setText(addresses.get(0).getLocality());  //city
            et_state.setText(addresses.get(0).getAdminArea()); //state
            et_county.setText(addresses.get(0).getCountryName()); //country
            et_pincode.setText(addresses.get(0).getPostalCode()); //pincode


//            et_area.setText(addresses.get(0).getAddressLine(0));

        } catch (Exception e) {
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }




    public void back(View view) {
        onBackPressed();

    }
}
