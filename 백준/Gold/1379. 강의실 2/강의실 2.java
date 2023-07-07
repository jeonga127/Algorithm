import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lecture2 {
    int number;
    int start;
    int end;

    Lecture2(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }
}

class Classroom {
    int number;
    int end;

    Classroom(int number, int end) {
        this.number = number;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Lecture2> lectures = new PriorityQueue<>(Comparator.comparingInt(lecture -> lecture.start));
        PriorityQueue<Classroom> end = new PriorityQueue<>(Comparator.comparingInt(classroom -> classroom.end));
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine()); // 강의실 개수
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Map<Integer, Integer> answer = new TreeMap<>();
        int count = 0;

        while (!lectures.isEmpty()) {
            Lecture2 target = lectures.poll();

            while (!end.isEmpty() && end.peek().end <= target.start)
                availableRoom.add(end.poll().number);

            count = availableRoom.isEmpty() ? count + 1 : count;
            int idx = availableRoom.isEmpty() ? end.size() : availableRoom.poll();
            answer.put(target.number, idx + 1);
            end.add(new Classroom(idx, target.end));
        }

        sb.append(count).append("\n");
        answer.values().forEach(value -> sb.append(value).append("\n"));
        System.out.print(sb);
    }
}