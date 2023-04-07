class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long cnt = x;
        for(int i = 0; i < n; i++){
            answer[i] = cnt;
            cnt += (long)x;
        }
        return answer;
    }
}