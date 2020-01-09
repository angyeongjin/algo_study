import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 정식이의은행업무 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= t; ti++) {
			char[] binary = br.readLine().toCharArray();
			char[] ternary = br.readLine().toCharArray();
			char[] convBinary = binary.clone();
			char[] convTernary = ternary.clone();
			f:for (int i = 0; i < binary.length; i++) {
				for (int j = 0; j < 2; j++) {
					if (binary[i]-'0' != j) {
						convBinary[i] = (char) (j + '0');
						for (int k = 0; k < ternary.length; k++) {
							for (int l = 0; l < 3; l++) {
								if (ternary[k]-'0' != l) {
									convTernary[k] = (char) (l + '0');
									int binaryNum = Integer.parseInt(new String(convBinary), 2);
									int ternaryNum = Integer.parseInt(new String(convTernary), 3);
									if (binaryNum == ternaryNum) {
										bw.write("#" + ti + " " + binaryNum + "\n");
										break f;
									}
								}
							}
							convTernary[k] = ternary[k];
						}
					}
				}
				convBinary[i] = binary[i];
			}
		}
		bw.flush();
	}

}
