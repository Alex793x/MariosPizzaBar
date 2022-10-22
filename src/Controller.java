import java.util.Scanner;

public class Controller {
    public static Scanner in = new Scanner(System.in);
    PizzaMenu mariosMenu = new PizzaMenu();
    Orders orderLists = new Orders();




    //Behavior (Methods) ---------------------------
    public void addOrder() {
        try {
            orderLists.getActiveOrders().add(new PersonOrder()); // Add a person with order to active list.
        }
        catch (Exception e) {
            System.out.println("Something went wrong, please try again from the start");
            in.nextLine();
            addOrder();
        }
    }

    public void deleteOrder() {
        System.out.print("Who wants to cancel their order?: ");
        for (int i = 0; i < orderLists.getActiveOrders().size(); i++) {
            if (in.nextLine().equals(orderLists.getActiveOrders().get(i).getName())) {
                orderLists.getActiveOrders().remove(i); // Delete order from active list
            } else {
                System.out.print("Name not found on the list, do you want to try again? -  y/n ");
                if (in.nextLine().equals("y")) {
                    finishOrder();
                }
                break;
            }
        }
    }


    public void finishOrder() {
        System.out.print("Which customer has received their order: ");

        for (int i = 0; i < orderLists.getActiveOrders().size(); i++) {
            if (in.nextLine().equals(orderLists.getActiveOrders().get(i).getName())) {
                orderLists.getActiveOrders().get(i).setPaid();      // Set payment to equal true
                orderLists.getFinishedOrders().add(orderLists.getActiveOrders().get(i));    //move from active to finished list
                orderLists.getActiveOrders().remove(i); // Remove order from active order list.
            } else {
                System.out.print("Name not found on the list, do you want to try again? -  y/n ");
                if (in.nextLine().equals("y")) {
                    finishOrder();
                }
                break;
            }
        }
    }

    public void viewAllOrders() {
        orderLists.printActiveOrders();

    }

    public void viewNextOrder() {
        System.out.println(orderLists.getActiveOrders().get(orderLists.getActiveOrders().size() - 1));
    }
}
