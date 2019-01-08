# circle2geohash
Get geohash list from a circle. 获得圆形里的geohash

Example:

        List<String> geohashList = Circle2GeoHash.getGeohashList(31.179859,121.604716, 100, 7);
        System.out.println(StringUtils.join(geohashList, ","));
        assertEquals(geohashList.size(), 2);
        assertEquals(geohashList.get(0), "wtw3rhj");

Steps:
1. Caculate how many cells in the MBR.
2. For each cell, check if it's in the circle.
3. Caculate the centre lat lon if the cell in the circle.
4. Convert the latlon to geohash and deduplicate.
