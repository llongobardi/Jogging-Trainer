package com.example.luca.firstprojectapp.Utilities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.example.luca.firstprojectapp.Fragments.ActivityFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;


/**
 * Created by MatteoOrzes on 27/05/2015.
 */
/*---------- Listener class to get coordinates ------------- */
public class MyLocationListener implements LocationListener {
    private PolylineOptions coordinates;
    private ActivityFragment builder;

    public MyLocationListener(PolylineOptions coordinates,ActivityFragment frag) {
        this.coordinates = coordinates;
        this.builder = frag;
    }

    @Override
    public void onLocationChanged(Location loc) {

        coordinates.add(new LatLng(loc.getLatitude(),loc.getLongitude()));
        builder.buildPath();



        /*------- To get city name from coordinates -------- */
        /*
        String cityName = null;
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);
            if (addresses.size() > 0)
                System.out.println(addresses.get(0).getLocality());
            cityName = addresses.get(0).getLocality();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
                + cityName;
        editLocation.setText(s);
        */
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}