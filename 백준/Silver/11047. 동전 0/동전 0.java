import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > K) break;
            else list.add(value);
        }
        Collections.sort(list, Collections.reverseOrder());

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int tmp = K / list.get(i);
            K -= tmp * list.get(i);
            count += tmp;
        }
        System.out.print(count);
    }
}