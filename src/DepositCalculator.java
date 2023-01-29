import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double amountPercent = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return exponentiation(amountPercent, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return exponentiation(amount + amount * yearRate * period, 2);
    }

    double exponentiation(double value, int places) {
        double exponent = Math.pow(10, places);
        return Math.round(value * exponent) / exponent;
    }

    void calculate() {
        int period;
        int action;
        double outValue = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            outValue = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outValue = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outValue);
    }
}
