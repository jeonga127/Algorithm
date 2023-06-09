import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Computer {
    int start;
    int end;

    Computer(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Seat {
    int number;
    int end;

    Seat(int number, int end) {
        this.number = number;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Computer> comQueue = new PriorityQueue<>(Comparator.comparingInt(computer -> computer.start));
        PriorityQueue<Seat> endQueue = new PriorityQueue<>(Comparator.comparingInt(seat -> seat.end));
        PriorityQueue<Integer> availableSeat = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            comQueue.add(new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Map<Integer, Integer> seat = new TreeMap<>();

        while (!comQueue.isEmpty()) {
            Computer target = comQueue.poll();

            while(!endQueue.isEmpty() && endQueue.peek().end < target.start)
                availableSeat.add(endQueue.poll().number);

            int idx = availableSeat.isEmpty()? endQueue.size() : availableSeat.poll();
            seat.put(idx, seat.getOrDefault(idx, 0) + 1);

            endQueue.add(new Seat(idx, target.end));
        }

        sb.append(seat.size()).append("\n");
        seat.values().stream().forEach(values -> sb.append(values).append(" "));
        System.out.print(sb);
    }
}