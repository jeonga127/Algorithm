import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp = n;
        int jisu = 1;
        while(true){
            if(tmp/10 > 0){
                answer += tmp%10;
                tmp /= 10;
            }else{
                answer += tmp;
                break;
            }
        }
        return answer;
    }
}