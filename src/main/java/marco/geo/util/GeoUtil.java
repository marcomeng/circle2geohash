package marco.geo.util;

import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeoUtil {

    public static boolean isInCircle(double x, double y, double centreX, double centreY, double radius) {
        double xDiff = x - centreX;
        double yDiff = y - centreY;
        return (Math.pow(xDiff, 2) + Math.pow(yDiff,2)) <= Math.pow(radius, 2);
    }

    public static List<Double> convert2LatLon(double y, double x, double latitude, double longitude) {
        int earchRadius = 6371000;
        double latDiff = (y / earchRadius) * (180 / Math.PI);
        double lonDiff = (x / earchRadius) * (180 / Math.PI) / Math.cos(latitude * Math.PI / 180);
        List<Double> latLonList = new ArrayList<Double>();
        latLonList.add(latitude + latDiff);
        latLonList.add(longitude + lonDiff);
        return latLonList;
    }

    public List<String> compressGeoHashs(List<String> geoHashList, int minLevel, int maxLevel) {
        if (geoHashList.size() == 0)
            return geoHashList;
        List<String> finalGeoHashList = new ArrayList<>();
        boolean continueCompress = true;

        Set<String> delSet = new HashSet<>();
        Set<String> ghSet = new HashSet<>();

        while (continueCompress) {
            delSet.clear();
            ghSet.clear();
            for (String geoHash : geoHashList) {
                if (geoHash.length() >= minLevel) {

                }
            }
        }

        return finalGeoHashList;
    }


}
