import java.util.Scanner;

public class AgeValidity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan usia Anda: ");
        int age = scanner.nextInt();
        scanner.close();

        boolean drivingUnderAge = false;

        if (age <= 18) {
            drivingUnderAge = true;
        }

        System.out.println("Apakah Anda di bawah umur mengemudi? " + drivingUnderAge);
    }
}
