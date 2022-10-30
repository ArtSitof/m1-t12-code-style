import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double annualYearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + annualYearRate / 12), 12 * depositPeriod);

        return calculateProfit(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double annualYearRate, int depositPeriod) {
        return calculateProfit(depositAmount + depositAmount * annualYearRate * depositPeriod, 2);
    }

    double calculateProfit(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateTheTotalAmountOfTheDeposit() {
        double annualYearRate = 0.06;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией");
        int action = scanner.nextInt();
        double outDeposit = 0;
        if (action == 1) {
            outDeposit = calculateSimplePercent(depositAmount, annualYearRate, depositPeriod);
        } else if (action == 2) {
            outDeposit = calculateComplexPercent(depositAmount, annualYearRate, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + outDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateTheTotalAmountOfTheDeposit();
    }

}
