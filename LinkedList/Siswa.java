public class Siswa extends Data {
    private String nim;

    public Siswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
    }

    public Siswa(String nama) {
        super(nama);
    }

    @Override
    public String toString() {
        return "Mahasiswa: " + getNama() + " (NIM: " + nim + ")";
    }
}