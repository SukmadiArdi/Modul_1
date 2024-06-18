public class AdminBank {
    private String pemilik;
    private String nomorAkun;
    private int saldo;

    public AdminBank(String pemilik, String nomorAkun, int saldo) {
        this.pemilik = pemilik;
        this.nomorAkun = nomorAkun;
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        AdminBank akun1 = new AdminBank("Budi", "123456", 1000000);
        AdminBank akun2 = new AdminBank("Ani", "789012", 500000);

        System.out.println("Saldo awal:");
        akun1.display();
        akun2.display();

        System.out.println("\nTransaksi:");
        akun1.penarikan(200000);
        akun1.transfer(300000, "Ani", akun2);
        akun2.setor(100000);

        // Contoh transfer yang gagal karena saldo tidak cukup
        akun1.transfer(700000, "Ani", akun2);

        // Contoh penarikan yang gagal karena jumlah tidak valid
        akun1.penarikan(-50000);

        System.out.println("\nSaldo akhir:");
        akun1.display();
        akun2.display();
    }

    // Getter untuk pemilik
    public String getPemilik() {
        return pemilik;
    }

    // Getter untuk nomorAkun
    public String getNomorAkun() {
        return nomorAkun;
    }

    // Getter untuk saldo
    public int getSaldo() {
        return saldo;
    }

    public void penarikan(int withdrawValue) {
        if (withdrawValue > 0 && withdrawValue <= saldo) {
            saldo -= withdrawValue;
            System.out.println(pemilik + " menarik uang sebesar: " + withdrawValue + "$");
        } else {
            System.out.println("Penarikan gagal. Jumlah tidak valid atau saldo tidak mencukupi.");
        }
    }

    public void transfer(int transferValue, String nama, AdminBank admin) {
        if (transferValue > 0 && transferValue <= saldo) {
            if (admin.pemilik.equalsIgnoreCase(nama)) {
                admin.saldo += transferValue;
                saldo -= transferValue;
                System.out.println("Berhasil transfer " + transferValue + "$ ke akun " + nama);
            } else {
                System.out.println("Pemilik dengan nama " + nama + " tidak ditemukan!");
            }
        } else {
            System.out.println("Transfer gagal. Jumlah tidak valid atau saldo tidak mencukupi.");
        }
    }

    public void setor(int depositValue) {
        if (depositValue > 0) {
            saldo += depositValue;
            System.out.println(pemilik + " menyetor uang sebesar: " + depositValue + "$");
        } else {
            System.out.println("Setoran gagal. Jumlah tidak valid.");
        }
    }

    public void display() {
        System.out.println("Saldo " + pemilik + " : " + saldo + "$");
    }
}