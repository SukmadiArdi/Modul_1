public class Kucing {
    public String Nama = "Bilqis";
    public String Namapanggilan = "Qies";
    public int Umur = 2;
    public String Makanan = "Makanan Kucing";

    public void display() {
        System.out.println("Nama Kucing: " + Nama);
        System.out.println("Nama Panggilan: " + Namapanggilan);
        System.out.println("Umur Kucing: " + Umur);
        System.out.println("Makanan Favorit: " + Makanan);
    }

    public static void main(String[] args) {
        // Create an instance of the Kucing class
        Kucing kucingInstance = new Kucing();

        // Call the display method to see the output
        kucingInstance.display();
    }
}
