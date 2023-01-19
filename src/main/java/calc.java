public class calc {
    static boolean romeMode = false;

    public static String calculate(String input) throws Exception {
        String[] elements = input.split(" ");

        int result = 0;
        int x1;
        int x2;
        if (elements.length != 3) throw new Exception("Вы ввели неверное выражение");


        if (isRomeNumbers(elements[0], elements[2])) {
            x1 = changeToArabic(elements[0]);
            x2 = changeToArabic(elements[2]);
        } else if (isOurArabicNumbers(elements[0], elements[2])) {
            x1 = Integer.parseInt(elements[0]);
            x2 = Integer.parseInt(elements[2]);
        } else
            throw new Exception("Вы ввели не числа.");
        if (isOperation(elements[1])) {
            switch (elements[1]) {
                case "+" -> result = x1 + x2;
                case "-" -> result = x1 - x2;
                case "*" -> result = x1 * x2;
                case "/" -> result = x1 / x2;
            }
        }
        if (romeMode) {
            if (result > 0) {
                return convertToRome.getNumber(result);
            } else {
                throw new Exception("В римской системе результат не может быть 0 или отрицательным.");
            }
        }

        return String.valueOf(result);
    }


    public static boolean isOurArabicNumbers(String str1, String str2) throws Exception {
        int m1 = Integer.parseInt(str1);
        int m2 = Integer.parseInt(str2);

        if (m1 > 0 && m1 < 11) {
            if (m2 > 0 && m2 < 11) {
                return true;
            } else
                throw new Exception("Второе число вне диапазона!");
        } else
            throw new Exception("Первое число вне диапазона!");
    }

    public static boolean isOperation(String str) throws Exception {
        if (str.length() != 1 || !"+-*/".contains(str))
            throw new Exception("Вы неверно ввели операцию!");
        return true;
    }

    public static boolean isRomeNumbers(String str1, String str2) throws Exception {
        String[] romeNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean n1 = false;
        boolean n2 = false;
        for (String num : romeNumbers) {
            if (str1.equals(num)) n1 = true;
            if (str2.equals(num)) n2 = true;
        }
        if (n1 && n2) {
            romeMode = true;
            return true;
        } else if (n1) {
            throw new Exception("Второе число не римское, разные форматы!");
        } else if (n2) {
            throw new Exception("Первое число не римское, разные форматы!");
        }
        return false;
    }

    public static int changeToArabic(String romeNum) throws Exception {
        switch (romeNum) {
            case "X":
                return 10;
            case "IX":
                return 9;
            case "VIII":
                return 8;
            case "VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case "II":
                return 2;
            case "I":
                return 1;
        }
        throw new Exception("Я хз как, но ты всё сломал...");
    }


}
