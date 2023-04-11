import java.util.*;

public class Date{
    public int year = 0;
    public int month = 0;
    public int day = 0;
}

class Solution {
    static int calMonth(Date standard, Date today){
        int yeardiff = today.year - standard.year;
        int monthdiff = today.month - standard.month;
        int daydiff = today.day - standard.day;
        
        int diff = yeardiff * 336 + monthdiff * 28 + daydiff;
        return diff/28;
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        String[] tmptoday = today.split("\\.");
        HashMap<String,Integer> newterms = new HashMap<>();
        Date d_today = new Date();
        d_today.year = Integer.parseInt(tmptoday[0]);
        d_today.month = Integer.parseInt(tmptoday[1]);
        d_today.day = Integer.parseInt(tmptoday[2]);
        
        for(int i = 0; i < terms.length; i++){
            String[] tmpterms = terms[i].split(" ");
            newterms.put(tmpterms[0], Integer.parseInt(tmpterms[1]));
        } 
        
        for(int i = 0; i < privacies.length; i++){
            String[] newprivacies = privacies[i].split(" ");
            String[] tmpstandard = newprivacies[0].split("\\.");
            Date d_standard = new Date( );
            d_standard.year = Integer.parseInt(tmpstandard[0]);
            d_standard.month = Integer.parseInt(tmpstandard[1]);
            d_standard.day = Integer.parseInt(tmpstandard[2]);
            
            if(calMonth(d_standard, d_today) >= newterms.get(newprivacies[1]))
                answer.add(i+1);
        }
        
        return answer;
    }
}