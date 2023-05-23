import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static LinkedHashSet<String> answer = new LinkedHashSet<>();
    static int[] numbers;
    static int N, M;

    public static void dfs(int idx, int depth, int[] arr) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
            sb.append("\n");
            answer.add(sb.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = numbers[i];
            dfs(i, depth + 1, arr);
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

        dfs(0, 0, new int[M]);
        answer.forEach(System.out::print);
    }
}