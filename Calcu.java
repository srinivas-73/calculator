import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        
        System.out.println("Welcome to Simple Calculator!");

        while (continueCalculating) {
            try {
                double num1 = getNumber(scanner, "Enter first number: ");
                char operation = getOperation(scanner);
                double num2 = getNumber(scanner, "Enter second number: ");
                double result = performCalculation(num1, num2, operation);
                
                System.out.printf("Result: %.2f%n", result);

                System.out.print("Do you want to perform another calculation? (y/n): ");
                char choice = scanner.next().toLowerCase().charAt(0);
                continueCalculating = (choice == 'y');
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear the scanner buffer
            }
        }

        System.out.println("Thank you for using Simple Calculator!");
        scanner.close();
    }

    private static double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static char getOperation(Scanner scanner) {
        while (true) {
            System.out.print("Enter operation (+, -, *, /): ");
            String input = scanner.next(); 
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid operation! Please use +, -, *, or /.");
            }
        }
    }

    private static double performCalculation(double num1, double num2, char operation) {
        switch (operation) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                    return 0; // Return 0 instead of throwing an exception
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operation! Please use +, -, *, or /.");
                return 0;
        }
    }
}
