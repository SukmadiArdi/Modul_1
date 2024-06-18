import java.util.Scanner;

public class Balok extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double panjang;
    private double lebar;
    private double tinggi;

    Balok(String nameBangun) {
        super(nameBangun);
    }

    @Override
    public void inputNilai() {
        System.out.println("Masukkan panjang balok :");
        panjang = scanner.nextDouble();
        System.out.println("Masukkan lebar balok :");
        lebar = scanner.nextDouble();
        System.out.println("Masukkan tinggi balok :");
        tinggi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double luasPermukaan = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        System.out.println("Luas permukaan balok adalah: " + luasPermukaan);
    }

    @Override
    public void volume() {
        double volume = panjang * lebar * tinggi;
        System.out.println("Volume balok adalah: " + volume);
    }
}


