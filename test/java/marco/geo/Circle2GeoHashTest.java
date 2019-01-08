package marco.geo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Circle2GeoHashTest {
    @Test
    public void testCircle2Geohash() {
        List<String> geohashList = Circle2GeoHash.getGeohashList(31.187586,121.687288, 200, 7);
        System.out.println(StringUtils.join(geohashList, ","));
        assertEquals(geohashList.size(), 3);
        assertEquals(geohashList.get(0), "wtw90mp");


    }
}
