import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Manage Personal Information");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: transfer(); break;
                case 5: viewTransactionHistory(); break;
                case 6: managePersonalInformation(); break;
                case 7: running = false; break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (accounts.containsKey(username)) {
            System.out.println("Account already exists!");
        } else {
            Account newAccount = new Account(username, initialDeposit);
            accounts.put(username, newAccount);
            System.out.println("Account created successfully!");
        }
    }

    private void deposit() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        Account account = accounts.get(username);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found!");
        }
    }

    private void withdraw() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        Account account = accounts.get(username);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    private void transfer() {
        System.out.print("Enter sender username: ");
        String senderUsername = scanner.nextLine();
        Account sender = accounts.get(senderUsername);

        if (sender != null) {
            System.out.print("Enter receiver username: ");
            String receiverUsername = scanner.nextLine();
            Account receiver = accounts.get(receiverUsername);

            if (receiver != null) {
                System.out.print("Enter transfer amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (sender.transferTo(receiver, amount)) {
                    System.out.println("Transfer successful!");
                } else {
                    System.out.println("Insufficient funds!");
                }
            } else {
                System.out.println("Receiver account not found!");
            }
        } else {
            System.out.println("Sender account not found!");
        }
    }

    private void viewTransactionHistory() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        Account account = accounts.get(username);

        if (account != null) {
            account.printTransactionHistory();
        } else {
            System.out.println("Account not found!");
        }
    }

    private void managePersonalInformation() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        Account account = accounts.get(username);

        if (account != null) {
            System.out.println("1. View Personal Information");
            System.out.println("2. Update Personal Information");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: account.getUser().printPersonalInformation(); break;
                case 2: account.getUser().updatePersonalInformation(scanner); break;
                default: System.out.println("Invalid option. Please try again.");
            }
        } else {
            System.out.println("Account not found!");
        }
    }
}
