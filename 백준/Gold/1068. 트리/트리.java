import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int deleteNode = -1;
    static int leafCount = 0;

    public static void dfs(int root) {
        if (graph[root].isEmpty())
            leafCount++;

        for (Integer i : graph[root]) {
            if (i != deleteNode) dfs(i);
            else if (graph[root].size() == 1) leafCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList();

        int root = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx == -1) root = i;
            else graph[idx].add(i);
        }

        deleteNode = Integer.parseInt(br.readLine());
        graph[deleteNode].clear();

        if(root != deleteNode)
            dfs(root);

        System.out.print(leafCount);
    }
}