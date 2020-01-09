package kakao2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kakao2019_04 {
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = solution(words, queries);
		System.out.println(Arrays.toString(answer));
	}

    public static int[] solution(String[] words, String[] queries) {
    	int[] answer = new int[queries.length];
    	Trie preTrie = new Trie(1);
    	Trie postTrie = new Trie(-1);
    	for (int i = 0; i < words.length; i++) {
    		preTrie.add(words[i]);
    	}
    	for (int i = 0; i < words.length; i++) {
    		postTrie.add(words[i]);
    	}
    	for (int i = 0; i < queries.length; i++) {
    		if (!map.containsKey(queries[i])) {
				if (queries[i].charAt(0) != '?')
					answer[i] = preTrie.count(queries[i]);
				else {
					answer[i] = postTrie.count(queries[i]);
				}
				map.put(queries[i], answer[i]);
			} else {
				answer[i] = map.get(queries[i]);
			}
    	}
        return answer;
    }
    
    static class Trie {
    	Node root;
    	int next;
    	
    	public Trie(int next) {
    		root = new Node();
    		this.next = next;
    	}
    	
    	public int count(String str) {
    		if (next == 1)
    			return root.count(str, 0, next);
    		else
    			return root.count(str, str.length()-1, next);
		}
    	
		public void add(String str) {
			if (next == 1)
				root.saveStr(str, 0, next);
			else
				root.saveStr(str, str.length()-1, next);
    	}
    	
    }
    
    static class Node {
    	char data;
    	Node[] nodes;
    	String word;
    	
    	public Node() {
    		nodes = new Node[26];
    	}
    	
    	public int count(String str, int idx, int next) {
    		int cnt = 0;
    		if (idx == str.length() || idx == -1) {
    			if (word != null) {
    				cnt = 1;
    			}
    		} else {
    			int data = str.charAt(idx)-'a';
				if (str.charAt(idx) != '?') {
					if (nodes[data] != null) {
						cnt = nodes[data].count(str, idx+next, next);
					}
				} else {
					for (int i = 0; i < 26; i++) {
						if (nodes[i] != null)
						cnt += nodes[i].count(str, idx+next, next);
					}
				}
			}
			return cnt;
		}
    	
		public void saveStr(String str, int idx, int next) {
    		if (idx == str.length() || idx == -1) {
    			this.word = str;
    		} else {
    			int data = str.charAt(idx)-'a';
    			if (nodes[data] == null)
    				nodes[data] = new Node();
    			nodes[data].saveStr(str, idx+next, next);
    		}
    	}
    }
}
