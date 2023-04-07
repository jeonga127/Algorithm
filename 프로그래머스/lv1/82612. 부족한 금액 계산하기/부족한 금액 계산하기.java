class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 0; i < count; i++){
            answer += (long)(price * (i+1));
        }
        if(money >= answer) return 0;
        else {
            answer = Math.abs((long)(money - answer));
        }
        return answer;
    }
}