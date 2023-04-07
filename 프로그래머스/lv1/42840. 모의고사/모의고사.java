import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = {0, 0, 0};
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == pattern1[i%5])
                answer[0]++;
            if(answers[i] == pattern2[i%8])
                answer[1]++;
            if(answers[i] == pattern3[i%10])
                answer[2]++;
        }
        
        int max = answer[0];
        for(int a : answer){
            if( max < a)
                max = a;
        }
        
        List<Integer> correct = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if( answer[i] == max)
                correct.add(i+1);
        }
        
        return correct;
    }
}