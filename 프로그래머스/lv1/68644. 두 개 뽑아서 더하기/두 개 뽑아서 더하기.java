import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> savenum = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i == j)
                    continue;
                else
                    savenum.add(numbers[i]+numbers[j]);
            }
        }
        
        Set<Integer> tmp = new HashSet<>(savenum);
        List<Integer> answer = new ArrayList<>(tmp);
        Collections.sort(answer);
        return answer;
    }
}