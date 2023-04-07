import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int check = sc.nextInt();
        int[] temp = new int[total];
        int[] save = new int[total-check+1];
        for(int i = 0; i < total; i ++)
            temp[i] = sc.nextInt();
        for(int i = 0; i < total-check+1; i++){
            for(int j =0; j < check; j++){
                save[i] += temp[i+j];
            }
        }

        int max = save[0];
        for(int s : save){
            if(max < s)
                max = s;
        }
        System.out.println(max);
    }
}
