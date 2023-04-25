import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();

        String[] tmpInput = bf.readLine().split(" ");
        int N = Integer.parseInt(tmpInput[0]); // 카드의 개수
        int M = Integer.parseInt(tmpInput[1]); // 딜러가 뽑은 숫자

        String[] tmpInfo = bf.readLine().split(" ");
        int[] cardInfo = Arrays.stream(tmpInfo).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++){
                for (int k = j+1; k < N; k++) {
                    int tmp = cardInfo[i] + cardInfo[j] + cardInfo[k];
                    if(tmp == M) {
                        System.out.println(M);
                        return;
                    } else map.put(tmp, 1);
                }
            }
        }

        int idx = 1;
        while(true){
            if(map.containsKey(M-idx)){
                System.out.println(M-idx);
                return;
            } else idx++;
        }
    }
}
