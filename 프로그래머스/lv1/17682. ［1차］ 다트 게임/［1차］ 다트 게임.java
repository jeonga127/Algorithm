import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> answer = new ArrayList<>();
        char[] result = dartResult.toCharArray();
        int totalsum = 0;
        
        for(int i = 0; i < dartResult.length(); i++){
            // 0. 숫자면 pass
            if(Character.isDigit(result[i]))
                continue;
            // 1. 알파벳 검사
            if(result[i] == 'S'){
                int tmp = (int)result[i-1] -'0';
                if(tmp == 0 && i >= 2 && (int)result[i-2] -'0' == 1)
                    tmp = 10;
                answer.add(tmp);
            }
            if(result[i] == 'D'){
                int tmp = (int)result[i-1] -'0';
                if(tmp == 0 && i >= 2 && (int)result[i-2] -'0' == 1)
                    tmp = 10;
                answer.add((int)Math.pow(tmp,2));
            }
            if(result[i] == 'T'){
                int tmp = (int)result[i-1] -'0';
                if(tmp == 0 && i >= 2 && (int)result[i-2] -'0' == 1)
                    tmp = 10;
                answer.add((int)Math.pow(tmp,3));
            }
            
            // 2. 스타상, 아차상 처리
            if(result[i] == '*'){
                if(answer.size() > 1){
                    answer.set(answer.size()-1, answer.get(answer.size()-1)*2);
                    answer.set(answer.size()-2, answer.get(answer.size()-2)*2);
                } else
                    answer.set(0, answer.get(0)*2);
            }
            if(result[i] == '#'){
                answer.set(answer.size()-1, answer.get(answer.size()-1)*(-1));
            }
        }
        
        for(int a : answer)
            totalsum += a;
        return totalsum;
    }
}