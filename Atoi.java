import java.util.Stack;

public class Atoi {
    public static void main(String[] args) {
        int res = myAtoi("20000000000000000000");
        System.out.println("result is：" + res);
    }
    public static int myAtoi(String str) {
        Stack<Character> s = new Stack<>();
        String tmpStr = str.strip();
        char x;
        boolean overflow = false;
        boolean negative = false;
        boolean firstNonZero = false;
        long res = 0;
        for (int i = 0, len = tmpStr.toCharArray().length; i < len; i++) {
            x = tmpStr.charAt(i);
            if (i == 0) {
                if (x == '0') {
                    if (firstNonZero)
                        s.push(x);
                }
                else if (x > '0' && x <= '9') {
                    if (!firstNonZero) firstNonZero = true;
                    s.push(x);
                }
                else if (x == '-') negative = true;
                else if (x == '+');
                else break;

            } else {
                if (x == '0') {
                    if (firstNonZero)
                        s.push(x);
                }
                else if (x > '0' && x <= '9') {
                    if (!firstNonZero) {
                        firstNonZero = true;
                    }
                    s.push(x);
                }
                else break;
            }
        }
        System.out.println(s.toString());
        long step;
        long cur;
        for (int j = 0, len = s.size(); j < len; j++) {
            step = (int) Math.pow(10, j);
            cur = (s.pop() - 48) * step;
            if (Integer.MAX_VALUE < cur + res) {
                overflow = true;
                break;
            }


            res += cur;
        }
        if (overflow && negative)
            res = Integer.MIN_VALUE;
        else if (overflow && !negative)
            res = Integer.MAX_VALUE;
        else {
            res = negative ? -res : res;
        }

        return (int)res;
    }
}
