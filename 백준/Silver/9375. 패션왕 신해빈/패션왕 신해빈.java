import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            Map<String, List<String>> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();

                if (map.containsKey(category))
                    map.get(category).add(name);
                else map.put(category, new ArrayList<>(Arrays.asList(name)));
            }

            int answer = 1;
            for (List<String> list : map.values())
                answer *= list.size() + 1;
            sb.append(answer - 1).append("\n");
        }
        System.out.print(sb);
    }
}