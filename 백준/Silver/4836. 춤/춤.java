import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tmp;

        while((tmp = br.readLine()) != null){
            sb.setLength(0);
            List<String> target = new ArrayList<>(Arrays.asList(tmp.split(" ")));

            int N = target.size();
            List<Integer> error = new ArrayList<>();

            // 규칙 1. dip은 jiggle을 춘 다음이나 다다음, 또는 twirl을 추기 전에 출 수 있음
            for(int i = 0; i < N; i++){
                if(target.get(i).equals("dip")){
                    if(!( i >= 2 && target.get(i-2).equals("jiggle")) && !( i >=1 && target.get(i-1).equals("jiggle")) && !(i+1 <= N-1 && target.get(i+1).equals("twirl"))){
                        target.set(i, "DIP");
                        error.add(1);
                        break;
                    }
                }
            }

            // 규칙 2. 모든 춤은 clap stomp clap으로 끝나야 함
            if(target.size() < 3)
                error.add(2);
            else if(!target.get(N-3).equals("clap") || !target.get(N-2).equals("stomp") || !target.get(N-1).equals("clap")){
                error.add(2);
            }

            // 규칙 3. 만약 twirl을 췄다면, hop도 춰야함
            if(target.contains("twirl") && !target.contains("hop")){
                error.add(3);
            }

            // 규칙 4. jiggle로 춤을 시작할 수 없음
            if(target.get(0).equals("jiggle")){
                error.add(4);
            }

            // 규칙 5. 반드시 dip을 춰야 함
            if(!target.contains("dip") && !target.contains("DIP")){
                error.add(5);
            }

            switch(error.size()){
                case 0 :
                    sb.append("form ok: ");
                    break;
                case 1 :
                    sb.append("form error ").append(error.get(0)).append(": ");
                    break;
                default :
                    sb.append("form errors ");
                    for(int i = 0; i < error.size(); i++){
                        if(i == 0)
                            sb.append(error.get(i));
                        if(i > 0 && i < error.size()-1)
                            sb.append(", ").append(error.get(i));
                        if(i == error.size() - 1)
                            sb.append(" and ").append(error.get(i)).append(": ");
                    }
                    break;
            }
            for(String t : target)
                sb.append(t).append(" ");
            System.out.println(sb);
        }
    }
}
