class Solution {
    public int countMeasure(int number){
        int count = 0;
        for(int i = 1; i <= Math.sqrt(number); i++){
            if(i == Math.sqrt(number))
                count += 1;
            else if(number % i == 0)
                count += 2;
        }
        return count;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            if(countMeasure(i) % 2 == 0){
                answer += i;
            } else 
                answer -= i;
        }
        return answer;
    }
}