import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BoxInfo implements Comparable<BoxInfo> {
    int sendTown;
    int receiveTown;
    int boxNum;

    BoxInfo(int sendTown, int receiveTown, int boxNum) {
        this.sendTown = sendTown;
        this.receiveTown = receiveTown;
        this.boxNum = boxNum;
    }

    @Override
    public int compareTo(BoxInfo o) {
        if(this.receiveTown != o.receiveTown) return Integer.compare(this.receiveTown, o.receiveTown);
        else return Integer.compare(this.sendTown, o.sendTown);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 마을 수
        int C = Integer.parseInt(st.nextToken()); // 트럭 용량

        PriorityQueue<BoxInfo> queue = new PriorityQueue<>();

        int M = Integer.parseInt(br.readLine()); // 박스 정보의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int sendTown = Integer.parseInt(st.nextToken());
            int receiveTown = Integer.parseInt(st.nextToken());
            int boxNum = Integer.parseInt(st.nextToken());

            queue.add(new BoxInfo(sendTown, receiveTown, boxNum));
        }

        int[] weights = new int[N];
        for(int i = 0; i < N; i++)
            weights[i] = C;

        int answer = 0;
        while(!queue.isEmpty()){
            BoxInfo target = queue.poll();

            int affordableNum = target.boxNum;

            for(int i = target.sendTown; i < target.receiveTown; i++) {
                affordableNum = Math.min(affordableNum, weights[i]);
                
                if(affordableNum <= 0) break;
            }

            if(affordableNum > 0){
                for(int i = target.sendTown; i < target.receiveTown; i++)
                    weights[i] -= affordableNum;
            }

            answer += affordableNum;
        }

        System.out.print(answer);
    }
}