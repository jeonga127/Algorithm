class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";
        for(int i = 1; i < food.length; i++){
            while(true){
                if(food[i] <= 1)
                    break;
                else{
                    answer += Integer.toString(i);
                    reverse = Integer.toString(i) + reverse;
                    food[i] -= 2;
                }
            }
        }
        answer = answer + "0" + reverse;
        return answer;
    }
}