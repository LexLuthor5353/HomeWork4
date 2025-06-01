import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long earnings = 0;
        long spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для завершения программы введите 'end'");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    long income = Long.parseLong(scanner.nextLine();
                    earnings += income;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    long expense = Long.parseLong(scanner.nextLine();
                    spendings += expense;
                    break;

                case 3:
                    calcBestTax(earnings, spendings);
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена!");
    }

    public static long taxEarningsMinusSpendings(long earnings, long spendings) {
        long tax = (earnings - spendings) * 15 / 100;
        return tax >= 0 ? tax : 0;
    }

    public static long taxEarnings(long earnings) {
        return earnings * 6 / 100;
    }

    public static void calcBestTax(long earnings, long spendings) {
        long taxIncome = taxEarnings(earnings);
        long taxDiff = taxEarningsMinusSpendings(earnings, spendings);

        if (taxIncome < taxDiff) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + taxIncome + " рублей");
            System.out.println("Налог на другой системе: " + taxDiff + " рублей");
            System.out.println("Экономия: " + (taxDiff - taxIncome) + " рублей");
        } else if (taxDiff < taxIncome) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + taxDiff + " рублей");
            System.out.println("Налог на другой системе: " + taxIncome + " рублей");
            System.out.println("Экономия: " + (taxIncome - taxDiff) + " рублей");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Ваш налог составит: " + taxIncome + " рублей в обеих системах");
        }
    }
}