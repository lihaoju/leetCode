import java.math.BigInteger;

/**
 * @program: learn
 * @description: 2、两数相加
 * @author: lihaoju
 * @create: 2018-10-23 11:02
 */
public class Code2 {

    public static void main(String[] args) {
        ListNode l1, l2, one;
        one = new ListNode(9);
        l1 = one;


        one = new ListNode(1);
        l2 = one;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);
        one = one.next;
        one.next = new ListNode(9);


        System.out.println(p(l1));
        System.out.println(p(l2));

        System.out.println(p(newAddTwoNumbers(l1, l2)));


    }

    public static String p (ListNode i) {
        String sr = "";
        while (i != null) {
            sr = sr + i.val + "->";
            i = i.next;
        }
        return sr;
    }

    public static ListNode newAddTwoNumbers(ListNode l1, ListNode l2) {

        int num, n1, n2, mod = 0;
        ListNode result = new ListNode(0);
        ListNode r = result;
        while(l1 != null || l2 != null) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;
            num = n1 + n2 + mod;
            mod = num/10;
            r.next = new ListNode(num % 10);
            r = r.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(mod > 0) {
            r.next = new ListNode(mod);
        }

        return result.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re;
        ListNode result = new ListNode(0);

        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        BigInteger num;
        BigInteger n = new BigInteger("1");
        re = l1;
        while(true) {
            if(null == re) {
                break;
            }
            num1 = num1.add(n.multiply(new BigInteger(re.val + "")));
            n = n.multiply(new BigInteger("10"));
            re = re.next;
        }
        re = l2;
        n = new BigInteger("1");
        while(true) {
            if(null == re) {
                break;
            }
            num2 = num2.add(n.multiply(new BigInteger(re.val + "")));
            n = n.multiply(new BigInteger("10"));
            re = re.next;
        }


        num = num1.add(num2);

        ListNode mod = null;
        int k = num.toString().length();
        for(int i =0; i < k; i++) {
            re = new ListNode(num.mod(new BigInteger("10")).intValue());
            num = num.divide(new BigInteger("10"));
            if(null == mod) {
                mod = re;
            }
            if(i == 0) {
                result = re;
            } else {
                mod.next = re;
                mod = mod.next;
            }
        }
        return result;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
