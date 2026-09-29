public class Main {
    public static void main(String[] args) {
        LinkedList listKomputer = new LinkedList();

        listKomputer.tambah(new Komputer("Asus ROG", 16));
        listKomputer.tambah(new Komputer("Lenovo Thinkpad", 8));
        listKomputer.tambah(new Komputer("Acer Swift", 8));

        System.out.println("=== DAFTAR KOMPUTER AWAL ===");
        listKomputer.tampilkan();

        System.out.println("\n=== PROSES MENGHAPUS ===");
        listKomputer.hapus(new Komputer("Lenovo Thinkpad"));

        System.out.println("\n=== DAFTAR KOMPUTER SETELAH DIHAPUS ===");
        listKomputer.tampilkan();
    }
}