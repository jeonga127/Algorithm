// Linked List로 구현했으나 시간 초과로 제출에 실패한 코드.
// 현재 코드는 list에 값을 추가할 때마다 지나치게 sorting이 자주 발생한다.
// 최악의 경우, 한 번의 add마다 정렬을 위해 list의 사이즈 n만큼의 탐색을 수행하게 된다.
// ( 그렇다고 조회의 성능이 좋은 것도 아니다... ^^ㅠ )
// 이후, 자동으로 값을 정렬해주는 우선순위 큐를 선택하게 됐다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Problem2 implements Comparable<Problem2> {
    public int number;
    public int difficulty;

    public Problem2(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Problem2 p1) {
        if (this.difficulty < p1.difficulty) return 1;
        else if (this.difficulty > p1.difficulty) return -1;
        else if (this.number < p1.number) return 1;
        else if (this.number > p1.number) return -1;
        else return 0;
    }
}

public class DS2_21939 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 문제의 개수
        List<Problem2> problems = new LinkedList<>(); // 문제 번호 : 난이도

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems.add(new Problem2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(problems);
        int M = Integer.parseInt(br.readLine()); // 명령문의 개수

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "recommend":
                    if (st.nextToken().equals("1"))
                        sb.append(problems.get(0).number).append("\n");
                    else sb.append(problems.get(problems.size() - 1).number).append("\n");
                    break;
                case "add":
                    problems.add(new Problem2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                    Collections.sort(problems);
                    break;
                case "solved":
                    int targetNum = Integer.parseInt(st.nextToken());
                    for (Problem2 problem : problems) {
                        if (problem.number == targetNum) {
                            problems.remove(problem);
                            break;
                        }
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}

