import java.util.Scanner;

public class AgeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myAge = 19;   // Declare the variable here

        System.out.print("Masukkan usia Anda: ");
        myAge = scanner.nextInt(); // Assign the value using scanner.nextInt()

        if (myAge >= 16) {
            System.out.println("I'm old enough to have a driver's license!");
        } else {
            System.out.println("I'm not old enough yet... :*(");
        }
        scanner.close();
    }
}
