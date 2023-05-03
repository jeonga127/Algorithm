import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem> {
    int number;
    int difficulty;

    Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Problem p) {
        if (this.difficulty < p.difficulty)
            return 1;
        else if (this.difficulty > p.difficulty)
            return -1;
        else if (this.number < p.number)
            return 1;
        else if (this.number > p.number)
            return -1;
        else return 0;
    }
}

public class Main {

    static Map<Integer, TreeSet<Problem>> alg_problems = new HashMap<>();
    static TreeSet<Problem> problems = new TreeSet<>();
    static Map<Integer, Integer> diffMap = new HashMap<>();
    static Map<Integer, Integer> algMap = new HashMap<>();

    public static void addProblem(int num, int diff, int alg) {
        Problem newProblem = new Problem(num, diff);
        problems.add(newProblem);
        diffMap.put(num, diff);
        algMap.put(num, alg);
        if (alg_problems.containsKey(alg)) {
            alg_problems.get(alg).add(newProblem);
        } else alg_problems.put(alg, new TreeSet<>(Arrays.asList(newProblem)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addProblem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 모든 문제들은 각 알고리즘 별로 분류되어 있고, 난이도 별로 내림차순 정렬 되어있음
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "recommend":
                    int G = Integer.parseInt(st.nextToken());
                    if (st.nextToken().equals("1"))
                        sb.append(alg_problems.get(G).first().number).append("\n");
                    else sb.append(alg_problems.get(G).last().number).append("\n");
                    break;
                case "recommend2":
                    if (st.nextToken().equals("1"))
                        sb.append(problems.first().number).append("\n");
                    else sb.append(problems.last().number).append("\n");
                    break;
                case "recommend3":
                    Problem tmp;
                    if (st.nextToken().equals("1")) {
                        if ((tmp = problems.lower(new Problem(0, Integer.parseInt(st.nextToken())))) != null)
                            sb.append(tmp.number).append("\n");
                        else sb.append("-1").append("\n");
                    } else {
                        if ((tmp = problems.higher(new Problem(0, Integer.parseInt(st.nextToken())))) != null)
                            sb.append(tmp.number).append("\n");
                        else sb.append("-1").append("\n");
                    }
                    break;
                case "add":
                    addProblem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case "solved":
                    int num = Integer.parseInt(st.nextToken());
                    int alg = algMap.get(num);
                    int diff = diffMap.get(num);
                    alg_problems.get(alg).remove(new Problem(num, diff));
                    problems.remove(new Problem(num, diff));
                    algMap.remove(num);
                    diffMap.remove(num);
                    break;
            }
        }
        System.out.print(sb);
    }
}
