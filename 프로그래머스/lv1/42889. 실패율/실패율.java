import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Double[] answer = new Double[N];
        int[] stage = new int[N];
        HashMap<Integer, Double> failure = new HashMap<>();
        
        for(int i = 0; i < N+1; i++)
            failure.put(i, 0.0);
        
        for(int s : stages){
            failure.put(s-1, failure.get(s-1)+1);
        }
        
        int people = stages.length;
        for(int i = 0; i < N; i++){
            if(people >= 1){
                answer[i] = failure.get(i) / people;
                people -= failure.get(i);
                failure.put(i, answer[i]);
            } else{
                answer[i] = 0.0;
                failure.put(i, answer[i]);
            }
            
        }
        
        Arrays.sort(answer,Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(answer[i] == failure.get(j)){
                    stage[i] = j+1;
                    failure.put(j, -1.0);
                    break;
                }
            }
        }
        return stage;
    }
}