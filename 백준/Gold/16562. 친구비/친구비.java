import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX < parentY) parent[parentY] = parentX;
        else if (parentX > parentY) parent[parentX] = parentY;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구관계 수
        int k = Integer.parseInt(st.nextToken()); // 예산

        parent = new int[N + 1];
        int[] friendCost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            friendCost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            if (map.containsKey(find(i)))
                map.put(parent[i], Math.min(map.get(parent[i]), friendCost[i]));
            else map.put(parent[i], friendCost[i]);
        }

        int answer = map.values().stream().mapToInt(x -> x).sum();
        System.out.print(k < answer ? "Oh no" : answer);
    }
}