class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            String tmp = s.toLowerCase();
            tmp = tmp.replaceAll("[a-z]","");
            System.out.println(tmp);
            if(tmp.length()==0)
                return true;
            else if(tmp.length() == s.length())
                return true;
            else
                return false;
        } else return false;
    }
}