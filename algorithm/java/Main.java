import java.util.*;

public class Main {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (sc.hasNext()) {
            long n = sc.nextLong();
            cur.next = new ListNode(n);
            cur = cur.next;
        }

        cur = head.next;
        ListNode prior = cur;
        long val = cur.val;
        int cnt = 1;
        while ((cur = cur.next) != null) {
            if (val == cur.val && cnt > 2) {

            }
        }

    }

    static class ListNode {
        long val;
        ListNode next;
        ListNode (long val) {
            this.val = val;
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<Long> set = new LinkedHashSet<>();
        String[] strs = sc.nextLine().split(" ");
        for (String s : strs) {
            set.add(Long.parseLong(s));
        }
        for (Long n : set) {
            System.out.print("" + n + " " + n + " ");
        }
        sc.close();
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[] nums = new long[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextLong();
        }

        long sum = 0, res = 0, max=1;
        int[] dp = new int[len];
        dp[0]=nums[0]==0?0:1;
        sum = nums[0];
        res = dp[0];
        if(nums.length==1){
            System.out.println(dp[0]);
            return;
        }
        for (int i = 1; i < len; i++) {
            sum+=nums[i];
            if(sum!=0){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
            res+=dp[i];
        }
        System.out.println(res);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] coins = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                coins[i][j] = sc.nextInt();
            }
        }

        int[] rowOffset = {-1, 0, 1, 1, -1};
        int[] colOffset = {-1, -1, -1, -1};
        int[][] noMagic = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    noMagic[i][j] = coins[i][j];
                } else if (i == 0) {
                    noMagic[i][j] = Math.max(coins[i][j - 1], coins[i + 1][j - 1]);
                } else if (i < row - 1) {
                }
            }
        }
        int[][] magic = new int[row][col];

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                if (i - 1 >= 0 && j - 1 >= 0) {
                    list1.add(noMagic[i - 1][j - 1]);
                    list2.add(magic[i - 1][j - 1]);
                }
                if (j - 1 >= 0) {
                    list1.add(noMagic[i][j - 1]);
                    list2.add(magic[i][j - 1]);
                }
                if (i + 1 < row && j - 1 >= 0) {
                    list1.add(noMagic[i + 1][j - 1]);
                    list2.add(magic[i + 1][j - 1]);
                }
                int max1 = list1.stream().max((n1, n2) -> n1 - n2).get();


            }
        }
    }
}
