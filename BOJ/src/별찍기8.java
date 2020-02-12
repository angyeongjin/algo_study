import java.io.*;

public class 별찍기8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-i; j > 0; j--) {
                bw.write("*");
            }
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j <= i-1; j++) {
                bw.write(" ");
            }
            for (int j = N-i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = 1; i <= N; i++) {
            for (int j = N-i; j > 0; j--) {
                bw.write("*");
            }
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j <= i-1; j++) {
                bw.write(" ");
            }
            for (int j = N-i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
