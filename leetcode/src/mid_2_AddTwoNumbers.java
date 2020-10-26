import java.math.BigInteger;

class mid_2_AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger n1 = reverseToInt(l1);
        BigInteger n2 = reverseToInt(l2);

        BigInteger sum = n1.add(n2);

        ListNode answer = new ListNode();
        ListNode curr = answer;

        while (true) {
            curr.val = sum.mod(new BigInteger("10")).intValue();
            sum = sum.divide(new BigInteger("10"));
            if (sum.compareTo(new BigInteger("0")) == 0) break;
            curr.next = new ListNode();
            curr = curr.next;
        }

        return answer;
    }

    public BigInteger reverseToInt (ListNode l) {
        BigInteger num = new BigInteger("0");
        BigInteger multipleTen = new BigInteger("1");
        ListNode curr = l;
        while (curr != null) {
            num = num.add(new BigInteger(String.valueOf(curr.val)).multiply(multipleTen));
            multipleTen = multipleTen.multiply(new BigInteger("10"));
            curr = curr.next;
        }
        return num;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}