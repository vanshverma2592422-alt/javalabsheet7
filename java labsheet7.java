import java.util.Scanner;

// MCA203P-AS07: Exception Handling Questions 1-10
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter question number (1-10): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: q1(); break;
            case 2: q2(); break;
            case 3: q3(); break;
            case 4: q4(); break;
            case 5: q5(); break;
            case 6: q6(); break;
            case 7: q7(); break;
            case 8: q8(); break;
            case 9: q9(); break;
            case 10: q10(); break;
            default: System.out.println("Invalid question number.");
        }
    }

    // QUESTION 1: Divide by Zero Exception
    static void q1() {
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            System.out.println("Division operation completed.");
        }
    }

    // QUESTION 2: Array Index Out of Bounds
    static void q2() {
        int[] arr = {10, 20, 30, 40, 50};
        try {
            System.out.print("Enter index (0-4): ");
            int index = sc.nextInt();
            System.out.println("Value: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        }
    }

    // QUESTION 3: Multiple Catch Blocks
    static void q3() {
        try {
            System.out.print("Enter first number: ");
            int a = Integer.parseInt(sc.next());
            System.out.print("Enter second number: ");
            int b = Integer.parseInt(sc.next());
            System.out.println("Result: " + (a / b));
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    // QUESTION 4: Nested Try Blocks
    static void q4() {
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();

            try {
                int[] arr = {10, 20, 30};
                System.out.print("Enter array index (0-2): ");
                int index = sc.nextInt();
                System.out.println("Array value: " + arr[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index.");
            }

            System.out.println("Division result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    // QUESTION 5: Finally Block
    static void q5() {
        try {
            System.out.println("File opened.");
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            System.out.println("Result: " + (100 / n));
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic exception occurred.");
        } finally {
            System.out.println("Resource closed.");
        }
    }

    // QUESTION 6: Using throw Keyword
    static void q6() {
        try {
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            checkAge(age);
            System.out.println("Eligible.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
    }

    // QUESTION 7: User-Defined Exception
    static void q7() {
        try {
            System.out.print("Enter password: ");
            String password = sc.next();
            if (password.length() < 6) {
                throw new InvalidPasswordException(
                    "Password must contain at least 6 characters.");
            }
            System.out.println("Password accepted.");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    // QUESTION 8: Using throws Keyword
    static void q8() {
        try {
            int number = readNumber();
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer entered.");
        }
    }

    static int readNumber() throws NumberFormatException {
        System.out.print("Enter an integer: ");
        return Integer.parseInt(sc.next());
    }

    // QUESTION 9: Finally vs Return
    static void q9() {
        int result = getValue();
        System.out.println("Returned value: " + result);
    }

    static int getValue() {
        try {
            return 100;
        } finally {
            System.out.println("Finally block executes before the method returns.");
        }
    }

    // QUESTION 10: Banking and Exceptions
    static void q10() {
        BankAccount10 account = new BankAccount10(1000);
        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("Remaining balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class InvalidPasswordException extends Exception {
    InvalidPasswordException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount10 {
    private double balance;

    BankAccount10(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount)
            throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds.");
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}
