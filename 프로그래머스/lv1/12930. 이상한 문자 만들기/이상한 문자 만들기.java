class Solution {
    public String solution(String s) {
        String answer = "";
        String tmp1 = s.toUpperCase();
        String tmp2 = s.toLowerCase();
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(tmp1.charAt(i) == ' '){
                answer += tmp1.charAt(i);
                idx = 0;
            } else {
                if(idx%2 == 0){
                answer += tmp1.charAt(i);
                idx++;
            }else{
                answer += tmp2.charAt(i);
                idx++;
            }
            }
        }
        return answer;
    }
}