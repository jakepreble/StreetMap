import bridges.base.Color;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.OsmData;
import bridges.validation.RateLimitException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, RateLimitException {
        // remember to fill in your own assignment number, username, and api key
        System.out.print("test0");
        Bridges bridges = new Bridges(2, "jpreble", "250600616660");
        bridges.setTitle("Shortest path");
        bridges.setDescription("Shortest path across New York City (created with data from OpenStreetMaps)");

        // get NYC map from bridges data server
        DataSource ds = bridges.getDataSource();
        OsmData data = ds.getOsmData("New York, New York", "secondary");
        
        // find shortest path from northwest to southeast
        StreetMap map = new StreetMap(data);
        // System.out.println(map.outerVertex(1, -1));
        System.out.print("test1");
        map.shortestPath(map.outerVertex(1, -1), map.outerVertex(-1, 1), new Color("red"));
        bridges.setDataStructure(map);
        bridges.visualize();
        System.out.print("test2");

    }
}