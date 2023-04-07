import java.util.*;

class Solution {
    public String solution(String[] par, String[] com) {
        String answer = "";
        HashMap<String, Integer> check = new HashMap<>();
        for(String p : par){
            if(check.containsKey(p)){
                check.put(p, check.get(p)+1);
            } else check.put(p, 1);
        }
        
        for(String c : com){
            check.put(c, check.get(c)-1);
        }
        
        for(Map.Entry<String,Integer> tmp : check.entrySet()){
            if(tmp.getValue() > 0)
                return tmp.getKey();
        }
        return answer;
    }
}