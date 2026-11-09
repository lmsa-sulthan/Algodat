public abstract class Data {
    private String nama;

    public Data(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return nama;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Data dataLain = (Data) obj;
        return nama.equals(dataLain.nama);
    }
}