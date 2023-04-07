class Solution {
    public String solution(int n) {
        String answer = "";
        String pattern = "수박";
        if( n % 2 == 1)
            answer = pattern.repeat(n/2) + "수";
        else
            answer = pattern.repeat(n/2);
        return answer;
    }
}