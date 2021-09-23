import task1.ArrayTask;
import task2.NewYearGiftTask;

import java.util.Scanner;

/**
 * Base class for the 4th task
 *
 * @author vmokhnachev
 */
public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a program: 1 - array check, 2 - new year gift");
        byte n = scanner.nextByte();
        switch (n) {
            case 1:
                runArrayTask();
                break;
            case 2:
                runNewYearGiftTask();
                break;
            default:
                System.out.println("Unknown value");
        }

    }

    private static void runArrayTask() {
        ArrayTask task1 = new ArrayTask();
        task1.run();
    }

    private static void runNewYearGiftTask() {
        NewYearGiftTask task2 = new NewYearGiftTask();
        task2.run();
    }
}
