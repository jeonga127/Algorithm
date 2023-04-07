class Solution {
    boolean solution(String s) {
        String tmp = s.toLowerCase();
        int pcount = 0;
        int ycount = 0;
        
        for(int i = 0; i < tmp.length(); i++){
            if(tmp.charAt(i)=='p')
                pcount++;
            if(tmp.charAt(i)=='y')
                ycount++;
        }
        
        if(pcount == ycount)
            return true;
        else
            return false;
    }
}