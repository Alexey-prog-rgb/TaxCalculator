//TIP Для <b>запуска</b> кода нажмите <shortcut actionId="Run"/> или
// щелкните значок <icon src="AllIcons.Actions.Execute"/> в боковой области.
import java.util.Scanner;
public class Main {
    public static void printMenu(){
        System.out.println();
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
        System.out.println("При вводе end программа завершает работу");
        System.out.print("Введите команду: ");
    }

    public static int taxUSN6(int income){
        return (int)(income * 0.06);
    }

    public static int taxUSN15(int income, int expense){
        return(int)((income - expense) * 0.15);
    }

    public static void printTaxSystem(int income, int expense){
        // Расчёт налога по УСН
        int taxUSN = taxUSN6(income);
            if(taxUSN < 0) taxUSN = 0;

        // Расчёт налога по УСН, 15 % от (доход - расход)
        int taxUSN15 = taxUSN15(income, expense);
            if(taxUSN15 < 0) taxUSN15 = 0;

        // Рекомендации
        if(taxUSN == 0 && taxUSN15 == 0)
            System.out.println("Налоги равны нулю.");
        else{
            if(taxUSN == taxUSN15){
                System.out.println("Мы советуем вам любую систему налогообложения (УСН доходы или УСН доходы - расходы)!");
                System.out.println("Ваш налог составит: " + taxUSN);
            }
            if(taxUSN < taxUSN15){
                System.out.println("Мы советуем вам налоговую систему: УСН доходы, 6 %");
                System.out.println("Ваш налог составит: " + taxUSN);
                System.out.println("Налог по другой системе налогообложения: " + taxUSN15 + " руб.");
                System.out.println("Экономия: " + (taxUSN15 - taxUSN) + " руб.");
            }
            if(taxUSN15 < taxUSN){
                System.out.println("Мы советуем вам налоговую систему: УСН доходы - расходы, 15 %");
                System.out.println("Ваш налог составит: " + taxUSN15);
                System.out.println("Налог по другой системе налогообложения: " + taxUSN + " руб.");
                System.out.println("Экономия: " + (taxUSN - taxUSN15) + " руб.");
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Налоговый калькулятор запущен!");

        Scanner scan = new Scanner(System.in);
        String var = "";
        int varMenu = 0;
        int income = 0;
        int expense = 0;
        int enterValue = 0;
        while(true){
            // Меню калькулятора
            printMenu();

            // Чтение команды
           var = scan.next();

           // Выход из программы
            if(var.equals("end")) break;

            // Обработка команд меню
            varMenu = Integer.parseInt(var);
            switch (varMenu){
                case 1: // доход
                    System.out.print("Введите сумму дохода: ");
                    enterValue = scan.nextInt();
                    income += enterValue;
                    break;
                case 2: // расход
                    System.out.print("Введите сумму расхода: ");
                    enterValue = scan.nextInt();
                    expense += enterValue;
                    break;
                case 3: // выбор системы налогообложения
                    printTaxSystem(income, expense);
                    break;
                default:
                    System.out.println("Неверная команда!");
            }


        }
        scan.close();
        System.out.println("Завершение работы налогового калькулятора!");
    }
}
