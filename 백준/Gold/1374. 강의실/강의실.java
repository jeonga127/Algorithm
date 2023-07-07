import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Lecture> lectures = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine()); // 강의의 개수
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        while (!lectures.isEmpty()) {
            Lecture target = lectures.poll();

            if (!ends.isEmpty() && ends.peek() <= target.start)
                ends.poll();
            else answer += 1;

            ends.add(target.end);
        }

        System.out.print(answer);
    }
}