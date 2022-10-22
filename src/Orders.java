import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orders implements Comparable<PersonOrder> {
    private static List<PersonOrder> activeOrders = new ArrayList<>();
    private static List<PersonOrder> finishedOrders = new ArrayList<>();

    private LocalDateTime orderTime = LocalDateTime.now();


    // CONSTRUCTOR ---------------------------------------------
    public Orders() {
    }


    //GETTER ---------------------------------------------------
    protected ArrayList<PersonOrder> getActiveOrders() {
        return (ArrayList<PersonOrder>) activeOrders;
    }

    protected ArrayList<PersonOrder> getFinishedOrders() {
        return (ArrayList<PersonOrder>) finishedOrders;
    }

    private LocalDateTime getDateTime() {
        return orderTime;
    }

    // Behaviors (Methods) -------------------------------------

    protected void addOrder(Controller ui) {
        try {
            activeOrders.add(new PersonOrder(ui)); // Add a person with order to active list.
        }
        catch (Exception e) {
            System.out.println("Noget gik galt, prøv venligst igen fra start");
            ui.in.nextLine();
            addOrder(ui);
        }
    }

    protected void deleteOrder(Controller ui) {
        System.out.print("Hvem vil gerne have sin ordre slettet?: ");
        for (int i = 0; i < activeOrders.size(); i++) {
            if (ui.in.nextLine().equals(activeOrders.get(i).getName())) {
                activeOrders.remove(i); // Delete order from active list
            } else {
                System.out.print("Navn findes ikke på listen, vil du prøve indtaste igen? - y/n ");
                if (ui.in.nextLine().equals("y")) {
                    deleteOrder(ui);
                }
                break;
            }
        }
    }

    protected void finishOrder(Controller ui) {
        System.out.print("Hvilken kunde har fået udleveret sin ordre?: ");

        for (int i = 0; i < activeOrders.size(); i++) {
            if (ui.in.nextLine().equals(activeOrders.get(i).getName())) {
                activeOrders.get(i).setPaid();      // Set payment to equal true
                finishedOrders.add(activeOrders.get(i));    //move from active to finished list
                activeOrders.remove(i); // Remove order from active order list.
            } else {
                System.out.print("Navn findes ikke på listen, vil du prøve at indtaste igen? - y/n ");
                if (ui.in.nextLine().equals("y")) {
                    finishOrder(ui);
                }
                break;
            }
        }
    }

    protected void printActiveOrderList() {
        for (PersonOrder personOrder : activeOrders) {
            System.out.printf("\nOrdre ID: " + personOrder.getId() + "\nNavn på kunde: " + personOrder.getName() +
                    " - Bestilt " + personOrder.getPizzaChoice() + " klokken " + personOrder.getOrderTime() +
                    "\nPris: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Betalt: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }

    protected void printFinsihedOrderList() {
        for (PersonOrder personOrder : finishedOrders) {
            System.out.printf("%Ordre ID: " + personOrder.getId() + "\nNavn på kunde: " + personOrder.getName() +
                    " - Bestilt " + personOrder.getPizzaChoice() + " klokken " + personOrder.getOrderTime() +
                    "\nPris: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Betalt: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }

    @Override
    public int compareTo(PersonOrder o) {
        return getDateTime().compareTo(o.orderTime());
    }
}
