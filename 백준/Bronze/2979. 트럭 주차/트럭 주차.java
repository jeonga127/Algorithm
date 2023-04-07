import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int priceA = sc.nextInt();
        int priceB = sc.nextInt();
        int priceC = sc.nextInt();

        int[][] time = new int[3][2];

        int minT = 101;
        int maxT = 1;
        for(int i = 0; i < 3; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
            if(minT > time[i][0])
                minT = time[i][0];
            if(maxT < time[i][1])
                maxT = time[i][1];
        }

        int[] save = new int[maxT-minT];
        for(int i = 0; i < 3; i++){
            for(int j = time[i][0]-minT; j < time[i][1]-minT; j++){
                save[j] += 1;
            }
        }

        for(int s : save){
            if(s==3){
                answer += s * priceC;
            }else if(s==2){
                answer += s * priceB;
            }else{
                answer += s * priceA;
            }
        }
        System.out.print(answer);
    }
}
