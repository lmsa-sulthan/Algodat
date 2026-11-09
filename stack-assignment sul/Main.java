public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Checking Parenthesis ===");
        String[] p = { "{x+(y-[a+b])}", "{x+(y-[a+b]}", "((a+b)", "a+b)" };
        for (String e : p)
            System.out.println(e + " -> " + (ParenthesisChecker.check(e) ? "VALID" : "TIDAK VALID"));

        System.out.println("\n=== 2. Infix to Postfix ===");
        String[] f = { "6 - (2 + 3) * 3", "6 + 2 / 3 * 3", "6 + 2 / 3 ^ 3", "{6 + [(2 / 3) * 3]}" };
        for (String e : f)
            System.out.println(e + " -> " + InfixToPostfix.convert(e));

        System.out.println("\n=== 3. Evaluating Postfix ===");
        String q = "6 2 3 + - 3 8 2 / + *";
        System.out.println(q + " = " + PostfixEvaluator.evaluate(q));
    }
}
