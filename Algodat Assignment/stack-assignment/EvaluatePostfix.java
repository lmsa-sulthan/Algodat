import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluatePostfix {

    public static int evaluate(String ekspresi) {
        Deque<Integer> nilai = new ArrayDeque<>();
        String teks = ekspresi.trim();

        if (teks.isEmpty()) {
            throw new IllegalArgumentException("Ekspresi masih kosong");
        }

        for (String bagian : teks.split("\\s+")) {
            if (bagian.length() == 1 && isOperator(bagian.charAt(0))) {
                if (nilai.size() < 2) {
                    throw new IllegalArgumentException("Susunan postfix tidak valid");
                }

                int kanan = nilai.pop();
                int kiri = nilai.pop();
                nilai.push(hitung(kiri, kanan, bagian.charAt(0)));
            } else {
                try {
                    nilai.push(Integer.parseInt(bagian));
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Operand bukan bilangan: " + bagian);
                }
            }
        }

        if (nilai.size() != 1) {
            throw new IllegalArgumentException("Susunan postfix tidak valid");
        }

        return nilai.pop();
    }

    private static int hitung(int x, int y, char operator) {
        switch (operator) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/': return x / y;
            case '%': return x % y;
            case '^': return (int) Math.pow(x, y);
            default:
                throw new IllegalArgumentException("Operator tidak didukung: " + operator);
        }
    }

    private static boolean isOperator(char simbol) {
        return "+-*/%^".indexOf(simbol) >= 0;
    }

    public static void main(String[] args) {
        String[] contoh = {
            "23 4 * 5 +",
            "5 6 2 + * 12 4 / -",
            "2 3 ^",
            "10 2 /"
        };

        for (String postfix : contoh) {
            System.out.println(postfix + " = " + evaluate(postfix));
        }
    }
}
