public class ParenthesisChecker {

    static boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    static boolean isClose(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    static boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static boolean check(String expr) {
        Stack s = new Stack();
        for (char c : expr.toCharArray()) {
            if (isOpen(c)) {
                s.push(c);
            } else if (isClose(c)) {
                if (s.isEmpty()) return false;       // tidak ada kurung buka
                char open = (char) s.pop();
                if (!isPair(open, c)) return false;  // pasangan tidak cocok
            }
        }
        return s.isEmpty();                          // valid jika stack kosong
    }
}
