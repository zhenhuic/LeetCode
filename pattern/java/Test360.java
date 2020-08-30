import java.util.*;

public class Test360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i + 1);
        }
        for (int i = 0; i < m; i++) {
            int c = sc.nextInt();
            if (c == 1) {
                list.addLast(list.removeFirst());
            } else {
                swap(list);
            }
        }

        list.forEach(o -> System.out.println(o + " "));
    }

    private static void swap(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if ((i & 1) == 1) {
                list.add(i - 1, list.remove(i));
            }
        }
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String p = "^[a-zA-Z]{1,10}$";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.matches(p)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
