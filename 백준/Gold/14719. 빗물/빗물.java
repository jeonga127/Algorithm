import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 세로 길이
        int W = Integer.parseInt(st.nextToken()); // 가로 길이
        int[] blocks = new int[W];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            blocks[i] = Integer.parseInt(st.nextToken());

        for (int idx = 0; idx < W; idx++) {
            int leftMax = Arrays.stream(blocks, 0, idx).max().orElse(0);
            int rightMax = Arrays.stream(blocks, idx + 1, W).max().orElse(0);
            answer += Math.max(Math.min(leftMax, rightMax) - blocks[idx], 0);
        }

        System.out.print(answer);
    }
}