import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visitForDFS;
    static boolean[] visitForBFS;

    public static StringBuilder dfs(StringBuilder sb, int num) {
        sb.append(num + 1).append(" ");

        for (int i = 0; i < N; i++) {
            if (arr[num][i] == 1 && !visitForDFS[i]) {
                visitForDFS[i] = true;
                dfs(sb, i);
            }
        }

        return sb;
    }

    public static StringBuilder bfs(int num) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        visitForBFS[num] = true;
        sb.append(num + 1).append(" ");
        queue.add(num);

        while (!queue.isEmpty()) {
            int target = queue.poll();

            for (int i = 0; i < N; i++) {
                if (arr[target][i] == 1 && !visitForBFS[i]) {
                    visitForBFS[i] = true;
                    sb.append(i + 1).append(" ");
                    queue.add(i);
                }
            }
        }

        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 갯수
        int M = Integer.parseInt(st.nextToken()); // 간선 갯수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        arr = new int[N][N];
        visitForDFS = new boolean[N];
        visitForBFS = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visitForDFS[V-1] = true;
        System.out.println(dfs(sb, V - 1));
        System.out.print(bfs(V - 1));
    }
}