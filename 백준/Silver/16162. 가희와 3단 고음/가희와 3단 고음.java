import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 음의 개수
        int A = Integer.parseInt(st.nextToken()); // 첫 항
        int D = Integer.parseInt(st.nextToken()); // 공차

        int[] melodies = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            melodies[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (melodies[i] == A) {
                int tmpCount = 1;

                for (int j = 1; i + j < N; j++) {
                    if (melodies[i + j] == A + tmpCount * D)
                        tmpCount++;
                }

                max = Math.max(max, tmpCount);
            }
        }
        System.out.print(max);
    }
}