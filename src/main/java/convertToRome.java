import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class convertToRome {

    public static String getNumber(int resultArabic) {
        List<RomeNums> romeNums = RomeNums.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((resultArabic > 0) && (i < romeNums.size())) {
            RomeNums currentSymbol = romeNums.get(i);
            if (currentSymbol.getValue() <= resultArabic) {
                sb.append(currentSymbol.name());
                resultArabic -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    enum RomeNums {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private final int value;

        RomeNums(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomeNums> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomeNums e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public static void convert(String resultArabic) {
    }
}
