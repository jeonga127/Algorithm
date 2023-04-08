class Solution {
    public int toNum (String s){
        switch(s){
            case "zero": return 0;
            case "one" : return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six" : return 6;
            case "seven" : return 7;
            case "eight" : return 8;
            case "nine" : return 9;
            default : return -1;
        }
    }
    
    public int solution(String s) {
        char[] input = s.toCharArray();
        int len = input.length;
        String cmp = "";
        String answer = "";
        
        for(int i = 0; i < len; i++){
            if((int)input[i] >= 65){
                cmp += input[i];
            } else{
                answer += input[i];
            }
                
            if(cmp.length() >= 3){
                if(toNum(cmp) != -1){
                    answer += toNum(cmp);
                    cmp = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}