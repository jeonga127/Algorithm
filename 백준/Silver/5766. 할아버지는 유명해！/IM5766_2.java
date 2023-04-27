import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IM5766_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder()); // 선수별 점수 저장용 map
        Map<String, Integer> score = new HashMap<>();

        while (true) {
            map.clear();
            score.clear();

            String[] tmpSize = br.readLine().split(" ");
            int N = Integer.parseInt(tmpSize[0]);
            int M = Integer.parseInt(tmpSize[1]);

            if (N == 0 && M == 0) break;

            for (int i = 0; i < N; i++) {
                String[] tmpInput = br.readLine().split(" ");
                for (int j = 0; j < M; j++){
                    score.put(tmpInput[j], score.getOrDefault(tmpInput[j], 0) + 1);
                }
            }

            for(String s : score.keySet()){
                if(!map.containsKey(score.get(s))){
                    List<Integer> tmpList = new ArrayList<>(Arrays.asList(Integer.parseInt(s)));
                    map.put(score.get(s), tmpList);
                } else
                    map.get(score.get(s)).add(Integer.parseInt(s));
            }

            int idx = 0;
            for(List<Integer> v : map.values()){
                if(idx == 1){
                    Collections.sort(v);
                    for(int result : v)
                        System.out.print(result + " ");
                    System.out.println();
                    break;
                } idx++;
            }
        }
    }
}