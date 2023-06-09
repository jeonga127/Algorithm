import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -3;
                    reserve[j] = -3;
                    break;
                }
            }
        }
        
        
        for(int l : lost){
            if(l == -3)
                continue;
            for(int i = 0; i < reserve.length; i++){
                if(reserve[i] == l - 1){
                    answer++;
                    reserve[i] = -1;
                    break;
                }
                else if(reserve[i] == l + 1){
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}