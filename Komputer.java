public class Komputer extends Data {
    private int ram;

    public Komputer(String nama, int ram) {
        super(nama);
        this.ram = ram;
    }

    public Komputer(String nama) {
        super(nama);
    }

    @Override
    public String toString() {
        return "Laptop " + getNama() + " (RAM: " + ram + " GB)";
    }
}