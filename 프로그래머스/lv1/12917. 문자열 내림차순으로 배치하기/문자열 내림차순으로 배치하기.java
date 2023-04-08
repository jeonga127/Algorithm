import java.util.*;

class Solution {
    public String solution(String s) {
        char[] tmp = s.toCharArray();
        int len = tmp.length;
        char[] reverse = new char[len];
        Arrays.sort(tmp);
        for(int i = len-1; i >= 0 ; i--){
            reverse[len-i-1] = tmp[i];
        }
        return new String(reverse);
    }
}