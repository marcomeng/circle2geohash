package marco.geo;

import ch.hsr.geohash.GeoHash;
import marco.geo.util.GeoUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class Circle2GeoHash {

    private static final double EARTH_RADIUS_METERS = 6371000.0;

    public static List<String> getGeohashList(double latitude, double longitude, double radius, int precision) {
        List<String> geoHashList = new ArrayList<String>();
        List<List<Double>> centrePointList = new ArrayList<List<Double>>();
        double x = 0.0;
        double y = 0.0;

        double[] gridWidthArray = {5009400.0, 1252300.0, 156500.0, 39100.0, 4900.0, 1200.0, 152.9, 38.2, 4.8, 1.2, 0.149, 0.0370};
        double[] gridHeightArray = {4992600.0, 624100.0, 156000.0, 19500.0, 4900.0, 609.4, 152.4, 19.0, 4.8, 0.595, 0.149, 0.0199};
        double gridHeight = (gridHeightArray[precision -1]) /2;
        double gridWidth = (gridWidthArray[precision -1]) /2;

        int latCell = (int)Math.ceil(radius / gridHeight);
        int lonCell = (int)Math.ceil(radius / gridWidth);

        List<List<Double>> points = new ArrayList<>();

        for (int i =0; i < latCell; i ++) {
            double tempY = y + gridHeight * i;
            for (int j =0; j < lonCell; j ++) {
                double tempX = x + gridWidth * j;
                if (GeoUtil.isInCircle(tempY, tempX, y, x, radius)) {
                    double centreX = tempX + gridWidth / 2;
                    double centreY = tempY + gridHeight /2;
                    List<Double> latLonTuple = GeoUtil.convert2LatLon(centreY, centreX, latitude, longitude);
                    points.add(latLonTuple);
                    List<Double> latLonTuple2 = GeoUtil.convert2LatLon(-centreY, centreX, latitude, longitude);
                    points.add(latLonTuple2);
                    List<Double> latLonTuple3 = GeoUtil.convert2LatLon(centreY, -centreX, latitude, longitude);
                    points.add(latLonTuple3);
                    List<Double> latLonTuple4 = GeoUtil.convert2LatLon(-centreY, -centreX, latitude, longitude);
                    points.add(latLonTuple4);


                }
            }

        }
        for (List<Double> point : points) {
            GeoHash geoHash = GeoHash.withCharacterPrecision(point.get(0), point.get(1), precision);
            geoHashList.add(geoHash.toBase32());

        }


        return geoHashList.stream().distinct().collect(Collectors.toList());
    }


}
