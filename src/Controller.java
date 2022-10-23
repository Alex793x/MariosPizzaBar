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
                case 1 -> viewMariosPizzaMenu();
                case 2 -> {
                    in.nextLine();      // Scanner Bug
                    makeAnOrder();
                }
                case 3 -> {
                    in.nextLine();      // Scanner Bug
                    deleteAnOrder();
                }
                case 4 -> {
                    in.nextLine();      // Scanner Bug
                    finishAnOrder();
                }
                case 5 -> viewAllActiveOrders();
                case 6 -> viewNextOrder();
                case 7 -> viewFinsihedOrders();
                case 8 -> viewTurnOver();
                case 9 -> isRunning = false;
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

    protected  void viewNextOrder() {
        orders.viewNextOrder();
    }

    protected void viewTurnOver() {
        System.out.println("Total omsætning baseret på afsluttede ordre er: " + orders.turnOver() + "0,- Kroner");
    }



    @Override
    public String toString() {
        return menuOptions[0] + "\n" + menuOptions[1] + "\n" + menuOptions[2] + "\n" + menuOptions[3] +
                "\n" + menuOptions[4] + "\n" + menuOptions [5] + "\n" + menuOptions[6] + "\n" + menuOptions[7] +
                "\n" + menuOptions[8];
    }
}
