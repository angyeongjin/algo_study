import java.io.*;
import java.util.*;

public class 올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(num, gold, silver, bronze));
        }
        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country m1, Country m2) {
                if (m1.gold != m2.gold) return m2.gold - m1.gold;
                else if (m1.silver != m2.silver) return m2.silver - m1.silver;
                else return m2.bronze - m1.bronze;
            }
        });
        int rank = 1;
        int sameRank = 1;
        int result = -1;
        Country pre = list.get(0);
        if (pre.num == K) result = rank;
        else {
            for (int i = 1; i < list.size(); i++) {
                Country curr = list.get(i);
                if (pre.gold == curr.gold && pre.silver == curr.silver && pre.bronze == curr.bronze) {
                    sameRank++;
                } else {
                    rank += sameRank;
                    sameRank = 1;
                }
                if (curr.num == K) {
                    result = rank;
                    break;
                }
                pre = curr;
            }
        }
        bw.write(result+"");
        bw.flush();
    }

    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
