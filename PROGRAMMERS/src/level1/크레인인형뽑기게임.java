package level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i]-1] != 0) { // 최상단에 인형이 있으면
                    //System.out.println(board[j][moves[i]-1]);
                    if (!basket.isEmpty() && basket.peek() == board[j][moves[i]-1]) { // 바구니 최상단 인형 종류가 같으면
                        //System.out.println(basket.peek());
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
