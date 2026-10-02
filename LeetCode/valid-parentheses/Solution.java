class Solution {
    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        f: for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch(c) {
                case '(', '[', '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = false; break f;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = false; break f;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        result = false; break f;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) result = false;
        return result;
    }
}
