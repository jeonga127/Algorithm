import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (--T >= 0) {
            int M = Integer.parseInt(br.readLine()); // 수열의 크기
            int inputCount = (M - 1) / 10 + 1; // 입력 횟수
            sb.append(M / 2 + 1).append("\n");

            PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> end = new PriorityQueue<>();

            while (--inputCount >= 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && --M >= 0) {
                    int target = Integer.parseInt(st.nextToken());

                    if (front.size() == end.size())
                        front.add(target);
                    else end.add(target);

                    if (!front.isEmpty() && !end.isEmpty() && end.peek() < front.peek()) {
                        int frontPeek = front.poll();
                        int endPeek = end.poll();

                        front.add(endPeek);
                        end.add(frontPeek);
                    }

                    if (M % 2 == 0)
                        sb.append(front.peek()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}