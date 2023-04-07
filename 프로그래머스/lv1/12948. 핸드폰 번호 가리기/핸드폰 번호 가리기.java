class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int tmp = phone_number.length();
        for(int i = 0; i < tmp; i++){
            if(i < tmp-4)
                answer += "*";
            else
                answer += phone_number.substring(i, i+1);
        }
        return answer;
    }
}