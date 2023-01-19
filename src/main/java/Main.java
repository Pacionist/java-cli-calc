import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        System.out.println(calc(equation));
    }

    public static String calc(String input) throws Exception {
        String[] elements = input.split(" ");

        int result = 0;
        int x1;
        int x2;
        if (elements.length != 3) throw new Exception("Вы ввели неверное выражение");


        if (calc.isRomeNumbers(elements[0], elements[2])) {
            x1 = calc.changeToArabic(elements[0]);
            x2 = calc.changeToArabic(elements[2]);
        } else if (calc.isOurArabicNumbers(elements[0], elements[2])) {
            x1 = Integer.parseInt(elements[0]);
            x2 = Integer.parseInt(elements[2]);
        } else
            throw new Exception("Вы ввели не числа.");
        if (calc.isOperation(elements[1])) {
            switch (elements[1]) {
                case "+" -> result = x1 + x2;
                case "-" -> result = x1 - x2;
                case "*" -> result = x1 * x2;
                case "/" -> result = x1 / x2;
            }
        }
        if (calc.romeMode) {
            if (result > 0) {
                return convertToRome.getNumber(result);
            } else {
                throw new Exception("В римской системе результат не может быть 0 или отрицательным.");
            }
        }

        return String.valueOf(result);
    }
}
