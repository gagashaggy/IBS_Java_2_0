package task1;

import java.util.Random;

public class ArrayTask {
    public void run() {
        int[] numbers = createArray();
        int indexOfMaxNegative = findMaxNegative(numbers);
        System.out.println("Max negative number has index " + indexOfMaxNegative + ", its value is " + numbers[indexOfMaxNegative]);
        int indexOfMinPositive = findMinPositive(numbers);
        System.out.println("Min positive number has index " + indexOfMinPositive + ", its value is " + numbers[indexOfMinPositive]);
        swapNumbers(numbers, indexOfMaxNegative, indexOfMinPositive);
    }

    /**
     * Swaps two numbers inside given array
     *
     * @param array  - an array to swap numbers
     * @param index1 - index of first number
     * @param index2 - index of second number
     */
    private void swapNumbers(int[] array, int index1, int index2) {
        int a = array[index1];
        int b = array[index2];
        array[index1] = b;
        array[index2] = a;
        System.out.print("New array after swapping: {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? ", " : "}\n"));
        }
    }

    /**
     * Finds max negative number inside given array
     *
     * @param array - an array to search
     * @return index of max negative number
     */
    private int findMaxNegative(int[] array) {
        int indexOfMaxNegative = -1;
        for (int i = 0; i < array.length; i++) {
            // ignore all non negative numbers
            if (array[i] >= 0)
                continue;
            // catch first found negative
            if (indexOfMaxNegative == -1)
                indexOfMaxNegative = i;
                // compare next negative numbers with current max
            else if (array[i] > array[indexOfMaxNegative])
                indexOfMaxNegative = i;
        }
        return indexOfMaxNegative;
    }

    /**
     * Finds min positive number inside given array
     *
     * @param array - an array to search
     * @return index of min positive number
     */
    private int findMinPositive(int[] array) {
        int indexOfMinPositive = -1;
        for (int i = 0; i < array.length; i++) {
            // ignore all non positive numbers
            if (array[i] <= 0)
                continue;
            // catch first found positive
            if (indexOfMinPositive == -1)
                indexOfMinPositive = i;
                // compare next positive numbers with current min
            else if (array[i] < array[indexOfMinPositive])
                indexOfMinPositive = i;
        }
        return indexOfMinPositive;
    }

    /**
     * Create an array and fill it with random numbers
     *
     * @return
     */
    private int[] createArray() {
        int[] array = new int[20];
        System.out.print("Created array: {");
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            // random.nextInt() creates a number between 0 (inclusively) and given bound (exclusively)
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + (i < array.length - 1 ? ", " : "}\n"));
        }
        return array;
    }
}
