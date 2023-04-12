import java.util.*;

class Solution {
    static int gcd(int n, int m){
        if( m % n == 0)
            return n;
        else
            return gcd(m % n, n);
    }
    
    static int lcm(int n, int m){
        return n*m/gcd(n,m);
    }
    
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}