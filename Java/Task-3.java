import java.util.Scanner;

public class ATM {
    private static int balance = 10000;
    private static Scanner scanner = new Scanner(System.in);

    private static void displayMenu() {
        System.out.println("\n🏧 Welcome to the ATM");
        System.out.println("1️⃣ Deposit");
        System.out.println("2️⃣ Withdraw");
        System.out.println("3️⃣ Check Balance");
        System.out.println("4️⃣ Exit");
        System.out.print("Enter your choice: ");
    }

    private static void deposit() {
        System.out.print("Enter deposit amount (\u20B9): ");
        int depositAmount = scanner.nextInt();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("✅ Successfully deposited: \u20B9" + depositAmount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    private static void withdraw() {
        System.out.print("Enter withdrawal amount (\u20B9): ");
        int withdrawAmount = scanner.nextInt();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("✅ Successfully withdrawn: \u20B9" + withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    private static void checkBalance() {
        System.out.println("💰 Your current balance: \u20B9" + balance);
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using our ATM. Have a great day!");
                    return;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
//Output:
/*🏧 Welcome to the ATM
1️⃣ Deposit
2️⃣ Withdraw
3️⃣ Check Balance
4️⃣ Exit
Enter your choice: 1
Enter deposit amount (₹): 2000
✅ Successfully deposited: ₹2000

🏧 Welcome to the ATM
1️⃣ Deposit
2️⃣ Withdraw
3️⃣ Check Balance
4️⃣ Exit
Enter your choice: 3
💰 Your current balance: ₹12000

🏧 Welcome to the ATM
1️⃣ Deposit
2️⃣ Withdraw
3️⃣ Check Balance
4️⃣ Exit
Enter your choice: 4
👋 Thank you for using our ATM. Have a great day! */
