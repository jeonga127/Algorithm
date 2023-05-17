import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            list.add(tmp);
        }
        // 1. 산술 평균
        double average = (double) map.keySet().stream().mapToLong(x -> x * map.get(x)).sum() / N;
        sb.append(Math.round(average)).append("\n");

        // 2. 중앙값
        Collections.sort(list);
        sb.append(list.get(list.size()/2)).append("\n");

        // 3. 최빈값
        int valuemax = map.values().stream().mapToInt(x -> x).max().getAsInt();
        List<Integer> valuemaxList = map.keySet().stream().filter(x -> map.get(x).equals(valuemax)).sorted().collect(Collectors.toList());
        sb.append(valuemaxList.size() == 1 ? valuemaxList.get(0) : valuemaxList.get(1)).append("\n");

        // 4. 범위
        int max = map.keySet().stream().mapToInt(x -> x).max().getAsInt();
        int min = map.keySet().stream().mapToInt(x -> x).min().getAsInt();
        sb.append(max - min).append("\n");

        System.out.print(sb);
    }
}