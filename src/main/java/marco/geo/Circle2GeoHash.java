package marco.geo;

import ch.hsr.geohash.GeoHash;
import marco.geo.util.GeoUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Circle2GeoHash {

    public static List<String> getGeohashList(double latitude, double longitude, double radius, int precision) {
        List<String> geoHashList = new ArrayList<String>();
        List<List<Double>> centrePointList = new ArrayList<List<Double>>();
        double x = 0.0;
        double y = 0.0;

        double[] gridWidthArray = {5009400.0, 1252300.0, 156500.0, 39100.0, 4900.0, 1200.0, 152.9, 38.2, 4.8, 1.2, 0.149, 0.0370};
        double[] gridHeightArray = {4992600.0, 624100.0, 156000.0, 19500.0, 4900.0, 609.4, 152.4, 19.0, 4.8, 0.595, 0.149, 0.0199};
        double gridHeight = (gridHeightArray[precision -1]) /2;
        double gridWidth = (gridWidthArray[precision -1]) /2;

        int latCell = (int)(radius / gridHeight);
        int lonCell = (int)(radius / gridWidth);

        for (int i =0; i <= latCell; i ++) {
            double tempY = y + gridHeight * i;
            for (int j =0; j <= lonCell; j ++) {
                double tempX = x + gridWidth * j;
                if (GeoUtil.isInCircle(tempY, tempX, y, x, radius)) {
                    double centreX = tempX + lonCell / 2;
                    double centreY = tempY + latCell /2;
                    List<Double> latLonTuple = GeoUtil.convert2LatLon(centreY, centreX, latitude, longitude);
                    GeoHash geoHash = GeoHash.withCharacterPrecision(latLonTuple.get(0), latLonTuple.get(1), precision);
                    geoHashList.add(geoHash.toBase32());

                }
            }

        }


        return geoHashList.stream().distinct().collect(Collectors.toList());
    }
}
