import java.util.*;

class Solution { 
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> mail = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();
        HashMap<String, List<String>> relation = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            List<String> tmpname = new ArrayList<>();
            idx.put(id_list[i],i);
            mail.put(id_list[i],0);
            relation.put(id_list[i],tmpname);
        } 

        for(String r : report){
            String[] tmpreport = r.split(" ");
            List<String> tmpname = relation.get(tmpreport[1]);
            if(!tmpname.contains(tmpreport[0])){
                tmpname.add(tmpreport[0]);
                mail.put(tmpreport[1], mail.get(tmpreport[1])+1);
                relation.put(tmpreport[1], tmpname);
            }
        }
    
        for(String i : id_list){
            if(mail.get(i) >= k){
                List<String> tmpname = relation.get(i);
                for(String t : tmpname){
                    answer[idx.get(t)] ++;
                }
            }
        }
               
        return answer;
    }
}