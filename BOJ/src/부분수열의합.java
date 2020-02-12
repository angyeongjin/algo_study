import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        result = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            comb(0, 0, 0, i, S);
        }
        bw.write(result+"");
        bw.flush();
    }

    private static void comb(int select, int depth, int sum, int N, int S) {
        if (select == N) {
            if (sum == S) result++;
            return;
        }
        if (depth >= arr.length) return;
        comb(select+1, depth+1, sum+arr[depth], N, S);
        comb(select, depth+1, sum, N, S);
    }
}
