class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int idk = 0;
        int correct = 0;
        for(int l : lottos){
            if(l == 0){
                idk += 1;
                continue;
            } else{
                 for(int w : win_nums){
                    if(l == w){
                        correct += 1;
                    }
                }
            }
        }
        
        answer[0] = correct+idk>1? 7-correct-idk : 6;
        answer[1] = correct>1? 7-correct : 6;
        return answer;
    }
}