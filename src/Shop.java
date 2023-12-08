import java.util.Scanner;

public class Shop {
    private Customer cust1 = new Customer();
    private static Merchandise masks = new Merchandise("Mask", 250, 2);
    private static Merchandise knives = new Merchandise("Kniv", 300, 22);
    private static OnSaleMerchandise fakeBloodz = new OnSaleMerchandise("Fake Blood", 1100, 29, 0.1);
    private boolean sessionIsOver = false; // Used to control whether session is over or not
    int input;
    Scanner sc;

    public Shop() {
        sc = new Scanner(System.in);
        // As long as sessionIsOver is false, run the program
        do {
            storeMenu();
            input = sc.nextInt();
            userInput(input);
        } while (!sessionIsOver);
    }

    // Prints the menu
    private static void storeMenu() {
        System.out.printf("\n1. %s: %.1fkr, %d antal masker kvar\n",
                masks.getProductName(), masks.getPrice(), masks.getUnitsLeft());

        System.out.printf("2. %s: %.1fkr, %d antal blooooodiga knivar kvar\n",
                knives.getProductName(), knives.getPrice(), knives.getUnitsLeft());

        System.out.printf("3. %s: %.1fkr, %d antal blodpaket kvar\n",
                fakeBloodz.getProductName(), fakeBloodz.getDiscountedPrice(), fakeBloodz.getUnitsLeft());

        System.out.println("4. Ångra köp");
        System.out.println("5. Avsluta och betala");
        System.out.print("Ditt val: ");
    }

    // Gets users input and then either buys chosen product, runs undoPurchase or terminates program
    private void userInput(int input) {
        switch (input) {
            case 1:
                cust1.addToTotalCost(masks.soldUnit());
                break;

            case 2:
                cust1.addToTotalCost(knives.soldUnit());
                break;

            case 3:
                cust1.addToTotalCost(fakeBloodz.soldUnit());
                break;

            case 4:
                undoPurchase();
                break;

            case 5:
                sessionIsOver = true;
                exit();
                break;

            // If users input is invalid, ask for a valid input
            default:
                System.out.println("Vänligen skriv in en siffra mellan 1-4");
        }

        System.out.println("Du har köpt varor för: " + cust1.getTotalCost() + " kr.");
    }

    private void exit() {
        // Calculate how much money the user has saved on the discounted product
        double moneySaved = Math.round(fakeBloodz.getUnitsCounter() * fakeBloodz.price *
                fakeBloodz.getDiscountPercentage());

        System.out.printf("Du har köpt produkter för: %dkr\n", Math.round(cust1.getTotalCost()));
        System.out.printf("Du köpte %d antal %s(er)\n", masks.getUnitsCounter(), masks.getProductName());
        System.out.printf("Du köpte %d antal blooodiga %s-paket\n", knives.getUnitsCounter(), knives.getProductName());
        System.out.printf("Du köpte %d %s-paket och sparade %.1fkr\n", fakeBloodz.getUnitsCounter(),
                fakeBloodz.getProductName(), moneySaved);

        System.out.println("Välkommen åter!");
    }

    private void undoPurchase() {
        System.out.println("\nI din kundvagn har du:");
        System.out.printf("1. %dst %s(er)\n", masks.getUnitsCounter(), masks.getProductName());
        System.out.printf("2. %dst %s(ar)\n", knives.getUnitsCounter(), knives.getProductName());
        System.out.printf("3. %dst %s-paket\n", fakeBloodz.getUnitsCounter(), fakeBloodz.getProductName());
        System.out.println("4. Gå tillbaka");
        System.out.print("Välj den produkt du ångrar eller gå tillbaka: ");

        input = sc.nextInt();

        switch (input) {
            case 1:
                if (masks.getUnitsCounter() > 0) {
                    masks.undoPurchase();
                    cust1.undoPurchase(masks.getPrice());
                } else {
                    System.out.printf("\nDu har ingen %s i din kundvagn\n", masks.getProductName());
                }
                break;
            case 2:
                if (knives.getUnitsCounter() > 0) {
                    knives.undoPurchase();
                    cust1.undoPurchase(knives.getPrice());
                } else {
                    System.out.printf("\nDu har ing %s i din kundvagn\n", knives.getProductName());
                }
                break;
            case 3:
                if (fakeBloodz.getUnitsCounter() > 0) {
                    fakeBloodz.undoPurchase();
                    cust1.undoPurchase(fakeBloodz.getPrice());
                } else {
                    System.out.printf("\nDu har ingen %s i din kundvagn\n", fakeBloodz.getProductName());
                }
        }
    }
}
