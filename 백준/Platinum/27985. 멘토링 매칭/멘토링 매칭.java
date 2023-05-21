import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int num;
    int[] preference;
    boolean[] matching;

    Student(int num, int[] preference) {
        this.num = num;
        this.preference = preference;
        this.matching = new boolean[preference.length];
    }

    int returnNextPair() {
        for (int i = 0; i < preference.length; i++) {
            if (!matching[preference[i] - 1])
                return preference[i] - 1;
        }
        return -1;
    }
}

class Kaist {
    int num;
    Student pair;

    Kaist(int num) {
        this.num = num;
        this.pair = null;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Student> queue = new LinkedList<>();
        List<Kaist> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] preference = new int[N];
            for (int j = 0; j < N; j++)
                preference[j] = Integer.parseInt(st.nextToken());

            queue.add(new Student(i + 1, preference));
            list.add(new Kaist(i + 1));
        }

        while (!queue.isEmpty()) {
            Student main = queue.poll();
            Kaist target = list.get(main.returnNextPair());
            main.matching[target.num - 1] = true;

            if (target.pair == null) { // 짝이 없으면 매칭
                target.pair = main;
            } else { //짝이 있다면 선호도 비교
                int diffOriginal = Math.abs(target.pair.num - target.num);
                int diffNew = Math.abs(main.num - target.num);

                if (diffOriginal > diffNew || (diffOriginal == diffNew && target.pair.num < main.num)) { // 원래 학생이 더 좋음
                    queue.add(main);
                } else {
                    queue.add(target.pair);
                    target.pair = main;
                }
            }
        }

        Map<Integer,Integer> answer = new HashMap<>();
        for(Kaist kaist : list)
            answer.put(kaist.pair.num, kaist.num);
        for(int i = 1; i <= N; i++)
            System.out.print(answer.get(i) + " ");
    }
}