import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arrX = {x, 0, x, w};
        int[] arrY = {0, y, h, y};
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int target = Math.abs(x - arrX[i]) + Math.abs(y - arrY[i]);
            min = min > target ? target : min;
        }
        System.out.print(min);
    }
}