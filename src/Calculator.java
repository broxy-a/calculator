import java.util.Scanner;

public class Calculator {
    private static double[] readNumbers(Scanner sc) {
        double FirstNum = 0;
        double SecondNum = 0;

        System.out.print("Write first number: ");
        FirstNum = sc.nextDouble();
        System.out.print("Write second number: ");
        SecondNum = sc.nextDouble();

        return new double[]{FirstNum, SecondNum};
    }

    private static char getOperation(Scanner sc) {
        char[] allowed = {'+', '-', '*', '/', '%', '^'};
        boolean validChar = false;
        String str = "";
        char c = 'c';

        while (!validChar) {
            System.out.print("Select operation: +, -, *, /, % (remainder of division), ^ (power): ");
            str = sc.next();
            c = str.charAt(0);
            for (char c1 : allowed) {
                if (c == c1) {validChar = true; break;}
            }
            if (!validChar) System.out.println("Unknown operation. Try again: ");
        }
        return c;
    }

    private static double calculate(double num1, double num2, char operation) {
        switch (operation) {
            case ('+'):
                return num1 + num2;
            case ('-'):
                return num1 - num2;
            case ('*'):
                return num1 * num2;
            case ('/'):
                if (num2 == 0) {
                    System.out.println("You can't divide by zero");
                } else {
                    return num1 / num2;
                }
            case ('^'):
                return Math.pow(num1, num2);
            case ('%'):
                if (num2 == 0) {
                    System.out.println("You can't divide by zero");
                    return Double.NaN;
                } else {
                    return num1 % num2;
                }
            default:
                System.out.print("Unknown operation, ");
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] read = readNumbers(sc);
        char operation = getOperation(sc);
        double result = calculate(read[0], read[1], operation);
        System.out.printf("Result: %.2f", result);
    }
}
