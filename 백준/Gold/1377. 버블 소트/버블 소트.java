import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> afterSort = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        int[] copy = Arrays.copyOf(A, N);
        Arrays.sort(copy);
        for (int i = 0; i < N; i++)
            afterSort.put(copy[i], i);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            maxDiff = Math.max(maxDiff, i - afterSort.get(A[i]));

        System.out.print(maxDiff + 1);
    }
}