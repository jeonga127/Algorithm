import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture3 {
    int start;
    int end;

    Lecture3(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture3> startQueue = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.start));
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startQueue.add(new Lecture3(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while (!startQueue.isEmpty()) {
            Lecture3 target = startQueue.poll();

            if (!endQueue.isEmpty() && endQueue.peek() <= target.start)
                endQueue.poll();
            else answer += 1;

            endQueue.add(target.end);
        }

        System.out.print(answer);
    }
}