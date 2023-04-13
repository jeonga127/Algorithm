import java.util.*;

class Solution {
    static String[] aeiou = {"A", "E", "I", "O", "U"};
    static List<String> dict = new ArrayList<>();
    // a e i o u 로 만들 수 있는 경우의 수를 다 탐색 
    public int solution(String word) {
        int answer = 1;
        dfs(dict,"");
    
        for(String d : dict){
            if(d.equals(word))
                break;
            else
                answer++;
        }
    
        return answer;
    } 
    
    static void dfs(List<String> dict, String current){
        if(current.length() == 5)
            return;
        
        for(int i = 0; i < 5; i++){
            dict.add(current + aeiou[i]);
            dfs(dict, current + aeiou[i]);
        }
        
    }
}