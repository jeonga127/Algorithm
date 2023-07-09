import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rockInfo = new int[N - 1][2];
        int[][] energy = new int[N][2];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rockInfo[i][0] = Integer.parseInt(st.nextToken());
            rockInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i < Math.min(N, 4); i++) {
            if (i == 1) energy[i][0] = rockInfo[0][0];
            if (i == 2) energy[i][0] = Math.min(rockInfo[1][0] + energy[1][0], rockInfo[0][1]);
            if (i == 3) {
                energy[i][0] = Math.min(rockInfo[2][0] + energy[2][0], rockInfo[1][1] + energy[1][0]);
                energy[i][1] = K;
            }
        }

        for (int i = 4; i < N; i++) {
            energy[i][0] = Math.min(
                    rockInfo[i - 1][0] + energy[i - 1][0],
                    rockInfo[i - 2][1] + energy[i - 2][0]);

            energy[i][1] = i > 4 ?
                    Math.min(Math.min(
                            rockInfo[i - 1][0] + energy[i - 1][1],
                            rockInfo[i - 2][1] + energy[i - 2][1]),
                            K + energy[i - 3][0]) :
                    Math.min(
                            rockInfo[i - 1][0] + energy[i - 1][1],
                            K + energy[i - 3][0]);
        }

        System.out.print(N <= 3 ? energy[N - 1][0] : Math.min(energy[N - 1][0], energy[N - 1][1]));
    }
}