import java.util.*;

class Solution {
    public Collection<String> solution(String[] players, String[] callings){
        String[] answer = {};
        HashMap<String, Integer> pl_idx = new HashMap<>();
        HashMap<Integer, String> idx_pl = new HashMap<>();
        
        int idx = 1;
        for(String p : players){
            pl_idx.put(p, idx);
            idx ++;
        }
        
        idx = 1;
        for(String p : players){
            idx_pl.put(idx, p);
            idx ++;
        }
        
        for(String c : callings){
            int c_rank = pl_idx.get(c);
            String front = idx_pl.get(c_rank-1);
            
            pl_idx.put(c,c_rank-1);
            idx_pl.put(c_rank-1,c);
            
            pl_idx.put(front,c_rank);
            idx_pl.put(c_rank, front);
        }
        
        return idx_pl.values();
    }
}