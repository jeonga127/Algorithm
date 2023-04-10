import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int compare = budget;
        Arrays.sort(d);
        
        for(int d_idx : d){
            compare -= d_idx;
            
            if(compare < 0)
                break;
            else
                answer += 1;
        }
        return answer;
    }
}