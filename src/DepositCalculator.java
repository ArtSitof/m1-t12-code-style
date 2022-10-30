import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount,
                                   double annualYearRate,
                                   int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + annualYearRate / 12), 12 * depositPeriod);

        return calculateProfit(pay, 2);
    }

    double calculateSimplePercent(double depositAmount,
                                  double annualYearRate,
                                  int depositPeriod) {
        return calculateProfit(depositAmount + depositAmount * annualYearRate * depositPeriod, 2);
    }

    double calculateProfit(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateTheTotalAmountOfTheDeposit() {
        int depositPeriod, action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией");
        action = scanner.nextInt();
        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (action == 2) {
            out = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateTheTotalAmountOfTheDeposit();
    }

}
