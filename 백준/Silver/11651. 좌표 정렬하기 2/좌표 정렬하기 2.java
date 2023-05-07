import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(answer, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y > o2.y) return 1;
                else if (o1.y < o2.y) return -1;
                else if (o1.x > o2.x) return 1;
                else if (o1.x < o2.x) return -1;
                else return 0;
            }
        });
        answer.forEach(x -> System.out.println(x.x + " " + x.y));
    }
}