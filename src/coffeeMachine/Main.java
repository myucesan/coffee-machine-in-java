package coffeeMachine;
import java.util.Scanner;

class AmountPerCup {
    // Espresso: 250ml water ; 16g beans ; 4 dolar
    // Latte: 350ml water ; 75ml milk; 20 g beans; 7 dolar
    // Cappucino: 200ml water; 100ml milk; 12g beans; 6 dollar
    static class espresso {
        final static int water = 250;
        final static int beans = 16;
        final static int price = 4;
    }

    static class latte {
        final static int water = 350;
        final static int milk = 75;
        final static int beans = 20;
        final static int price = 7;
    }

    static class cappucino {
        final static int water = 200;
        final static int milk = 100;
        final static int beans = 12;
        final static int price = 6;
    }


}

public class CoffeeMachine {
    final static Scanner input = new Scanner(System.in);
    // Current inventory:: 550 dollar, 1200 ml, 540ml milk , 120g beans, 9 cups
    static int waterInventory = 400;
    static int milkInventory = 540;
    static int beansInventory = 120;
    static int cupsInventory = 9;
    static int moneyInventory = 550;
    private CoffeeMachine() {
        throw new UnsupportedOperationException();
    }

    public static void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water \n", waterInventory);
        System.out.printf("%d of milk \n", milkInventory);
        System.out.printf("%d of coffee beans \n", beansInventory);
        System.out.printf("%d of disposable cups \n", cupsInventory);
        System.out.printf("$%d of money \n", moneyInventory);
        System.out.println();
    }

    public static boolean enoughFor(String type) {
        switch(type) {
            case "espresso":
                if (waterInventory < AmountPerCup.espresso.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansInventory < AmountPerCup.espresso.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }

                break;
            case "latte":
                if (waterInventory < AmountPerCup.latte.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansInventory < AmountPerCup.latte.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (milkInventory < AmountPerCup.latte.milk){
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }

                break;
            case "cappuccino":
                if (waterInventory < AmountPerCup.cappucino.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansInventory < AmountPerCup.cappucino.beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (milkInventory < AmountPerCup.cappucino.milk){
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }

                break;
        }
        return false;
    }

    public static void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = input.next();

        switch(choice) {
            case "1":
                // espresso code
                if (enoughFor("espresso")) {
                    waterInventory -= AmountPerCup.espresso.water;
                    beansInventory -= AmountPerCup.espresso.beans;
                    moneyInventory += AmountPerCup.espresso.price;
                    cupsInventory--;
                }

                break;
            case "2":
                // latte code
                if(enoughFor("latte")) {
                    waterInventory -= AmountPerCup.latte.water;
                    milkInventory -= AmountPerCup.latte.milk;
                    beansInventory -= AmountPerCup.latte.beans;
                    moneyInventory += AmountPerCup.latte.price;
                    cupsInventory--;
                }

                break;
            case "3":
                // cappuccino code
                if(enoughFor("cappuccino")) {
                    waterInventory -= AmountPerCup.cappucino.water;
                    milkInventory -= AmountPerCup.cappucino.milk;
                    beansInventory -= AmountPerCup.cappucino.beans;
                    moneyInventory += AmountPerCup.cappucino.price;
                    cupsInventory--;
                }

                break;
            case "back":
                return;
        }




    }

    public static void fill() {
        System.out.print("Write how many ml of water do you want to add: ");
        waterInventory += input.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        milkInventory += input.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        beansInventory += input.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        cupsInventory += input.nextInt();
    }

    public static void take() {
        System.out.printf("I gave you $%d", moneyInventory);
        System.out.println();
        moneyInventory = 0;
    }


    public static void main(final String[] args) {
        String choice;
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            choice = input.next();
            System.out.println();

            switch(choice) {
                case "buy":
                    // run buy code
                    buy();
                    break;
                case "fill":
                    // run fill code
                    fill();
                    break;
                case "take":
                    // take money code
                    take();
                    break;
                case "remaining":
                    printInventory();
                    break;
            }
        } while (!choice.equals("exit"));

    }
}
