import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            //System.out.println("Hello World!");

        }

        public static String toHex(int n) {
            StringBuilder sb = new StringBuilder();
            List<Character> list = new LinkedList<>();
            int radix = 16;
            while (n > 0) {
                int hex = n % radix;
                char h = hexMap(hex);
                list.add(0, h);
                n = n / radix;
            }
            for (char c : list) {
                sb.append(c);
            }
            return sb.toString();
        }

        private static char hexMap(int v) {
            if (v <= 9) {
                return (char) ('0' + v);
            } else {
                return (char) ('a' + (v - 9));
            }

        }

        

}
