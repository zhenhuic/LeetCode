import java.util.HashMap;

public class SourceHunter {

    public static void sourceHashMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 4);
        map.get(3);
        boolean b = map.containsKey(1);
        map.clear();
    }


    public static void main(String[] args) {
//        SourceHunter.sourceHashMap();
        double d= 0.3245;
        System.out.printf("%.5f", d);
    }
}
