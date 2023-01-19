import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        System.out.println(calc.calculate(equation));
    }
}
