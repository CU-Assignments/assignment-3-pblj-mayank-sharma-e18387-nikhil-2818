import java.util.Scanner;

public class ATMwithdrawl {
    private String ATMPin;
    private double balance;

    public ATMwithdrawl(String correctPin, double balance) {
        this.ATMPin = correctPin;
        this.balance = balance;
    }

    // check PIN
    public void checkPin(String pin) throws Exception {
        if (!pin.equals(ATMPin)) {
            throw new Exception("Error: Invalid PIN");
        }
    }

    //  withdraw money
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Error: Insufficient balance. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining Balance: " + balance);
    }

    //  current balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMwithdrawl atm = new ATMwithdrawl("1234", 3000); 

        try {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            atm.checkPin(pin);

            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            atm.displayBalance();
            scanner.close();
        }
    }
}

