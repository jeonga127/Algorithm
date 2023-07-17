import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Item {
    int weight;
    int satisfaction;

    Item(int weight, int satisfaction) {
        this.weight = weight;
        this.satisfaction = satisfaction;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int M = Integer.parseInt(st.nextToken()); // 최대 무게

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(0, 0));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int itemWeight = Integer.parseInt(st.nextToken());
            int satisfaction = Integer.parseInt(st.nextToken());
            int itemTotalNum = Integer.parseInt(st.nextToken());

            int itemNum = 1;
            while(itemNum <= itemTotalNum){
                itemList.add(new Item(itemNum * itemWeight, itemNum * satisfaction));
                itemTotalNum -= itemNum;
                itemNum *= 2;
            }

            if(itemTotalNum > 0)
                itemList.add(new Item(itemTotalNum * itemWeight, itemTotalNum * satisfaction));
        }

        int[] memo = new int[M + 1];
        for (int item = 1; item < itemList.size(); item++) {
            for (int weight = M; weight >= itemList.get(item).weight; weight--)
                memo[weight] = Math.max(memo[weight], memo[weight - itemList.get(item).weight] + itemList.get(item).satisfaction);
        }

        System.out.print(memo[M]);
    }
}