class Solution {
    public int solution(int[][] sizes) {
        int[] garo = new int[sizes.length];
        int[] sero = new int[sizes.length];
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                garo[i] = sizes[i][0];
                sero[i] = sizes[i][1];
            } else{
                sero[i] = sizes[i][0];
                garo[i] = sizes[i][1];
            }
        }
        
        int max_garo = garo[0];
        int max_sero = sero[0];
        for(int i = 1; i < garo.length; i++){
            if(max_garo < garo[i])
                max_garo = garo[i];
            if(max_sero < sero[i])
                max_sero = sero[i];
        }
        return max_garo*max_sero;
    }
}