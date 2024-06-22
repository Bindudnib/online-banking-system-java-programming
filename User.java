import java.util.Scanner;

public class User {
    private String username;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String username) {
        this.username = username;
    }

    public void printPersonalInformation() {
        System.out.println("Personal Information:");
        System.out.println("Username: " + username);
        System.out.println("Name: " + (name != null ? name : "N/A"));
        System.out.println("Address: " + (address != null ? address : "N/A"));
        System.out.println("Phone Number: " + (phoneNumber != null ? phoneNumber : "N/A"));
        System.out.println("Email: " + (email != null ? email : "N/A"));
    }

    public void updatePersonalInformation(Scanner scanner) {
        System.out.print("Enter new name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter new address: ");
        this.address = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        this.phoneNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        this.email = scanner.nextLine();
        System.out.println("Personal information updated successfully!");
    }
}
