import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = (long) Integer.MIN_VALUE;

        /* 매개변수 탐색(이분 탐색) : 조건을 만족하는 가장 큰 값(마지노선 값)을 찾기 위한 문제.
         * 무조건 조건을 만족하는 경우를 탐색의 start 지점으로,
         * 무조건 조건을 만족시킬 수 없는 경우를 탐색의 end 지점으로 삼는다. */

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        /* 무조건 조건을 만족하는 start 지점은 max / N, 무조건 조건을 만족하지 않는 end 지점은 max+1 로 설정
        * max 값의 범위가 2^31-1까지 가능하기 때문에, 계산 과정에서 오버플로우가 생길 수 있어 long 타입으로 선언 */
        long start = max / N;
        long end = max + 1;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            if (check(arr, mid, N)) start = mid;
            else end = mid;
        }

        System.out.print(start);
    }

    static boolean check(int[] arr, long len, int goal) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i] / len;
        return sum >= goal;
    }
}