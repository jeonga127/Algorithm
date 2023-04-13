import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
        
        for(int i = 0; i < survey.length; i++){
            if(choices[i] > 4){
                int tmpscore = score.get(survey[i].charAt(1));
                score.put(survey[i].charAt(1), tmpscore + choices[i] - 4);
            }
            if(choices[i] < 4){
                int tmpscore = score.get(survey[i].charAt(0));
                score.put(survey[i].charAt(0), tmpscore + Math.abs(choices[i] - 4));
            }            
        }
        
        answer += (score.get('R') >= score.get('T'))? "R" : "T";
        answer += (score.get('C') >= score.get('F'))? "C" : "F";
        answer += (score.get('J') >= score.get('M'))? "J" : "M";
        answer += (score.get('A') >= score.get('N'))? "A" : "N";
        
        return answer;
    }
}