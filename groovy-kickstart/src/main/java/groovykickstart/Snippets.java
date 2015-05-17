package groovykickstart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivo Houbrechts
 */
public class Snippets {
    public static void main(String[] args) {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> a = map.getOrDefault("a", new ArrayList<>());
        a.add(1);
        map.putIfAbsent("a", a);
        System.out.println(map);
    }

}
