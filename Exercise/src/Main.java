import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayMahasiswa daftar = new ArrayMahasiswa();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nPilih aksi:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Tampilkan Mahasiswa");
            System.out.println("4. Keluar");

            System.out.print("Pilihan Anda: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Membersihkan newline

            if (pilihan == 1) {
                daftar.tambahMahasiswa();
            } else if (pilihan == 2) {
                System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                String nim = input.nextLine();
                daftar.hapusMahasiswa(nim);
            } else if (pilihan == 3) {
                daftar.displayMahasiswa();
            } else if (pilihan == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
