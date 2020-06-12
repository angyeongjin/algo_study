import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{1,2},{1}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        System.out.println(s.substring(2, s.length()-2));
        String[] temp = s.substring(2, s.length()-2).split("},\\{");
        List<Sets> list = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            list.add(new Sets(temp[i].split(",")));
        }
        Collections.sort(list);
        for (Sets set : list) {
            System.out.println(Arrays.toString(set.arr));
        }
        int[] answer = new int[list.size()];
        boolean[] v = new boolean[list.size()+1];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).arr.length; j++) {
                if (!v[Integer.parseInt(list.get(i).arr[j])]) {
                    System.out.println(Integer.parseInt(list.get(i).arr[j]));
                    answer[i] = Integer.parseInt(list.get(i).arr[j]);
                    v[Integer.parseInt(list.get(i).arr[j])] = true;
                    break;
                }
            }
            System.out.println(Arrays.toString(v));
        }
        return answer;
    }

    static class Sets implements Comparable<Sets> {
        String[] arr;
        public Sets(String[] arr) {
            this.arr = arr;
        }

        @Override
        public int compareTo(Sets sets) {
            return this.arr.length - sets.arr.length;
        }
    }
}
