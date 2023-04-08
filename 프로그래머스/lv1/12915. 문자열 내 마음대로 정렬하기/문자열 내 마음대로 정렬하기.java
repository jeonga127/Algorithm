import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int len = strings.length;
        
        for(int i = 0; i < len; i++)
            answer[i] = strings[i];
        Arrays.sort(answer);
        
        for(int i = len-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(answer[j].charAt(n) > answer[j+1].charAt(n)){
                String tmp = answer[j];
                answer[j] = answer[j+1];
                answer[j+1] = tmp;
                }
            }
        }
        
            
        return answer;
    }
}