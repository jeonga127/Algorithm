import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int len = arr.length;
        if(len == 1){
            answer.add(-1);
        }else{
            int min = arr[0];
            for(int i = 1; i < len; i++){
                if(min > arr[i])
                    min = arr[i];
            }
            for(int i = 0; i <len; i++){
                if(arr[i] != min)
                    answer.add(arr[i]);
            }
        }
        return answer;
    }
}