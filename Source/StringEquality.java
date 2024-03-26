import java.util.Scanner;

public class StringEquality {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        if (name.equalsIgnoreCase("Moe")) {
            System.out.println("You are the king of rock and roll");
        } else {
            System.out.println("You are not the king");
        }

        scanner.close();
    }
}
