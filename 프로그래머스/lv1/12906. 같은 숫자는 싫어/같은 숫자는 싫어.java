import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int ref = arr[0];
        answer.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(ref != arr[i] ){
                answer.add(arr[i]);
                ref = arr[i];
            }
        }
        return answer;
    }
}