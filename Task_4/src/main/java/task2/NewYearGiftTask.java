package task2;

import task2.sweets.*;

import java.util.Random;

public class NewYearGiftTask {
    public void run() {
        Sweets[] gift = createGift();
        getGiftInfo(gift);
    }

    /**
     * Gets information about the gift
     * @param gift
     */
    private void getGiftInfo(Sweets[] gift) {
        double totalWeight = 0.0;
        double totalPrice = 0.0;
        int i = 1;
        System.out.println("There are " + gift.length + " items in the gift:");
        for (Sweets sweets : gift) {
            System.out.println(i + ". " + sweets.toString());
            totalPrice += sweets.getPrice();
            totalWeight += sweets.getWeight();
            i++;
        }
        System.out.println();
        System.out.printf("Total weight: %.3f\n", totalWeight);
        System.out.printf("Total price: %.2f\n",totalPrice);
    }

    /**
     * Creates a gift or random capacity and fills it with random sweets
     * @return
     */
    private Sweets[] createGift() {
        Random random = new Random();
        Sweets[] gift = new Sweets[random.nextInt(7) + 3];
        for (int i = 0; i < gift.length; i++) {
            switch (random.nextInt(11)) {
                case 0:
                    gift[i] = new Candy("Bayside Diva", 0.208, 6.09, "lollipop");
                    break;
                case 1:
                    gift[i] = new Candy("Ladybug", 0.206, 6.21, "caramel");
                    break;
                case 2:
                    gift[i] = new Candy("Candy Dancing", 0.210, 2.06, "chocolate");
                    break;
                case 3:
                    gift[i] = new Chocolate("Leo", 0.214, 10.1, "milk");
                    break;
                case 4:
                    gift[i] = new Chocolate("Daichi", 0.217, 9.11, "dark");
                    break;
                case 5:
                    gift[i] = new Chocolate("Spicy Chocolate", 0.210, 3.17, "white");
                    break;
                case 6:
                    gift[i] = new Jellybean("Jelly", 0.282, 1.39, "fruit");
                    break;
                case 7:
                    gift[i] = new Jellybean("Beans", 0.192, 1.39, "licorice");
                    break;
                case 8:
                    gift[i] = new Marmalade("Chain", 0.203, 8.15, "purple");
                    break;
                case 9:
                    gift[i] = new Marmalade("DabStar", 0.202, 4.55, "blue");
                    break;
                case 10:
                    gift[i] = new Marmalade("Bayside", 0.200, 4.55, "red");
                    break;
            }
        }
        return gift;
    }
}
