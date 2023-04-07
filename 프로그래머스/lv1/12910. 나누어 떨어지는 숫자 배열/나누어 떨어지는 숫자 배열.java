import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> tmp = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++){
             if(arr[i]%divisor == 0){
                 tmp.add(arr[i]);
             }
        }
        if(tmp.size() == 0)
            tmp.add(-1);
        else{
            Collections.sort(tmp);
        }
        
        return tmp;
    }
}