import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][][] num = {
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', ' ', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}}, // 0
            {{' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}}, // 1
            {{'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}}, // 2
            {{'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}}, // 3
            {{'*', ' ', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}}, // 4
            {{'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}}, // 5
            {{'*', '*', '*'}, {'*', ' ', ' '}, {'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}}, // 6
            {{'*', '*', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}, {' ', ' ', '*'}}, // 7
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}}, // 8
            {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}, {' ', ' ', '*'}, {'*', '*', '*'}}  // 9
    };

    static char[][] input;
    public static String checkNum(int start) {
        boolean[] check = new boolean[10];

        for (int i = 0; i < 5; i++) {
            for (int j = start; j < start + 3; j++) {
                for (int k = 0; k < 10; k ++) {
                    if(check[k])
                        continue;

                    if (num[k][i][j-start] != input[i][j])
                        check[k] = true;
                }
            }
        }

        for(int i = 0 ; i < 10; i ++){
            if(!check[i])
                return String.valueOf(i);
        }
        return "NULL";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstInput = br.readLine().toCharArray();
        input = new char[5][firstInput.length];
        input[0] = firstInput;
        String answer = "";

        for (int i = 1; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            input[i] = tmp;
        }

        for (int i = 0; i < firstInput.length; i += 4) {
            if(firstInput.length - i < 3){
                System.out.println("BOOM!!");
                return;
            }
            
            String result = checkNum(i);
            if(result.equals("NULL")) {
                System.out.println("BOOM!!");
                return;
            }
            answer += result;
        }

        answer = (Integer.parseInt(answer) % 6 == 0) ? "BEER!!" : "BOOM!!";
        System.out.println(answer);
    }
}