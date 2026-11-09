import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ketik ekspresi matematika (infix): ");
        String infix = input.nextLine().trim();

        if (!ParenthesisChecker.isBalanced(infix)) {
            System.out.println("Ekspresi ditolak karena tanda kurung tidak seimbang.");
            input.close();
            return;
        }

        System.out.println("Pemeriksaan kurung: valid");

        try {
            String postfix = InfixToPostfix.toPostfix(infix);
            System.out.println("Bentuk postfix: " + postfix);

            int jawaban = EvaluatePostfix.evaluate(postfix);
            System.out.println("Nilai perhitungan: " + jawaban);

        } catch (IllegalArgumentException | ArithmeticException error) {
            System.out.println("Tidak dapat memproses ekspresi: " + error.getMessage());
        } finally {
            input.close();
        }
    }
}
