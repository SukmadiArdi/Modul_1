import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{

    private String name;
    private String faculty;
    private String nim;
    private String programStudi;

    static  Scanner inputuser = new Scanner(System.in);
    static  String idBukuYangDipinjam;
    static int inputwaktuPinjaman;


    static ArrayList<ListPinjamanBuku>arr_listPinjamanBuku = new ArrayList<>();

    static class ListPinjamanBuku {
        String id;
        int waktupinjaman;

        public ListPinjamanBuku(String id, int waktupinjaman) {
            this.id = id;
            this.waktupinjaman = waktupinjaman;
        }
    }
    public void displayInfo(){
        System.out.print(" "+name);
        System.out.print(" "+nim);
        System.out.print(" "+faculty);
        System.out.print(" "+programStudi);
    }

    public static void showBorrowedBooks(){

        System.out.println("=======================================  Informasi Buku Yang Dipinjam  ==================================================");
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Durasi");
        System.out.println("\n=========================================================================================================================");

               for (ListPinjamanBuku a : arr_listPinjamanBuku) {
                   for (mainInterface.BookList i : mainInterface.arr_bookList) {
                       if (i.idbuku.equals(a.id)) {
                           System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, a.waktupinjaman);
                       }

                   }

               }

        System.out.print("=========================================================================================================================");
    }

    @Override
    public void displayBooks(){
        super.displayBooks();
    }
    public static void logout(){
        mainInterface.menu();
    }

    public static void returnBooks(){
        boolean validasiReturnBooks = false;
        System.out.println("\n● Inputkan ID buku yang ingin dikembalikan.");
        System.out.print("> ID : ");
        idBukuYangDipinjam = inputuser.nextLine();
        for (int i = 0; i < arr_listPinjamanBuku.size(); i++ ) {
            if (arr_listPinjamanBuku.get(i).id.equals(idBukuYangDipinjam)) {
                for (mainInterface.BookList a : mainInterface.arr_bookList) {
                    if (a.idbuku.equals(idBukuYangDipinjam)) {
                        a.stokbuku++;
                        arr_listPinjamanBuku.remove(i);
                        validasiReturnBooks = true;
                    }
                    }
                }
            }
        if(validasiReturnBooks){
            System.out.print("Pengembalian Berhasil");
        }else{
            System.out.print("Buku tidak ditemukan.");
        }
    }

    public static void borrowedBooks(){
        int loop;
        boolean bool_validasi_borrowedBooks  = false;

            System.out.println("\n>> Input ID buku yang ingin dipinjam");
            System.out.print(">  ID: ");
            idBukuYangDipinjam = inputuser.nextLine();

        do{
            System.out.println("\n>> Berapa lama buku ingin dipinjam? (maksimal 14 hari)");
            System.out.print(">  Berapa hari ? : ");
            inputwaktuPinjaman = inputuser.nextInt();

            if(inputwaktuPinjaman > 14){
                System.out.print("Maksimal hanya 14 Hari!");
                loop = 0;
            }else{
                loop = 1;
            }
        }while(loop == 0);
            for (mainInterface.BookList i : mainInterface.arr_bookList) {
                if (i.idbuku.equals(idBukuYangDipinjam)) {
                    if (i.stokbuku > 0) {
                        i.stokbuku--;
                        arr_listPinjamanBuku.add(new ListPinjamanBuku(idBukuYangDipinjam, inputwaktuPinjaman));
                        bool_validasi_borrowedBooks = true;
                    } else {
                        bool_validasi_borrowedBooks = false;
                    }
                }
            }
            if (bool_validasi_borrowedBooks) {
                System.out.print("Buku berhasil dipinjam");
            } else {
                System.out.print("Stok buku habis");
            }

    }

    public static void  loginstudent(){
        boolean validasi = false;
        int loop = 0;
        do{
            mainInterface.inputNIM();
            if(mainInterface.NIM.length() != 15) {
                System.out.println("NIM harus 15 digit\n");
                continue;

            }
            for(mainInterface.UserStudent i : mainInterface.arr_userStudent){
                if(i.nim.equals(mainInterface.NIM)){
                    validasi = true;
                    break;
                }
            }
            if(validasi){
                System.out.println("==== Login berhasil ====\n");
                loop = 1;
            }else{
                System.out.println("==== NIM tidak terdaftar ===");
                mainInterface.menu();
            }

        } while(loop == 0);

    }



}
