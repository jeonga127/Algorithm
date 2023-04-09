import java.util.*;

class Solution {
    public Collection<String> solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        int n = players.length;
        for (int i = 0; i < n; i++) {
            playerMap.put(players[i], i);
        }

        ArrayList<String> indices = new ArrayList<>();
        for (String c : callings) {
            int c_idx = playerMap.get(c);
            int prev_idx = (c_idx - 1 + n) % n;
            int next_idx = (c_idx + 1) % n;
            String prev_player = players[prev_idx];
            players[prev_idx] = c;
            players[c_idx] = prev_player;
            playerMap.put(prev_player, c_idx);
            playerMap.put(c, prev_idx);
        }

        for (int i = 0; i < n; i++) {
            indices.add(players[i]);
        }

        return indices;
    }
}
