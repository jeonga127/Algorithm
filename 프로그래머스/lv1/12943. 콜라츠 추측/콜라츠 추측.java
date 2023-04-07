class Solution {
    public int solution(long num) {
        int answer = 0;
        long tmp = num;
        while(true){
            if(answer == 500)
                return -1;
            if(tmp == 1)
                break;
            else{
                if(tmp % 2 == 0){
                    tmp /= 2;
                    answer++;
                } else {
                    tmp = tmp * 3 +1;
                    answer++;
                }
            }
        }
        return answer;
    }
}