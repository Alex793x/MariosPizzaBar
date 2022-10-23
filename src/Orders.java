import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orders {
    private static List<PersonOrder> activeOrders = new ArrayList<>();
    private static List<PersonOrder> finishedOrders = new ArrayList<>();



    // CONSTRUCTOR ---------------------------------------------
    public Orders() {
    }

    // Behaviors (Methods) -------------------------------------

    protected void addOrder() {
        try {
            activeOrders.add(new PersonOrder()); // Add a person with order to active list.
        }
        catch (Exception e) {
            System.out.println("\nNoget gik galt, prøv venligst igen fra start");
            Controller.in.nextLine();
            addOrder();
        }
    }

    protected void deleteOrder() {
        System.out.print("\nHvem vil gerne have sin ordre slettet?: ");
        for (int i = 0; i < activeOrders.size(); i++) {
            if (Controller.in.nextLine().equals(activeOrders.get(i).getName())) {
                activeOrders.remove(activeOrders.get(i)); // Delete order from active list
            }
        }
    }

    protected void finishOrder() {
        System.out.print("\nHvilken kunde har fået udleveret sin ordre?: ");
        String input = Controller.in.nextLine();

        for(Iterator<PersonOrder> i = activeOrders.iterator(); i.hasNext();) {
            PersonOrder personOrder = i.next();

            if (personOrder.getName().equals(input)) {
                personOrder.setPaid();
                finishedOrders.add(personOrder);
                i.remove();
            }
        }
    }
    protected void viewNextOrder() {
        if (activeOrders.size() > 0) {
            System.out.println("\nTil " + activeOrders.get(activeOrders.size()-1).getName()
                    + ": " + activeOrders.get(activeOrders.size() - 1).getOrderList());
        } else {
            System.out.println("\nIngen ordrer venter på at blive lavet!");
        }
    }

    protected double turnOver() {
        double totalTurnOver = 0;
        for (PersonOrder finishedOrder : finishedOrders) {
            totalTurnOver += finishedOrder.getPizzaChoice().getPizzaPrice();
        }
        return totalTurnOver;
    }

    protected void printActiveOrderList() {
        for (PersonOrder personOrder : activeOrders) {
            System.out.printf("\nOrdre ID: " + personOrder.getId() + "\nNavn på kunde: " + personOrder.getName() +
                    " - Bestilt: " + personOrder.getPizzaChoice() + " - Klokken " + personOrder.getOrderTime() +
                    "\nPris: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Betalt: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }

    protected void printFinsihedOrderList() {
        for (PersonOrder personOrder : finishedOrders) {
            System.out.printf("\nOrdre ID: " + personOrder.getId() + "\nNavn på kunde: " + personOrder.getName() +
                    " - Bestilt: " + personOrder.getPizzaChoice() + " - Klokken " + personOrder.getOrderTime() +
                    "\nPris: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Betalt: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }
}
