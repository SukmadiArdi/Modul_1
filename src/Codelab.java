import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Codelab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelaminSingkatan = scanner.nextLine().toUpperCase();
        String jenisKelaminLengkap = "";
        if (jenisKelaminSingkatan.equals("P")) {
            jenisKelaminLengkap = "Perempuan";
        } else if (jenisKelaminSingkatan.equals("L")) {
            jenisKelaminLengkap = "Laki-laki";
        } else {
            System.out.println("Jenis kelamin tidak valid!");
            return;
        }

        System.out.print("Masukkan tanggal lahir (YYYY-MM-DD): ");
        String tanggalLahirStr = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        LocalDate today = LocalDate.now();
        Period period = Period.between(tanggalLahir, today);
        int umur = period.getYears();

        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Tanggal Lahir: " + tanggalLahirStr);
        System.out.println("Umur: " + umur + " tahun");
    }
}
