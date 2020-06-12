import java.util.Arrays;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6, 6, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] board2 = new char[m][];
        init(board, board2); // String 배열을 char 2차원배열로 바꿔서 로직 수행
        boolean[][] delete = new boolean[m][n];
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    // 4개의 블록을 검사
                    if (    board2[i][j] != '-'
                            && board2[i][j] == board2[i + 1][j]
                            && board2[i][j] == board2[i][j + 1]
                            && board2[i][j] == board2[i + 1][j + 1]) {
                        delete[i][j] = true;
                        delete[i + 1][j] = true;
                        delete[i][j + 1] = true;
                        delete[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer += delete(m, n, board2, delete);
            initDelete(delete);
            // 디버깅용 주석 코드
//            for (int i = 0; i < m; i++) {
//                System.out.println(Arrays.toString(board2[i]));
//            }
//            System.out.println();
        } while (flag);
        return answer;
    }

    private static int delete(int m, int n, char[][] board, boolean[][] delete) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (delete[i][j]) {
                    board[i][j] = '-';
                    cnt++;
                }
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int y = i;
                while (y < m-1) {
                    if ('A' > board[y][j] || board[y][j] > 'Z') break;
                    if (board[y + 1][j] != '-') break;
                    board[y + 1][j] = board[y][j];
                    board[y][j] = '-';
                    y++;
                }
            }
        }
        return cnt;
    }

    private static void initDelete(boolean[][] delete) {
        for (int i = 0; i < delete.length; i++) {
            Arrays.fill(delete[i], false);
        }
    }

    private static void init(String[] board, char[][] board2) {
        for (int i = 0; i < board.length; i++) {
            board2[i] = board[i].toCharArray();
        }
    }
}
