public class PalindromeChecker {

    public static boolean isPalindrome(String text) {
        Stack tumpukan = new Stack();
        Queue antrean = new Queue();

        for (int indeks = 0; indeks < text.length(); indeks++) {
            char karakter = text.charAt(indeks);

            if (Character.isLetterOrDigit(karakter)) {
                karakter = Character.toLowerCase(karakter);
                tumpukan.push(karakter);
                antrean.add(karakter);
            }
        }

        while (!antrean.isEmpty()) {
            char dariDepan = (Character) antrean.remove();
            char dariBelakang = (Character) tumpukan.pop();

            if (dariDepan != dariBelakang) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] daftarUji = {
            "katak",
            "kasur rusak",
            "A man, a plan, a canal: Panama",
            "hello",
            ""
        };

        for (String kalimat : daftarUji) {
            System.out.println("\"" + kalimat + "\" -> "
                    + (isPalindrome(kalimat) ? "Palindrome" : "Bukan palindrome"));
        }
    }
}
