import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int[] colors;
    static boolean isBipartite = false;
    static final int NOT_COLORED = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    public static void dfs(int node) {
        for (int next : graph[node]) {
            if (colors[next] == colors[node]) {
                isBipartite = true;
                return;
            }

            if(colors[next] == NOT_COLORED){
                colors[next] = colors[node] == RED ? BLUE : RED;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (--K >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수

            graph = new ArrayList[V];
            for (int i = 0; i < V; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;

                graph[u].add(v);
                graph[v].add(u);
            }

            colors = new int[V];
            for (int i = 0; i < V; i++) {
                if (colors[i] == NOT_COLORED) {
                    colors[i] = RED;
                    dfs(i);
                }

                if (isBipartite) break;
            }

            sb.append(isBipartite ? "NO\n" : "YES\n");
            isBipartite = false;
        }
        System.out.print(sb);
    }
}