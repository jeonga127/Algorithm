class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^\\.|\\-|\\w]","");
        answer = answer.replaceAll("[\\.][\\.]+",".");
        
        if(answer.length() >=1 && answer.charAt(0) == '.')
            answer = answer.substring(1, answer.length());
        if(answer.length() >=1 && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);
            
        if(answer.length() == 0)
            answer = "a";
        
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.')
                answer = answer.substring(0,14);
        }
           
        
        if(answer.length() <= 2){
            char tmpc = answer.charAt(answer.length()-1);
            String tmps = Character.toString(tmpc);
            while(true){
                answer += tmps;
                if(answer.length() == 3)
                    break;
            }
        }
        return answer;
    }
}