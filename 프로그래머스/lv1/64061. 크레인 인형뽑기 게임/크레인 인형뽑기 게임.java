import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves){
            for(int i = 0; i < N; i++){
                if(board[i][m-1] != 0){
                    if(!stack.isEmpty() && board[i][m-1] == stack.peek()){
                        stack.pop();
                        answer += 2;
                    }
                    else
                        stack.push(board[i][m-1]);
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}