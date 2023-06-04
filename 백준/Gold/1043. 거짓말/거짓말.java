import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX < parentY)
            parent[parentY] = parentX;
        else if (parentX > parentY)
            parent[parentX] = parentY;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수
        parent = new int[N + 1];
        List<Integer>[] party = new ArrayList[M + 1];

        for (int i = 1; i < N + 1; i++)
            parent[i] = i;

        for (int i = 1; i < M + 1; i++)
            party[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람

        if (truthNum == 0) {
            System.out.print(M);
            return;
        }

        int truthStandard = Integer.parseInt(st.nextToken());
        for (int i = 1; i < truthNum; i++)
            union(truthStandard, Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());

            if (partyNum == 0) continue;

            int standardNum = Integer.parseInt(st.nextToken());
            party[i + 1].add(standardNum);

            while (st.hasMoreTokens()) {
                int tmpNum = Integer.parseInt(st.nextToken());
                party[i + 1].add(tmpNum);
                union(standardNum, tmpNum);
            }
        }

        int answer = 0;
        for (int i = 1; i < M + 1; i++) {
            boolean truthCheck = false;

            for (Integer g : party[i]) {
                if (find(g) == find(truthStandard)) {
                    truthCheck = true;
                    break;
                }
            }

            if (!truthCheck)
                answer++;
        }

        System.out.print(answer);
    }
}