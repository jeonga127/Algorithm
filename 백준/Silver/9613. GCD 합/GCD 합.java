import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            List<Integer> arr = new ArrayList<>();
            long answer = 0;

            for (int j = 0; j < n; j++)
                arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr, Collections.reverseOrder());

            for(int p=0;p<n;p++){
                for(int q =p+1;q<n;q++){
                    answer += GCD(arr.get(p), arr.get(q));
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
