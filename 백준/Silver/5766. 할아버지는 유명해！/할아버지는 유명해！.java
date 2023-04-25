import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>(); // 선수별 점수 저장용 map

        while (true) {
            map.clear();

            String[] tmpSize = br.readLine().split(" ");
            int N = Integer.parseInt(tmpSize[0]);
            int M = Integer.parseInt(tmpSize[1]);

            if (N == 0 && M == 0) break;

            for (int i = 0; i < N; i++) {
                String[] tmpInput = br.readLine().split(" ");
                for (int j = 0; j < M; j++)
                    map.put(tmpInput[j], map.getOrDefault(tmpInput[j], 0) + 1);
            }

            Set<Integer> setValues = map.values().stream().collect(Collectors.toSet()); // 점수 중복 제거용 set
            List<Integer> values = new ArrayList<>(setValues); // 점수 정렬용 list
            Collections.sort(values, Collections.reverseOrder());

            List<Integer> answer = new ArrayList<>(); // 결과 정렬용 list
            for(String key : map.keySet()){
                if(map.get(key) == values.get(1))
                    answer.add(Integer.parseInt(key));
            }
            Collections.sort(answer);

            for(Integer a : answer)
                sb.append(a).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}