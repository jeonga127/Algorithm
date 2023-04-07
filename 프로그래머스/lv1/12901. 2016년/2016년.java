class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] arr = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int tmp = 0;
        for(int i = 0; i < a-1; i++){
            tmp += arr[i];
        }
        tmp += b-1;
        answer = day[tmp%7];
        return answer;
    }
}