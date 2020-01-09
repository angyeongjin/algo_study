import java.io.*;
import java.util.*;

public class 불느낌표 {
    static char[][] field;
    static int R;
    static int C;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][];
        Idx jihun = null;
        List<Idx> fire = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (field[i][j] == 'J') {
                    jihun = new Idx(i, j);
                } else if (field[i][j] == 'F') {
                    fire.add(new Idx(i, j));
                }
            }
        }
        bw.write(bfs(jihun, fire));
        bw.flush();
    }

    private static String bfs(Idx jihun, List<Idx> fire) {
        Queue<Idx> jq = new LinkedList<>();
        Queue<Idx> fq = new LinkedList<>();
        field[jihun.y][jihun.x] = ',';
        jq.offer(jihun);
        for (Idx f : fire) {
            fq.offer(f);
        }
        int cnt = 0;
        while (!jq.isEmpty()) {
            cnt++;
            int fsize = fq.size();
            for (int i = 0; i < fsize; i++) {
                Idx fp = fq.poll();
                for (int j = 0; j < 4; j++) {
                    int ty = fp.y + dy[j];
                    int tx = fp.x + dx[j];
                    if (ty < 0 || ty >= R || tx < 0 || tx >= C) continue;
                    if (field[ty][tx] == '.' || field[ty][tx] == ',') {
                        field[ty][tx] = 'F';
                        fq.offer(new Idx(ty, tx));
                    }
                }
            }
            int jsize = jq.size();
            for (int i = 0; i < jsize; i++) {
                Idx jp = jq.poll();
                for (int j = 0; j < 4; j++) {
                    int ty = jp.y + dy[j];
                    int tx = jp.x + dx[j];
                    if (ty < 0 || ty >= R || tx < 0 || tx >= C) return String.valueOf(cnt);
                    if (field[ty][tx] == '.') {
                        field[ty][tx] = ',';
                        jq.offer(new Idx(ty, tx));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static class Idx {
        int y;
        int x;

        public Idx(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
