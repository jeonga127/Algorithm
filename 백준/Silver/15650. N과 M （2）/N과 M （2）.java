import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int N, M;

    public static void dfs(int node, int depth, int[] arr) {
        if (depth == M) {
            Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
            sb.append("\n");
            return;
        }

        if(node > N)
            return;

        for (int i = node; i <= N; i++) {
            arr[depth] = i;
            visited[i] = true;
            dfs(i + 1, depth + 1, arr);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        dfs(1, 0, new int[M]);
        System.out.print(sb);
    }
}