public class InfixToPostfix {

    static int prec(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;                                    // bukan operator
    }

    static boolean mustPop(Stack s, char c) {
        if (s.isEmpty()) return false;
        char t = (char) s.top();
        if (prec(t) == 0) return false;              // puncak = kurung buka
        return prec(t) > prec(c) || (prec(t) == prec(c) && c != '^');
    }

    public static String convert(String infix) {
        Stack s = new Stack();
        StringBuilder post = new StringBuilder();
        int i = 0;
        while (i < infix.length()) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {      // operand -> langsung output
                while (i < infix.length() && Character.isLetterOrDigit(infix.charAt(i)))
                    post.append(infix.charAt(i++));
                post.append(' ');
                continue;
            }
            if (ParenthesisChecker.isOpen(c)) {
                s.push(c);
            } else if (ParenthesisChecker.isClose(c)) {
                while (!s.isEmpty() && !ParenthesisChecker.isOpen((char) s.top()))
                    post.append(s.pop()).append(' ');
                if (!s.isEmpty()) s.pop();           // buang kurung buka
            } else if (prec(c) > 0) {                // operator
                while (mustPop(s, c))
                    post.append(s.pop()).append(' ');
                s.push(c);
            }
            i++;
        }
        while (!s.isEmpty()) post.append(s.pop()).append(' ');
        return post.toString().trim();
    }
}
