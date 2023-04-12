class Solution {
    static int measure(int num){
        int result = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(result > 2)
                break;
            if(num % i == 0)
                result += 2;
        }
        return result;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i <= n; i++){
            if(measure(i) == 2)
                answer++;
        }
        return answer;
    }
}