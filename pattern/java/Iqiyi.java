import java.util.*;

public class Iqiyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int len = s.length();
        if ((len & 1) == 1) {
            System.out.println("False");
            return;
        }

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peekLast() != pairs.get(ch)) {
                    System.out.println("False");
                    return;
                }
                stack.pollLast();
            } else {
                stack.addLast(ch);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n >= 5) {
            n /= 5;
            cnt += n;
        }
        System.out.println(cnt);
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(encode(x, y));

        int len = path.length();
        for (int i = 0; i < len; i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case 'N': --x; break;
                case 'S': ++x; break;
                case 'W': --y; break;
                case 'E': ++y; break;
            }
            String hv = encode(x, y);
            if (!visited.add(hv)) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }

    private static String encode(int i, int j) {
        return "" + i + j;
    }
}
