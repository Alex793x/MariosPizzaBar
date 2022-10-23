import java.util.Arrays;
import java.util.Scanner;

public class Controller {

    // Utility ------------------------------------
    protected static Scanner in = new Scanner(System.in);
    private Orders orders = new Orders();
    private PizzaMenu mariosMenu = new PizzaMenu();

    // Attributes ----------------------------------
    private final String[] menuOptions = {"1: Print Menu" , "2: Tilføj Ordre", "3: Fjern Ordre",
            "4: Afslut Ordre", "5: Se aktive ordre", "6: Se næste ordre", "7: Print afsluttede ordre",
            "8: Tæl kassen op" ,"9: Afslut program"};

    protected boolean isRunning = true;



    // MENU CONTROLLER -----------------------------
    protected void menuController() {
        while(isRunning) {
            System.out.println("\n" + this);

            switch (in.nextInt()) {
                case 1:
                    viewMariosPizzaMenu();
                    break;
                case 2:
                    in.nextLine();
                    makeAnOrder();
                    break;
                case 3:
                    in.nextLine();
                    deleteAnOrder();
                    break;
                case 4:
                    in.nextLine();
                    finishAnOrder();
                    break;
                case 5:
                    viewAllActiveOrders();
                    break;
                case 6:
                    viewNextOrder();
                    break;
                case 7:
                    viewFinsihedOrders();

                    break;
                case 8:
                    viewTurnOver();
                    break;
                case 9:
                    isRunning = false;
            }
        }
    }

    //Behavior (Methods) ---------------------------
    protected void viewMariosPizzaMenu() {
        mariosMenu.printMenu();
    }
    protected void makeAnOrder() {
        orders.addOrder();
    }

    protected  void deleteAnOrder() {
        orders.deleteOrder();
    }

    protected void finishAnOrder() {
        orders.finishOrder();
    }

    protected void viewAllActiveOrders() {
        orders.printActiveOrderList();
    }

    protected void viewFinsihedOrders() {
        orders.printFinsihedOrderList();
    }

    protected void viewTurnOver() {
        System.out.println("Total omsætning baseret på afsluttede ordre er: " + orders.turnOver() + ",- kroner");
    }

    protected void viewNextOrder() {
        if (orders.getActiveOrders().size() > 0) {
            System.out.println("\nTil " + orders.getActiveOrders().get(orders.getActiveOrders().size()-1).getName()
                    + ": " + orders.getActiveOrders().get(orders.getActiveOrders().size() - 1).getOrderList());
        } else {
            System.out.println("\nIngen ordrer venter på at blive lavet!");
        }
    }

    @Override
    public String toString() {
        return menuOptions[0] + "\n" + menuOptions[1] + "\n" + menuOptions[2] + "\n" + menuOptions[3] +
                "\n" + menuOptions[4] + "\n" + menuOptions [5] + "\n" + menuOptions[6] + "\n" + menuOptions[7] +
                "\n" + menuOptions[8];
    }
}
