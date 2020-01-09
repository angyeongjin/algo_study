import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SmallWorldNetwork {
    static Network[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new Network[N+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Network();
        }
        for (int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].connect.add(graph[n2]);
            graph[n2].connect.add(graph[n1]);
        }
        String result = "Small World!";
        for (int i = 1; i < graph.length; i++) {
            init();
            go(0, graph[i]);
            if (!check()) {
                result = "Big World!";
                break;
            }
        }
        bw.write(result);
        bw.flush();
    }

    private static boolean check() {
        for(int i = 1; i < graph.length; i++) {
            if (!graph[i].visited) return false;
        }
        return true;
    }

    private static void go(int depth, Network curr) {
        curr.visited = true;
        if (depth == 6) return;
        for (Network next : curr.connect) {
            if (!next.visited) {
                go(depth + 1, next);
            }
        }
    }

    static void init() {
        for (int i = 1; i < graph.length; i++) {
            graph[i].visited = false;
        }
    }
    static class Network { // 정점
        List<Network> connect = new LinkedList<>(); // 간선
        boolean visited;
    }
}
