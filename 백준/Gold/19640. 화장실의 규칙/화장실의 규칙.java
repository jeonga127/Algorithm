import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Employee implements Comparable<Employee> {
    int lineNum;
    int originNum;
    int workingDays;
    int urgency;

    Employee(int lineNum, int originNum, int workingDays, int urgency) {
        this.lineNum = lineNum;
        this.originNum = originNum;
        this.workingDays = workingDays;
        this.urgency = urgency;
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.workingDays != employee.workingDays)
            return -Integer.compare(this.workingDays, employee.workingDays);
        else if (this.urgency != employee.urgency)
            return -Integer.compare(this.urgency, employee.urgency);
        else return Integer.compare(this.lineNum, employee.lineNum);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 줄의 전체 인원
        int M = Integer.parseInt(st.nextToken()); // 새로운 줄 갯수
        int K = Integer.parseInt(st.nextToken()); // 먼저 도착한 인원

        Queue<Employee>[] originalQueue = new LinkedList[M];
        for (int i = 0; i < M; i++)
            originalQueue[i] = new LinkedList<>();

        PriorityQueue<Employee> newQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int workingDays = Integer.parseInt(st.nextToken());
            int urgency = Integer.parseInt(st.nextToken());

            if (i < M) newQueue.add(new Employee(i % M, i + 1, workingDays, urgency));
            else originalQueue[i % M].add(new Employee(i % M, i + 1, workingDays, urgency));
        }

        int endNum = 0;

        while (!newQueue.isEmpty()) {
            Employee target = newQueue.poll();

            if (target.originNum == K + 1) {
                System.out.print(endNum);
                return;
            }

            if (!originalQueue[target.lineNum].isEmpty())
                newQueue.add(originalQueue[target.lineNum].poll());
            endNum += 1;
        }
    }
}