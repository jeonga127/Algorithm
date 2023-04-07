import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        List<Integer> answer = new ArrayList<>();
        long tmp = n;
        while(true){
            if(tmp/10 > 0){
                answer.add((int)(tmp%10));
                tmp /= 10;
            } else{
                answer.add((int)tmp);
                break;
            }
        }
        
        return answer;
    }
}