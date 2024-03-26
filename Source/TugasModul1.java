import java.util.Scanner;
public class TugasModul1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Choose Option (1-3): ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    loginStudent();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    System.out.println("Adios Amigos");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void loginStudent() {
        System.out.print("Enter Your NIM : ");
        String NIM = scanner.next();

        if (NIM.length() == 15 && NIM.equals("202310370311049")) {
            System.out.println("Succesful Login As Student");
        } else {
            System.out.println("User Not Found");
        }
    }

    private static void loginAdmin() {
        System.out.print("Enter your username (admin): ");
        String usernameAdmin = scanner.next();

        System.out.print("Enter your password (admin): ");
        String passwordAdmin = scanner.next();

        if (usernameAdmin.equals("admin") && passwordAdmin.equals("admin")) {
            System.out.println("Succesful Login as Admin");
        } else {
            System.out.println("Admin User Not Found");
        }
    }
}
