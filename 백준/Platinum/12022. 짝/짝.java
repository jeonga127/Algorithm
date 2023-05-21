import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Man {
    int num;
    int[] preference;
    boolean[] matching;

    Man(int num, int[] preference) {
        this.num = num;
        this.preference = preference;
        this.matching = new boolean[preference.length];
    }

    int returnNextWoman() {
        for (int i = 0; i < preference.length; i++) {
            if (!matching[preference[i] - 1]) // 이루어진 적이 없다면 청혼 ㄱ
                return preference[i];
        }
        return -1;
    }
}

class Woman {
    int num;
    List<Integer> preference;
    boolean[] matching;
    Man pair;

    Woman(int num, List<Integer> preference) {
        this.num = num;
        this.preference = preference;
        this.matching = new boolean[preference.size()];
        this.pair = null;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Man> men = new LinkedList<>();
        Map<Integer, Woman> women = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] preference = new int[N];
            for (int j = 0; j < N; j++)
                preference[j] = Integer.parseInt(st.nextToken());
            men.add(new Man(i + 1, preference));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> preference = new ArrayList<>();
            for (int j = 0; j < N; j++)
                preference.add(Integer.parseInt(st.nextToken()));
            women.put(i + 1, new Woman(i + 1, preference));
        }

        while (!men.isEmpty()) {
            Man main = men.poll();
            Woman target = women.get(main.returnNextWoman());

            target.matching[main.num - 1] = true;
            main.matching[target.num - 1] = true;

            if (target.pair == null) { // 청혼한 여성이 미혼이라면 무조건 성사 성공
                target.pair = main;
            }
            else { // 청혼한 여성이 기혼이라면 이혼/거절 당하는 남자가 생김
                // 남편에 대한 선호도가 높아 main이 거절당함
                if(target.preference.indexOf(main.num) > target.preference.indexOf(target.pair.num)){
                    men.add(main);
                }
                // main에 대한 선호도가 높아 남편이 이혼당함
                else {
                    men.add(target.pair);
                    target.pair = main;
                }
            }
        }

        Map<Integer, Integer> answer = new HashMap<>();
        for(Woman w : women.values())
            answer.put(w.pair.num, w.num);

        for(Integer i : answer.values())
            System.out.println(i);
    }
}