import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputDataDiri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Nama Lengkap: ");
        String nama = input.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");
        String jenisKelamin = input.nextLine().toUpperCase(); // Konversi ke huruf besar

        System.out.print("Tanggal Lahir (dd-MM-yyyy): ");
        LocalDate tanggalLahir = LocalDate.parse(input.nextLine(), formatter);

        // Hitung umur
        LocalDate sekarang = LocalDate.now();
        Period umur = Period.between(tanggalLahir, sekarang);

        // Output
        System.out.println("\nData Diri Anda:");
        System.out.println("Nama Lengkap: " + nama);
        System.out.println("Jenis Kelamin: " + (jenisKelamin.equals("L") ? "Laki-laki" : "Perempuan"));
        System.out.println("Tanggal Lahir: " + tanggalLahir.format(formatter));
        System.out.println("Umur: " + umur.getYears() + " tahun " + umur.getMonths() + " bulan " + umur.getDays() + " hari ");

        input.close();
    }
}
