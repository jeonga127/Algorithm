class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int tmp = arr1.length;
        int tmp1 = arr1[0].length;
        int[][] answer = new int[tmp][tmp1];
        
        for(int i = 0; i < tmp; i ++){
            for(int j = 0; j < tmp1; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}