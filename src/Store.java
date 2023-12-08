public class Store {
    Customer cust1 = new Customer();
    static Merchandise masks = new Merchandise("Mask", 250, 15);
    static Merchandise knives = new Merchandise("Kniv", 300, 22);
    static OnSaleMerchandise fakeBloodz = new OnSaleMerchandise("Fake Blood", 199.9, 29, 0.35);

    Store() {

    }

    static void storeInfo() {
        System.out.printf("1. %s: %.1fkr, %d antal masker kvar\n",
                masks.getProductName(), masks.getPrice(), masks.getUnitsLeft());

        System.out.printf("2. %s: %.1fkr, %d antal blooooodiga knivar kvar\n",
                knives.getProductName(), knives.getPrice(), knives.getUnitsLeft());

        System.out.printf("3. %s: %.1fkr, %d antal blodpaket kvar\n",
                fakeBloodz.getProductName(), fakeBloodz.getPrice(), fakeBloodz.getUnitsLeft());

        System.out.println("4. Avsluta och betala");
    }
}
