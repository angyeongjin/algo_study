import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class 냉장고 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
         
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
         
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if (o1[0] == o2[0]) return o2[1] - o1[1];
            	else return o1[0] - o2[0];
            }
        });
         
        int end = -271;
        int cnt = 0;
         
        for (int i = 0; i < list.size(); i++) {
            int[] chemical = list.get(i);
            if (chemical[0] > end) {
                end = chemical[1];
                cnt++;
            }
            if (chemical[1] < end)
            	end = chemical[1];
        }
         
        System.out.println(cnt);
    }
}