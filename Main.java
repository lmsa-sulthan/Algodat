public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil();
        mobil.add("Avanza");
        mobil.add("Brio");
        mobil.add("Xenia");
        mobil.display();

        System.out.println();

        Sepeda sepeda = new Sepeda();
        sepeda.add("Polygon");
        sepeda.add("United");
        sepeda.add("Pacific");
        sepeda.display();
    }
}