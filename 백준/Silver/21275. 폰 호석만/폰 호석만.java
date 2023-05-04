import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = st.nextToken().chars().map(x -> x >= '0' && x <= '9' ? x - '0' : x - (int) 'a' + 10).toArray();
        int[] B = st.nextToken().chars().map(x -> x >= '0' && x <= '9' ? x - '0' : x - (int) 'a' + 10).toArray();

        int maxA = Arrays.stream(A).max().getAsInt();
        int maxB = Arrays.stream(B).max().getAsInt();

        if (maxA == 0 && maxB == 0) {
            System.out.print("Multiple");
            return;
        }
        if (maxA == 0 || maxB == 0) {
            System.out.print("Impossible");
            return;
        }

        Map<Long, Integer> mapA = new HashMap<>();
        Map<Long, Integer> mapB = new HashMap<>();
        Long answer = null;

        if (maxA >= maxB) { // A의 탐색 횟수가 더 적고 & mapA 크기가 더 작을 경우
            for (int i = maxA + 1; i <= 36; i++) {
                long xA = 0;
                for (int j = 0; j < A.length; j++) {
                    xA += A[j] * Math.pow(i, (double) A.length - j - 1);
                }
                mapA.put(xA, i);
            }

            for (int i = maxB + 1; i <= 36; i++) {
                long xB = 0;
                for (int j = 0; j < B.length; j++) {
                    xB += B[j] * Math.pow(i, (double) B.length - j - 1);
                }

                if (xB < Long.MAX_VALUE && mapA.containsKey(xB)) {
                    if (answer == null) {
                        answer = xB;
                        mapB.put(xB, i);
                    } else {
                        System.out.print("Multiple");
                        return;
                    }
                }
            }
        } else {
            for (int i = maxB + 1; i <= 36; i++) {
                long xB = 0;
                for (int j = 0; j < B.length; j++) {
                    xB += B[j] * Math.pow(i, (double) B.length - j - 1);
                }
                mapB.put(xB, i);
            }

            for (int i = maxA + 1; i <= 36; i++) {
                long xA = 0;
                for (int j = 0; j < A.length; j++) {
                    xA += A[j] * Math.pow(i, (double) A.length - j - 1);
                }

                if (xA < Long.MAX_VALUE && mapB.containsKey(xA)) {
                    if (answer == null) {
                        answer = xA;
                        mapA.put(xA, i);
                    } else {
                        System.out.print("Multiple");
                        return;
                    }
                }
            }
        }

        if (answer == null)
            System.out.print("Impossible");
        else
            System.out.print(answer + " " + mapA.get(answer) + " " + mapB.get(answer));
    }
}
