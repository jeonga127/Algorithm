import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> indexsave = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            if(indexsave.containsKey(s.charAt(i))){
                answer[i] = i-indexsave.get(s.charAt(i));
                indexsave.put(s.charAt(i),i);
            } else {
                answer[i] = -1;
                indexsave.put(s.charAt(i),i);
            }
        }
        
        
        return answer;
    }
}