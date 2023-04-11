import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pattern = {"aya", "ye", "woo", "ma"};
        
        for(String b : babbling){
            for(String p : pattern)
                b = b.replaceAll(p,"_");
            b = b.replaceAll("_","");
            if(b.length() == 0)
                answer++;
        }
        return answer;
    }
}