import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static int N, M;

    public static void dfs(int depth, int[] arr) {
        if (depth == M) {
            Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = numbers[i];
            dfs(depth + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        dfs(0, new int[M]);
        System.out.print(sb);
    }
}