public class Mahasiswa {
    private String nama;
    private String nim;
    private String prodi;
    private String fakultas;

    public Mahasiswa(String nama, String nim, String prodi, String fakultas) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }

    public Mahasiswa(String nama, String nim) {
        this(nama, nim, "Belum ditentukan", "Belum ditentukan");
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getProdi() {
        return prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Program Studi: " + prodi);
        System.out.println("Fakultas: " + fakultas);
    }
}
