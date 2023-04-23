import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> top = new ArrayList<>();
        
        top.add(score[0]);
        answer[0] = score[0];
        
        for(int i = 1; i < score.length; i++){
            if(top.get(0) < score[i] || top.size() < k){
                if(top.size() == k)
                    top.remove(0);
                top.add(score[i]);
            }
            
            Collections.sort(top);
            answer[i] = top.get(0);
        }
        
        return answer;
    }
}