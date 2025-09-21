import java.util.Scanner;

public class Calculator {
    private static double[] readNumbers(Scanner sc) {
        double FirstNum = 0;
        double SecondNum = 0;

        System.out.print("Введите первое число: ");
        FirstNum = sc.nextDouble();
        System.out.print("Введите второе число: ");
        SecondNum = sc.nextDouble();

        return new double[]{FirstNum, SecondNum};
    }

    private static char getOperation(Scanner sc) {
        System.out.print("Выберите операцию: +, -, *, /: ");
        String str = sc.next();
        char c = str.charAt(0);
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
                    System.out.println("На ноль нельзя делить");
                } else {
                    return num1 / num2;
                }
            default:
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] read = readNumbers(sc);
        char operation = getOperation(sc);
        double result = calculate(read[0], read[1], operation);
        System.out.printf("Результат: %.2f", result);
    }
}
