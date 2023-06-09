import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 크레인의 개수
        Integer[] cranes = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cranes[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cranes, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine()); // 박스의 개수
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            boxes.add(Integer.parseInt(st.nextToken()));
        Collections.sort(boxes, Collections.reverseOrder());

        int movedBoxes = 0;
        int times = 0;

        while (!boxes.isEmpty()) {
            int craneIdx = 0;
            int boxesIdx = 0;

            if(boxes.get(0) > cranes[0])
                break;

            while (craneIdx < N && boxesIdx < boxes.size()) {
                if (boxes.get(boxesIdx) <= cranes[craneIdx]) {
                    boxes.remove(boxesIdx);
                    movedBoxes++;
                    craneIdx++;
                } else boxesIdx++;
            }
            times++;

            if(movedBoxes == M)
                break;
        }

        System.out.print(movedBoxes == M ? times : -1);
    }
}