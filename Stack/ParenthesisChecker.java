import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {

    private static char pasanganPembuka(char penutup) {
        switch (penutup) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: return '\0';
        }
    }

    public static boolean isBalanced(String teks) {
        Deque<Character> pembuka = new ArrayDeque<>();

        for (char simbol : teks.toCharArray()) {
            if (simbol == '(' || simbol == '[' || simbol == '{') {
                pembuka.push(simbol);
            } else if (simbol == ')' || simbol == ']' || simbol == '}') {
                if (pembuka.isEmpty()) {
                    return false;
                }

                char terakhir = pembuka.pop();
                if (terakhir != pasanganPembuka(simbol)) {
                    return false;
                }
            }
        }

        return pembuka.isEmpty();
    }

    public static void main(String[] args) {
        String[] contoh = {
            "(p + q) * (r - s)",
            "{[a + b] * c}",
            "((x + y)",
            "m + n)",
            "([x + y)]",
            ""
        };

        for (String ekspresi : contoh) {
            String status = isBalanced(ekspresi) ? "Seimbang" : "Tidak seimbang";
            System.out.println(ekspresi + " : " + status);
        }
    }
}
