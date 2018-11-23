package marco.geo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Circle2GeoHashTest {
    @Test
    public void testCircle2Geohash() {
        List<String> geohashList = Circle2GeoHash.getGeohashList(31.179859,121.604716, 100, 7);
        System.out.println(StringUtils.join(geohashList, ","));
        assertEquals(geohashList.size(), 2);
        assertEquals(geohashList.get(0), "wtw3rhj");


    }
}
