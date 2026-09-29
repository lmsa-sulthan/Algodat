public class Main {
    public static void main(String[] args) {
        LinkedList listKomputer = new LinkedList();
        listKomputer.tambah(new Komputer("Asus ROG", 16));
        listKomputer.tambah(new Komputer("Lenovo Thinkpad", 8));

        LinkedList listSiswa = new LinkedList();
        listSiswa.tambah(new Siswa("Budi Santoso", "F1D026001"));
        listSiswa.tambah(new Siswa("Andi Wijaya", "F1D026002"));

        System.out.println("=== DAFTAR KOMPUTER ===");
        listKomputer.tampilkan();

        System.out.println("\n=== DAFTAR SISWA ===");
        listSiswa.tampilkan();

        System.out.println("\n=== PROSES MENGHAPUS SISWA ===");
        listSiswa.hapus(new Siswa("Budi Santoso"));
        listSiswa.tampilkan();
    }
}