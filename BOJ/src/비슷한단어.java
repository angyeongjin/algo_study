import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 비슷한단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] alpa = new int[26];
		int[] compAlpa = new int[26];
		int cnt = 0;

		char[] word = br.readLine().toCharArray();
		for (int i = 0; i < word.length; i++) {
			alpa[word[i]-'A']++;
		}

		f:for (int i = 0; i < n-1; i++) {
			char[] compWord = br.readLine().toCharArray();
			Arrays.fill(compAlpa, 0);

			for (int j = 0; j < compWord.length; j++) {
				compAlpa[compWord[j]-'A']++;
			}

			boolean isSimilWord = false;
			boolean isChange = false;
			int temp = 0;
			
			for (int j = 0; j < alpa.length; j++) {
				if (Math.abs(alpa[j]-compAlpa[j])==1) { // 알파벳 개수 차이가 1개일때
					if (isSimilWord) { // 이미 알파벳 개수 차이가 1개인 경우가 앞에서 발생했을 때
						if (isChange) // 알파벳 교체를 한번 썼기때문에 변경할수 없다
							continue f;
						if (temp+(alpa[j]-compAlpa[j])!=0) // 앞에서 발생한 한개의 개수차이를 현재 알파벳을 변경함으로 고칠 수 없으면
							continue f;
						else
							isChange = true; // 고칠수 있으면 알파벳 교체를 한번 수행했다고 침
					}

					isSimilWord = true; // 알파벳 개수차이가 1개인 경우가 생김
					temp = alpa[j]-compAlpa[j]; // 나중에 알파벳 개수가 1개인 경우가 생겼을 때 변경으로 고칠 수 있는지 검사하기 위해 사용
				}
				else if (Math.abs(alpa[j]-compAlpa[j])>1) // 다른 알파벳이 2개 이상이면 하나의 문자를 추가,삭제,변경해도 비슷한 알파벳이 될수없음
					continue f;
				// if 문에 걸리지 않으면 알파벳 개수가 같으므로 pass
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}
