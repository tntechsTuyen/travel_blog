package com.travel.app.common.utils;

public class LocationUtils {

    public static Double distance(Double lat1, Double lon1, Double lat2, Double lon2){
        Double R = 6371.0;
        Double dLat = deg2rad(lat2 - lat1);
        Double dLon = deg2rad(lon2 - lon1);
        Double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public static Double deg2rad(Double deg){
        return deg * (Math.PI/180);
    }
}
