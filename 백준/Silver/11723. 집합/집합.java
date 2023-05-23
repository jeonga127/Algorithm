import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int target = Integer.parseInt(st.nextToken());
                    if (set.contains(target))
                        set.remove(target);
                    else set.add(target);
                    break;
                case "all":
                    set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    set = new HashSet<>(Arrays.asList());
                    break;
            }
        }
        System.out.print(sb);
    }
}