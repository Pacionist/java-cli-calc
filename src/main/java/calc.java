import java.util.Scanner;

class calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        System.out.println(Main.calculate(equation));
    }
}
