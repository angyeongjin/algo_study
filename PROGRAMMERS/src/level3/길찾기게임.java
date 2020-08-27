package level3;

import java.util.*;

public class 길찾기게임 {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        //int[][] nodeinfo = {{2, 2}};
        int[][] result = solution(nodeinfo);
        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));
    }

    public static int[][] solution(int[][] nodeinfo) {
        // 입력값을 y좌표순 정렬
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.offer(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]));
        }
        Node root = nodes.poll();
        Node curr = root;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            while (true) {
                if (node.x < curr.x ) {
                    if (curr.leftChild == null) {
                        curr.leftChild = node;
                        curr = root;
                        break;
                    } else {
                        curr = curr.leftChild;
                    }
                } else if (node.x > curr.x) {
                    if (curr.rightChild == null) {
                        curr.rightChild = node;
                        curr = root;
                        break;
                    } else {
                        curr = curr.rightChild;
                    }
                }
            }
        }
        int[][] answer = new int[2][];
        answer[0] = preorder(new int[nodeinfo.length], root, nodeinfo.length);
        answer[1] = postorder(new int[nodeinfo.length], root, nodeinfo.length);
        return answer;
    }

    static int preIdx = -1;

    static int[] preorder(int[] arr, Node node, int N) {
        if (preIdx >= N-1) return arr;
        arr[++preIdx] = node.num;
        if (node.leftChild != null) preorder(arr, node.leftChild, N);
        if (node.rightChild != null)preorder(arr, node.rightChild, N);
        return arr;
    }

    static int postIdx = -1;

    static int[] postorder(int[] arr, Node node, int N) {
        if (node.leftChild != null) postorder(arr, node.leftChild, N);
        if (node.rightChild != null)postorder(arr, node.rightChild, N);
        if (postIdx >= N-1) return arr;
        arr[++postIdx] = node.num;
        return arr;
    }

    static class Node implements Comparable<Node> {
        int num;
        int y;
        int x;
        Node parents;
        Node leftChild;
        Node rightChild;

        public Node(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node node) {
            return node.y - this.y;
        }
    }
}
