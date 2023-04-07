import java.util.*;

class Solution {
    public long solution(long n) {
        List<Long> savenum = new ArrayList<>();
        long answer = 0;
        long tmp = n;
        while(true){
            if(tmp/10 > 0){
                savenum.add(tmp%10);
                tmp /= 10;
            }else{
                savenum.add(tmp);
                break;
            }
        }
        
        Collections.sort(savenum,Collections.reverseOrder());
        for(Long s : savenum){
            answer = answer*10 + s;
        }
        return answer;
    }
}