class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int tmp = x;
        
        while(true){
            if(tmp/10 > 0){
                sum += tmp % 10;
                tmp /= 10;
            }else{
                sum += tmp;
                break;
            }  
        }
        
        if( x % sum == 0)
            return true;
        else 
            return false;
    }
}