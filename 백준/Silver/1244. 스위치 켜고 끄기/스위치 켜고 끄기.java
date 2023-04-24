import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String switchNum = br.readLine();
        String[] switchStatus = br.readLine().split(" ");
        String studentNum = br.readLine();

        for (int i = 0; i < Integer.parseInt(studentNum); i++) {
            String[] tmpInput = br.readLine().split(" ");
            int target = Integer.parseInt(tmpInput[1]);

            if(tmpInput[0].equals("1")){ // 남학생일때 : 배수 변경
                for(int j = 0; j < switchStatus.length; j++){
                    if((j+1) % target == 0)
                        switchStatus[j] = switchStatus[j].equals("0")? "1" : "0";
                }
            } else { // 여학생일때 : 대칭 변경
                switchStatus[target-1] = switchStatus[target-1].equals("0")? "1" : "0";
                int idx = 1;
                while(true){
                    int tmpBig = target + idx - 1;
                    int tmpSmall = target - idx - 1;

                    if( tmpBig >= switchStatus.length || tmpSmall < 0)
                        break;

                    if(switchStatus[tmpBig].equals(switchStatus[tmpSmall])){
                        switchStatus[tmpBig] = switchStatus[tmpBig].equals("0")? "1" : "0";
                        switchStatus[tmpSmall] = switchStatus[tmpSmall].equals("0")? "1" : "0";
                        idx ++;
                    } else break;
                }
            }
        }

        for(int i = 0; i < switchStatus.length; i++){
            System.out.print(switchStatus[i] + " ");
            if((i+1)%20 == 0) System.out.print("\n");
        }
    }
}
