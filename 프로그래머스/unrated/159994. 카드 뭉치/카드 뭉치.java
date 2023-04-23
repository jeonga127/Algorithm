class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1_idx = 0; 
        int c2_idx = 0;
        
        for(String g : goal){
            if(c1_idx < cards1.length && g.equals(cards1[c1_idx]))
                c1_idx ++;
            else if(c2_idx < cards2.length && g.equals(cards2[c2_idx]))
                c2_idx ++;
            else return "No";
        }
        return "Yes";
    }
}