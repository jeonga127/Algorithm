import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        answer = (set.size()<answer)? set.size() : answer;
        return answer;
    }
}