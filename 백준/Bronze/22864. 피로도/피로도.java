import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] changePerhour = new int[4];
    static int maxWork = 0;

    public static void calFatigue(int hour, int fatigue, int work) {
        if (fatigue > changePerhour[3])
            return;
        if (hour <= 24) {
            // 2가지 선택지가 있음 : 1. 쉬거나, 2. 일하거나
            int tmpFatigue = Math.max(fatigue - changePerhour[2], 0);
            calFatigue(hour + 1, tmpFatigue, work); // 1. 쉰다

            calFatigue(hour + 1, fatigue + changePerhour[0], work + changePerhour[1]); // 2. 일한다
            maxWork = Math.max(maxWork, work);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        changePerhour[0] = Integer.parseInt(input[0]); // 한 시간동안 쌓이는 피로도 양
        changePerhour[1] = Integer.parseInt(input[1]); // 한 시간동안 할 수 있는 작업량
        changePerhour[2] = Integer.parseInt(input[2]); // 한 시간동안 줄어드는 피로도 양
        changePerhour[3] = Integer.parseInt(input[3]); // 번아웃 limit

        calFatigue(0, 0, 0);
        System.out.println(maxWork);
    }
}
