import java.util.Scanner;

public class Controller {

    // Utility ------------------------------------
    protected Scanner in = new Scanner(System.in);

    // Attributes ----------------------------------
    private final String[] menuOptions = {"1: Print Menu" , "2: Tilføj Ordre", "3: Fjern Ordre",
            "4: Afslut Ordre", "5: Se aktive ordre", "6: Se næste ordre", "6: Tæl kassen op", "9: Afslut program"};

    protected boolean isRunning = true;



    // MENU CONTROLLER -----------------------------
    protected void menuController(PizzaMenu mariosMenu, Controller ui, Orders orders) {

        switch (in.nextInt()) {
                case 1:
                    viewMariosPizzaMenu(mariosMenu);
                    break;
                case 2:
                    in.nextLine();
                    makeAnOrder(ui,orders);
                    break;
                case 3:
                    in.nextLine();
                    deleteAnOrder(ui, orders);
                    break;
                case 4:
                    in.nextLine();
                    finishAnOrder(ui, orders);
                    break;
                case 5:
                    viewAllOrders(orders);
                    break;
                case 6:
                    viewNextOrder(orders);
                    break;
                case 9:
                    this.isRunning = false;
                default:
                    System.out.println("Indtastning fokert - Prøv igen");
                    menuController(mariosMenu,ui,orders);
        }
    }

    //Behavior (Methods) ---------------------------
    protected void viewMariosPizzaMenu(PizzaMenu mariosMenu) {
        mariosMenu.printMenu();
    }
    protected void makeAnOrder(Controller ui, Orders orders) {
        orders.addOrder(ui);
    }

    protected  void deleteAnOrder(Controller ui, Orders orders) {
        orders.deleteOrder(ui);
    }

    protected void finishAnOrder(Controller ui, Orders orders) {
        orders.finishOrder(ui);
    }

    protected void viewAllOrders(Orders orders) {
        orders.printActiveOrderList();
    }

    protected void viewNextOrder(Orders orders) {
        System.out.println("\nTil " + orders.getActiveOrders().get(orders.getActiveOrders().size()-1).getName()
                + ": " + orders.getActiveOrders().get(orders.getActiveOrders().size() - 1).getOrderList());
    }

    @Override
    public String toString() {
        return menuOptions[0] + "\n" + menuOptions[1] + "\n" + menuOptions[2] + "\n" + menuOptions[3] +
                "\n" + menuOptions[4] + "\n" + menuOptions [5] + "\n" + menuOptions[6] + "\n" + menuOptions[7];
    }
}
