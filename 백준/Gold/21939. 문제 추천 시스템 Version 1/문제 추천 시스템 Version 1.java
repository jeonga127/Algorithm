import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem> {
    public int number;
    public int difficulty;

    public Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Problem p1) {
        if (this.difficulty < p1.difficulty) return 1;
        else if (this.difficulty > p1.difficulty) return -1;
        else if (this.number < p1.number) return 1;
        else if (this.number > p1.number) return -1;
        else return 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 문제의 개수
        PriorityQueue<Problem> problems = new PriorityQueue<>(); // 난이도를 기준으로 내림차순 정렬된 문제 정보 우선순위 큐
        PriorityQueue<Problem> reversed = new PriorityQueue<>(Comparator.reverseOrder()); // 난이도를 기준으로 오름차순 정렬된 문제 정보 우선순위 큐
        PriorityQueue<Integer> removed_problems = new PriorityQueue<>(Collections.reverseOrder()); // 삭제된 문제 (내림차순)
        PriorityQueue<Integer> removed_reversed = new PriorityQueue<>(); // 삭제된 문제 (오름차순)

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Problem target = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            problems.add(target);
            reversed.add(target);
        }

        int M = Integer.parseInt(br.readLine()); // 명령문의 개수

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "recommend":
                    if (st.nextToken().equals("1")) {
                        while(!removed_problems.isEmpty() && removed_problems.peek() == problems.peek().number){
                            removed_problems.poll();
                            problems.poll();
                        }
                        sb.append(problems.peek().number).append("\n");
                    }
                    else {
                        while(!removed_reversed.isEmpty() && removed_reversed.peek() == reversed.peek().number){
                            removed_reversed.poll();
                            reversed.poll();
                        }
                        sb.append(reversed.peek().number).append("\n");
                    }
                    break;
                case "add":
                    Problem target = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    problems.add(target);
                    reversed.add(target);
                    break;
                case "solved":
                    int tmp = Integer.parseInt(st.nextToken());
                    removed_problems.add(tmp);
                    removed_reversed.add(tmp);
                    break;
            }
        }
        System.out.print(sb);
    }
}
