import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX < parentY) parent[parentY] = parentX;
        else if(parentX > parentY) parent[parentX] = parentY;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "0" :
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case "1" :
                    sb.append(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))? "YES\n" : "NO\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}