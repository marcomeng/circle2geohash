package marco.geo.util;

import java.util.ArrayList;
import java.util.List;

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


}
