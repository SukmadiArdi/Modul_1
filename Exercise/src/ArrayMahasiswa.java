import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMahasiswa {
    private ArrayList<Mahasiswa> daftarMahasiswa;

    public ArrayMahasiswa() {
        daftarMahasiswa = new ArrayList<>();
    }

    public void tambahMahasiswa() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("NIM: ");
        String nim = input.nextLine();
        System.out.print("Program Studi: ");
        String prodi = input.nextLine();
        System.out.print("Fakultas: ");
        String fakultas = input.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, prodi, fakultas);
        daftarMahasiswa.add(mahasiswa);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public void hapusMahasiswa(String nim) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                daftarMahasiswa.remove(i);
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void displayMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Daftar mahasiswa kosong.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                mahasiswa.tampilkanInfo();
                System.out.println("--------------------");
            }
        }
    }
}
