class Solution {
    public String solution(String s, int n) {
        char[] answer = s.toCharArray();
        int len = answer.length;
        for(int i = 0; i < len; i++){
            if(answer[i] == ' ')
                continue;
            if(answer[i] >= 65 && answer[i] < 91){
                if((int)answer[i] + n >= 91){
                    answer[i] += (char)n - 26;
                } else
                    answer[i] += (char)n;
            } else{
                if((int)answer[i] + n >= 123){
                    answer[i] += (char)n - 26;
                } else
                    answer[i] += (char)n;
            }
        }
        
        return new String(answer);
    }
}