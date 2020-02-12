import java.io.*;
import java.util.*;

public class 성곽 {
    static int[][] field;
    static int[][] fieldNum;
    static boolean[][] v;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int roomCnt = 0;
        List<Integer> roomSize = new ArrayList<>();
        int maxRoomSize = 0;
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        field = new int[n][m];
        fieldNum = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    roomSize.add(bfs(i, j, roomCnt)); // 가장 넓은 방 넣기
                    roomCnt++; // 방의 개수 카운트
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int ty = i + dy[k];
                    int tx = j + dx[k];
                        if (ty < 0 || n <= ty || tx < 0 || m <= tx) break;
                        if (fieldNum[ty][tx] != fieldNum[i][j]) {
                            maxRoomSize = Math.max(maxRoomSize, roomSize.get(fieldNum[ty][tx]) + roomSize.get(fieldNum[i][j]));
                            break;
                        }
                }
            }
        }
        bw.write(roomCnt+"\n"+Collections.max(roomSize)+"\n"+maxRoomSize);
        bw.flush();
    }

    private static int bfs(int y, int x, int num) {
        Queue<Idx> q = new LinkedList<>();
        fieldNum[y][x] = num;
        v[y][x] = true;
        q.offer(new Idx(y, x));
        int size = 0;
        while (!q.isEmpty()) {
            size++;
            Idx idx = q.poll();
            for (int i = 0; i < 4; i++) {
                int ty = idx.y + dy[i];
                int tx = idx.x + dx[i];
                if ((field[idx.y][idx.x] & (1 << i)) == 0 && !v[ty][tx]) {
                    fieldNum[ty][tx] = num;
                    v[ty][tx] = true;
                    q.offer(new Idx(ty, tx));
                }
            }
        }
        return size;
    }

    private static class Idx {
        int y;
        int x;

        public Idx(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
