package marco.geo;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeometryTest {

    public static void main(String[] args) throws  Exception{
        WKTReader reader=new WKTReader();
        Geometry geometry=reader.read("POLYGON ((115.91428586897312 29.63966917951539, 115.9160155437924 29.638595273818755, 115.91458957641517 29.636874377544775, 115.91212648258335 29.638534535985062, 115.91219648730421 29.638637503163586, 115.91428586897312 29.63966917951539))");
                String geoJsonStr = "[";
        for (Coordinate coord : geometry.getCoordinates()) {
            geoJsonStr += "[" + coord.x + "," + coord.y + "],";
        }
//        geoJsonStr = geoJsonStr.substring(0, geoJsonStr.length() -1);
        geoJsonStr += "]";
        System.out.println(geoJsonStr);
        String geoStr = "POLYGON ((117.175633 31.549817, 117.177 31.549817, 117.177 31.549817, 117.178366 31.549817, 117.178366 31.549817, 117.179733 31.549817, 117.179733 31.549817, 117.179733 31.551184, 117.179733 31.551184, 117.179733 31.55255, 117.179733 31.55255, 117.179733 31.553917, 117.179733 31.553917, 117.1811 31.553917, 117.1811 31.553917, 117.1811 31.555284, 117.1811 31.555284, 117.1811 31.55665, 117.1811 31.55665, 117.1811 31.558017, 117.1811 31.558017, 117.1811 31.559384, 117.1811 31.559384, 117.179733 31.559384, 117.179733 31.559384, 117.179733 31.558017, 117.179733 31.558017, 117.179733 31.55665, 117.179733 31.55665, 117.178366 31.55665, 117.178366 31.55665, 117.178366 31.555284, 117.178366 31.555284, 117.178366 31.553917, 117.178366 31.553917, 117.178366 31.55255, 117.178366 31.55255, 117.178366 31.551184, 117.178366 31.551184, 117.177 31.551184, 117.177 31.551184, 117.175633 31.551184, 117.175633 31.551184, 117.175633 31.549817))";

//        System.out.println(getPOLYGONWktToJson(geoStr));
    }

//    public static String getPOLYGONWktToJson(String wkt) {
////        PolygonObject polygonObject = new PolygonObject();
//        List<List<Double[]>> lists = new ArrayList<>();
//        String ToTailWkt = wkt.substring(0, wkt.length() - 1);
//        String[] strHead = ToTailWkt.split("\\(", 2);
//        String[] strList = strHead[1].split("\\), \\(");
//        for (int i = 0; i < strList.length; i++) {
//            String item = strList[i].trim();
//            item = item.substring(1, item.length() - 1);
//            String[] items = item.split(",");
//            List<Double[]> list = new ArrayList<Double[]>();
//            for (int j = 0; j < items.length; j++) {
//                String jItem = items[j].trim();
//                String[] jItems = jItem.split(" ");
//                Double[] listResult = new Double[] {
//                        Double.parseDouble(jItems[0]),
//                        Double.parseDouble(jItems[1]) };
//                list.add(listResult);
//            }
//            lists.add(list);
//        }
//        String result = lists.stream().map(l -> l.).collect(Collectors.joining());
//        return result;
////        HashMap<String, Integer> spatialReference = new HashMap<String, Integer>();
////        spatialReference.put("wkid", wkid);
////        polygonObject.setRings(lists);
////        polygonObject.setSpatialReference(spatialReference);
////        Gson gson = new Gson();
////        return gson.toJson(polygonObject);
//    }

}
