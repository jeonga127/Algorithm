import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N = 간판의 수
        String pName = br.readLine(); // pName= 편의점 이름

        int answer = 0;

        for(int i = 0; i < N; i++){
            String target = br.readLine();

            // pName이 바로 보인다면(간격 비교 필요 X) 굳이 비교하지 않고 바로 pass
            if(target.contains(pName)) {
                answer++;
                continue;
            }

            int interval = 1;
            int checkIdx = 0;
            int startIdx;

            while(true){
                int matches = 0;

                if(pName.length() + (pName.length()-1) * interval > target.length())
                    break;

                startIdx = target.indexOf(pName.charAt(0), checkIdx);

                if(startIdx == -1) {
                    checkIdx = 0;
                    interval++;
                    continue;
                }

                for (int p = 0; p < pName.length(); p++) {
                    if(startIdx + p * interval >= target.length())
                        break;
                    if(pName.charAt(p) == target.charAt(startIdx + p * interval))
                        matches++;
                    else break;
                }

                if (matches == pName.length()) {
                    answer++;
                    break;
                } else  // 실패 시 우선 탐색 idx를 바꿔봄
                    checkIdx = startIdx + 1;
            }
        }
        System.out.print(answer);
    }
}
