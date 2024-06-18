import java.util.Scanner;

public class LoginLibrary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login Library");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih jenis pengguna: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        if (pilihan == 1) {
            // Login Admin
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                System.out.println("Login berhasil sebagai admin!");
                // Lanjutkan ke halaman/fitur admin
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        } else if (pilihan == 2) {
            // Login Mahasiswa
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            if (nim.length() == 15) {
                System.out.println("Login berhasil sebagai mahasiswa!");
                // Lanjutkan ke halaman/fitur mahasiswa
            } else {
                System.out.println("Login gagal. NIM harus terdiri dari 15 karakter.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
