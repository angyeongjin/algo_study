import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2 {
    static char[][] field;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new char[N][];
        int[] red = null;
        int[] blue = null;
        int[] hole = null;
        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'R') red = new int[]{i, j};
                else if (field[i][j] == 'B') blue = new int[]{i, j};
                else if (field[i][j] == 'O') hole = new int[]{i, j};
            }
        }
        System.out.println(bfs(red, blue, hole));
    }

    private static int bfs(int[] red, int[] blue, int[] hole) {
        Queue<int[]> redQueue = new LinkedList<>();
        Queue<int[]> blueQueue = new LinkedList<>();
        redQueue.offer(red);
        blueQueue.offer(blue);
        int cnt = 0;
        boolean flag = false;
        while (!redQueue.isEmpty()) {
            cnt++;
            int[] redMarble = redQueue.poll();
            int[] blueMarble = blueQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ty = redMarble[0];
                int tx = redMarble[1];
                int[] temp = null;
                field[ty][tx] = '.';
                while (true) {
                    ty += dy[i];
                    tx += dx[i];
                    if (field[ty][tx] == '#' || field[ty][tx] == 'B') {
                        ty -= dy[i];
                        tx -= dx[i];
                        field[ty][tx] = 'R';
                        temp = new int[]{ty, tx};
                        break;
                    } else if (field[ty][tx] == 'O') flag = true;
                }
                ty = blueMarble[0];
                tx = blueMarble[1];
                field[ty][tx] = '.';
                while (true) {
                    ty += dy[i];
                    tx += dx[i];
                    if (field[ty][tx] == '#' || field[ty][tx] == 'R') {
                        ty -= dy[i];
                        tx -= dx[i];
                        field[ty][tx] = 'B';
                        blueQueue.offer(new int[]{ty, tx});
                        break;
                    } else if (field[ty][tx] == 'O') return -1;
                }
                ty = temp[0];
                tx = temp[1];
                field[ty][tx] = '.';
                while (true) {
                    ty += dy[i];
                    tx += dx[i];
                    if (field[ty][tx] == '#' || field[ty][tx] == 'B') {
                        ty -= dy[i];
                        tx -= dx[i];
                        field[ty][tx] = 'R';
                        redQueue.offer(new int[]{ty, tx});
                        break;
                    } else if (field[ty][tx] == 'O') flag = true;
                }
            }
            if (cnt == 10) return -1;
            if (flag) break;
            for (char[] f : field) {
                System.out.println(Arrays.toString(f));
            }
        }
        return cnt;
    }
}
