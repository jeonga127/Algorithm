import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = i > 0 ? new Point(x - points[0].x, y - points[0].y) : new Point(x, y);
        }

        int answer = points[1].x * points[2].y - points[1].y * points[2].x;
        if (answer < 0) System.out.print(-1);
        if (answer == 0) System.out.print(0);
        if (answer > 0) System.out.print(1);
    }
}