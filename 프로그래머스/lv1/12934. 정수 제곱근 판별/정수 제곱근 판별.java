class Solution {
    public double solution(long n) {
        long answer = 0;
        double tmp = Math.sqrt(n);
        if(tmp - (int)tmp == 0){
            return (tmp+1)*(tmp+1);
        }else 
            return -1;
    }
}