import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int num;
    int weight;

    Node(int number, int weight) {
        this.num = number;
        this.weight = weight;
    }
}

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int diameter = Integer.MIN_VALUE;
    static int farNode = 0;

    public static void dfs(int current, int depth, int answer) {
        boolean visitAll = true;

        for (int i = 0; i < graph.get(current).size(); i++) {
            Node target = graph.get(current).get(i);
            if (!visited[target.num]) {
                visitAll = false;
                visited[target.num] = true;
                dfs(target.num, depth + 1, answer + target.weight);
                visited[target.num] = false;
            }
        }

        if (visitAll) {
            farNode = answer > diameter ? current : farNode;
            diameter = Math.max(diameter, answer);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int tmp;

            while ((tmp = Integer.parseInt(st.nextToken())) != -1)
                graph.get(target - 1).add(new Node(tmp - 1, Integer.parseInt(st.nextToken())));
        }

        visited[0] = true;
        dfs(0, 1, 0);
        visited[0] = false;

        diameter = 0;
        visited[farNode] = true;
        dfs(farNode, 1, 0);

        System.out.print(V == 1 ? 0 : diameter);
    }
}