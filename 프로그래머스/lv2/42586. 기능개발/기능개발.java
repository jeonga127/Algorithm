import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i ++){
            if((100 - progresses[i]) % speeds[i] == 0)
                queue.offer((100 - progresses[i]) / speeds[i]);
            else queue.offer((100 - progresses[i]) / speeds[i] + 1);
        }
            
        int lastPoll = queue.poll();
        int count = 1;
        
        while(!queue.isEmpty()){
            if(lastPoll >= queue.peek()){
                queue.poll();
                count ++;
            } else {
                answer.add(count);
                lastPoll = queue.poll();
                count = 1;
            }
        }
        answer.add(count);
        return answer;
    }
}