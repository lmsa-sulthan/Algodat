public class PostfixEvaluator {

    public static double evaluate(String postfix) {
        Stack s = new Stack();
        for (String t : postfix.trim().split("\\s+")) {
            if (t.length() == 1 && InfixToPostfix.prec(t.charAt(0)) > 0) {
                double b = (double) s.pop();         // operand 2
                double a = (double) s.pop();         // operand 1
                double v = 0;
                switch (t.charAt(0)) {
                    case '+': v = a + b; break;
                    case '-': v = a - b; break;
                    case '*': v = a * b; break;
                    case '/': v = a / b; break;
                    case '^': v = Math.pow(a, b); break;
                }
                s.push(v);
            } else {
                s.push(Double.parseDouble(t));
            }
        }
        return (double) s.pop();
    }
}
