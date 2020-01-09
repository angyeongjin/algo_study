import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int ti = 1; ti <= t; ti++) {
			int n = Integer.parseInt(br.readLine());
			String[] shuffleDeck = new String[n]; // ī�嵦
			String[] str = br.readLine().split(" ");

			if (n % 2 == 0) {
				int j = 0;
				for (int i = 0; i < str.length/2; i++) { // �Է¹��� ī�嵦 �տ������� ���ݱ��� 
					shuffleDeck[j] = str[i]; // ����ī�嵦 0���� 2�� �����ؼ� ����ֱ�
					j+=2;
				}

				j = 1;
				for (int i = str.length/2; i < str.length; i++) { // �Է¹��� ī�嵦 ���ݺ��� ������
					shuffleDeck[j] = str[i];
					j+=2;
				}
			}
			else {
				int j = 0;
				for (int i = 0; i < str.length/2+1; i++) { // �Է¹��� ī�嵦 �տ������� ���ݱ��� 
					shuffleDeck[j] = str[i]; // ����ī�嵦 0���� 2�� �����ؼ� ����ֱ�
					j+=2;
				}

				j = 1;
				for (int i = str.length/2+1; i < str.length; i++) { // �Է¹��� ī�嵦 ���ݺ��� ������
					shuffleDeck[j] = str[i];
					j+=2;
				}
			}

			System.out.print("#" + ti + " ");
			for (String card : shuffleDeck) {
				System.out.print(card + " ");
			}
			System.out.println();
		}
	}
}
