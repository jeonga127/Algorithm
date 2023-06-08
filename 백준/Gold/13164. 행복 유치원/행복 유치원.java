import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //원생의 수
        int K = Integer.parseInt(st.nextToken()); //조의 개수

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            heights[i] = Integer.parseInt(st.nextToken());

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++)
            diff[i] = heights[i + 1] - heights[i];

        long sum = Arrays.stream(diff).boxed().sorted((a, b) -> b - a).skip(K - 1).mapToLong(Integer::longValue).sum();
        System.out.print(sum);
    }
}