class mid_6_ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String answer = "PAHNAPLSIIGYIR";
        if (convert(s, numRows).equals(answer))
            System.out.println("Accepted!");
        else
            System.out.println("Wrong Answer");
    }

    static public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder result = new StringBuilder();
        int idx = 0;
        int a = 2 * numRows - 2;
        int b = 0;
        for (int i = 0; i < numRows; ++i) {
            idx = i;
            result.append(s.charAt(idx));
            while(idx < s.length()) {
                if (a != 0) {
                    if (idx+a >= s.length()) break;
                    idx += a;
                    result.append(s.charAt(idx));
                }
                if (b != 0) {
                    if (idx+b >= s.length()) break;
                    idx += b;
                    result.append(s.charAt(idx));
                }
            }
            a-=2;
            b+=2;
        }
        return result.toString();
    }
}