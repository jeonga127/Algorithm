class Solution {
    static int gcd(int n, int m){
        if( m % n == 0)
            return n;
        else
            return gcd(m%n, n);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.min(n,m), Math.max(n,m));
        answer[1] = n * m / answer[0];
        return answer;
    }
}