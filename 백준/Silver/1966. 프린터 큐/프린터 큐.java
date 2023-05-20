import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            Queue<Point> queue = new LinkedList<>();
            for (int j = 0; j < N; j++)
                queue.add(new Point(Integer.parseInt(st.nextToken()), j));
            int max = queue.stream().mapToInt(x -> x.x).max().getAsInt();

            int count = 1;
            while (!queue.isEmpty()) {
                Point tmp = queue.poll();

                if (tmp.x == max && tmp.y == M) {
                    sb.append(count).append("\n");
                    break;
                }

                if (tmp.x == max && !queue.isEmpty()) {
                    max = queue.stream().mapToInt(x -> x.x).max().getAsInt();
                    count++;
                } else queue.add(tmp);
            }
        }
        System.out.print(sb);
    }
}