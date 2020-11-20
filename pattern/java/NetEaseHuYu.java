import java.util.Arrays;
import java.util.Scanner;

public class NetEaseHuYu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            String[] strs = sc.nextLine().trim().split(" ");


        }
    }


    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        int segNum = sc.nextInt();
        int ptrNum = sc.nextInt();
        sc.nextLine();
        float[][] points = new float[ptrNum][2];
        for (int i = 0; i < ptrNum; i++) {
            String in = sc.nextLine();
            boolean matches = in.matches("^(-)?\\d+(.\\d+)?,(-)?\\d+(.\\d+)?$");
            if (!matches) {
                System.out.println("error");
                return;
            }
            String[] split = in.trim().split(",");
            points[i][0] = Float.parseFloat(split[0]);
            points[i][1] = Float.parseFloat(split[1]);
        }
        float lengthSum = 0;
        for (int i = 0; i < ptrNum - 1; i++) {
            lengthSum += lineLength(points[i], points[i + 1]);
        }
        float segLength = lengthSum / segNum;
        findSegPtr(points, points[0], 1, segNum, 1, segLength, segLength);
    }

    private static float lineLength(float[] p1, float[] p2) {
        return (float) Math.sqrt(Math.pow(p1[0] - p2[0], 2.0) +
                Math.pow(p1[1] - p2[1], 2.0));
    }

    private static void findSegPtr(float[][] points, float[] startPtr,int segPtrIdx, int segNum,
                                   int nextPtrIdx, float residue, float segLength) {
        if (segPtrIdx == segNum) return;
        float lineLen = lineLength(startPtr, points[nextPtrIdx]);
        if (residue - lineLen > 0.0001f) {
            findSegPtr(points, points[nextPtrIdx], segPtrIdx, segNum,
                    nextPtrIdx + 1, residue - lineLen, segLength);
        } else if (lineLen - residue < 0.0001f) {
            System.out.printf("%.1f,%.1f\n", points[nextPtrIdx][0], points[nextPtrIdx][0]);
            findSegPtr(points, points[nextPtrIdx], segPtrIdx + 1,
                    segNum, nextPtrIdx + 1, segLength, segLength);
        } else {
            float alpha = residue / lineLength(startPtr, points[nextPtrIdx]);
            float x = (points[nextPtrIdx][0] - startPtr[0]) * alpha + startPtr[0];
            float y = (points[nextPtrIdx][1] - startPtr[1]) * alpha + startPtr[1];
            System.out.printf("%.1f,%.1f\n", x, y);
            findSegPtr(points, new float[]{x, y}, segPtrIdx + 1,
                    segNum, nextPtrIdx, segLength, segLength);
        }
    }

}
