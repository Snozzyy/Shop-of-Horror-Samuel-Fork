import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*This boolean changes when the user wants to quit the session and terminates our while-loop*/
        // new GUI();
        boolean sessionIsOver = false;

        Customer cust1 = new Customer();
        Merchandise masks = new Merchandise("Mask", 250, 15);
        Merchandise knives = new Merchandise("Kniv", 300, 22);
        OnSaleMerchandise fakeBloodz = new OnSaleMerchandise("Fake Blood",199.9,29,0.35);
        Scanner scan = new Scanner(System.in);
        /*We instantiate it as invalid input*/
        int input = -3;

        /*This will loop while session is not over*/
        while(!sessionIsOver){
            /*This prints the menu with its current data at the start of every loop*/
            System.out.printf("1. %s: %.1fkr, %d antal masker kvar\n",
                    masks.getProductName(), masks.getPrice(), masks.getUnitsLeft());
            System.out.printf("2. %s: %.1fkr, %d antal blooooodiga knivar kvar\n",
                    knives.getProductName(), knives.getPrice(), knives.getUnitsLeft());
            System.out.printf("3. %s: %.1fkr, %d antal blodpaket kvar\n",
                    fakeBloodz.getProductName(), fakeBloodz.getPrice(), fakeBloodz.getUnitsLeft());
            System.out.println("4. Avsluta och betala");
            /*This boolean represents that we have gotten valid input for the current while loop*/
            boolean inputValid = false;

            while(!inputValid){
                /*Gets input from user*/
                 input = scan.nextInt();
                if(input > 0 && input < 5){
                    inputValid = true;
                }
                else{
                    System.out.println("Vänligen skriv in en siffra 1-4");
                }
            }
            /*When we have obtained validated input we know that the 1 <=int <=4, we can use a switch case*/

            switch (input){

                case 1: cust1.addToTotalCost(masks.soldUnit());
                    System.out.println("Du har köpt varor för: " + cust1.getTotalCost()+" kr."); break;

                case 2: cust1.addToTotalCost(knives.soldUnit());System.out.println("Du har köpt varor för: " +
                        cust1.getTotalCost()+" kr."); break;

                case 3: cust1.addToTotalCost(fakeBloodz.soldUnit()); System.out.println("Du har köpt varor för: " +
                        cust1.getTotalCost()+" kr."); break;

                case 4: sessionIsOver = true; break;
            }
        }

        double moneySaved = Math.round(fakeBloodz.getUnitsCounter()*fakeBloodz.price*fakeBloodz.
                getDiscountPercentage());

        System.out.printf("Du har köpt produkter för: %dkr\n", Math.round(cust1.getTotalCost()));
        System.out.printf("Du köpte %d antal %s(er)\n", masks.getUnitsCounter(), masks.getProductName());
        System.out.printf("Du köpte %d antal blooodiga %s-paket\n", knives.getUnitsCounter(), knives.getProductName());
        System.out.printf("Du köpte %d %s-paket och sparade %fkr\n", fakeBloodz.getUnitsCounter(),
                fakeBloodz.getProductName(), moneySaved);

        System.out.println("Välkommen åter!");
    }
}