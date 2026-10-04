import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 한번 쭉 돌아서 개수 세면서, 가장 큰거 n 개 저장?
        // nlogn + n

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Node node;
            if (map.containsKey(nums[i])) {
                node = map.get(nums[i]); node.cnt++;
            } else {
                map.put(nums[i], new Node(nums[i], 1));
            }
        }

        List<Node> nodes = new ArrayList<>(map.values());
        nodes.sort(Comparator.comparingInt((Node n) -> n.cnt).reversed());

        int[] result = new int[k];
        for (int i = 0; i < result.length; ++i) {
            result[i] = nodes.get(i).n;
        }
        return result;
    }

    
}

class Node {
    int n;
    int cnt;

    Node(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
}
