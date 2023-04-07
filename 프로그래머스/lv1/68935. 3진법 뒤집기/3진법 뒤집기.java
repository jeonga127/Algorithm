import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> savenum = new ArrayList<>();
        int answer = 0;
        int tmp = n;
        while(true){
            if(tmp/3 > 0){
                savenum.add(tmp%3);
                tmp /= 3;
            }else{
                savenum.add(tmp);
                break;
            }
        }
        
        int idx = savenum.size()-1;
        for(Integer s : savenum){
            answer += s*Math.pow(3,idx);
            idx--;
        }
        return answer;
    }
}