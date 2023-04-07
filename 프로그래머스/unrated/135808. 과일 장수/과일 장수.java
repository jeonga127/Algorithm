import java.util.*;

class Solution {
    public int cal(int[] arr){
        int min = arr[0];
        for(int a : arr){
           if(min > a)
               min = a;
        }
        return min*arr.length;
    }
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i = score.length-1; i >= 0; i -= m){
            if(i+1 >= m){
                answer+= cal(Arrays.copyOfRange(score,i-m+1,i+1));
            }    
        }
        return answer;
    }
}