import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {

    public static String toPostfix(String ekspresi) {
        StringBuilder hasil = new StringBuilder();
        Deque<Character> operator = new ArrayDeque<>();

        for (int posisi = 0; posisi < ekspresi.length(); posisi++) {
            char simbol = ekspresi.charAt(posisi);

            if (Character.isWhitespace(simbol)) {
                continue;
            }

            if (Character.isLetterOrDigit(simbol)) {
                StringBuilder operand = new StringBuilder();

                while (posisi < ekspresi.length()
                        && Character.isLetterOrDigit(ekspresi.charAt(posisi))) {
                    operand.append(ekspresi.charAt(posisi));
                    posisi++;
                }
                posisi--;

                tambahOperand(hasil, operand.toString());

            } else if (simbol == '(') {
                operator.push(simbol);

            } else if (simbol == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    hasil.append(' ').append(operator.pop());
                }

                if (operator.isEmpty()) {
                    throw new IllegalArgumentException("Tanda kurung tidak cocok");
                }
                operator.pop();

            } else if (isOperator(simbol)) {
                while (!operator.isEmpty() && operator.peek() != '('
                        && harusDikeluarkan(operator.peek(), simbol)) {
                    hasil.append(' ').append(operator.pop());
                }
                operator.push(simbol);

            } else {
                throw new IllegalArgumentException("Simbol tidak dikenal: " + simbol);
            }
        }

        while (!operator.isEmpty()) {
            char sisa = operator.pop();
            if (sisa == '(') {
                throw new IllegalArgumentException("Tanda kurung tidak cocok");
            }
            hasil.append(' ').append(sisa);
        }

        return hasil.toString().trim();
    }

    private static void tambahOperand(StringBuilder tujuan, String operand) {
        if (tujuan.length() > 0) {
            tujuan.append(' ');
        }
        tujuan.append(operand);
    }

    private static boolean harusDikeluarkan(char atas, char sekarang) {
        return prioritas(atas) > prioritas(sekarang)
                || (prioritas(atas) == prioritas(sekarang)
                    && sekarang != '^');
    }

    private static boolean isOperator(char simbol) {
        return "+-*/%^".indexOf(simbol) >= 0;
    }

    private static int prioritas(char simbol) {
        switch (simbol) {
            case '^': return 3;
            case '*':
            case '/':
            case '%': return 2;
            case '+':
            case '-': return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String[] contoh = {
            "a+b*c",
            "(a+b)*c",
            "x+y*(z^w-v)^(p+q*r)-s",
            "3+4*2/(1-5)^2^3"
        };

        for (String ekspresi : contoh) {
            System.out.println(ekspresi + " => " + toPostfix(ekspresi));
        }
    }
}
