import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator();
        double pathTime = 0;

        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            } else if (input < 0 || input > 25) {
                System.out.println("Введите корректный этаж");
            } else {
                pathTime = elevator.goTo(input);
            }
        }
        System.out.println(elevator.elevatorPath());
        System.out.println("Затраченное время: " + pathTime);
    }
}
