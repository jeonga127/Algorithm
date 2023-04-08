import java.util.*;

class Solution {
    public boolean decimal(int a, int b, int c){
        int tmp = a + b + c;
        int cnt = 2;
        
        for(int i = 2; i <= Math.sqrt(tmp); i++){
            if(tmp % i == 0)
                cnt += 2;
        }
        return cnt == 2? true : false;
    }
    
    public int solution(int[] nums) {
        int answer = -1;
        int cnt = 0;
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len-2; i++){
            for(int j = i+1; j < len-1; j++){
                for(int k = j+1; k < len; k++){
                    if(decimal(nums[i],nums[j],nums[k])){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}