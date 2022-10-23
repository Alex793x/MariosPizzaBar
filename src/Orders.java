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

            System.out.printf("%nOrdre ID: " + activeOrders.get(activeOrders.size()-1).getId() + "%nNavn på kunde: " +
                    activeOrders.get(activeOrders.size()-1).getName() +
                    "%n%nBestilt: %n--------------------------------------");
            for (int j = 0; j < activeOrders.get(activeOrders.size()-1).getOrderList().size(); j++) {
                System.out.printf("%n"+ activeOrders.get(activeOrders.size()-1).getOrderList().get(j));
            }
            System.out.printf("%n%nKlokken " + activeOrders.get(activeOrders.size()-1).getOrderTime() + "%nTotal pris: " +
                    totalOrderListPrice(activeOrders.get(activeOrders.size()-1)) +
                    "%nBetalt: " + activeOrders.get(activeOrders.size()-1).isPaid() +
                    "%n--------------------------------------%n");
        } else {
            System.out.println("\nIngen ordrer venter på at blive lavet!");
        }
    }

    protected double turnOver() {
        double totalTurnOver = 0;
        for (int i = 0; i < finishedOrders.size(); i++) {
            for (int j = 0; j < finishedOrders.get(i).getOrderList().size(); j++) {
                totalTurnOver += finishedOrders.get(i).getOrderList().get(j).getPizzaPrice();
            }
        }
        return totalTurnOver;
    }

    protected double totalOrderListPrice(PersonOrder personOrder) {
        double totalPrice = 0;
        for (int i = 0; i < personOrder.getOrderList().size(); i++ ) {
            totalPrice += personOrder.getOrderList().get(i).getPizzaPrice();
        }
        return totalPrice;
    }

    protected void printActiveOrderList() {
        orderPrint(activeOrders);
    }

    protected void printFinsihedOrderList() {
        orderPrint(finishedOrders);
    }

    protected void orderPrint(List<PersonOrder> activeOrders) {
        for (int i = 0; i < activeOrders.size(); i++) {
            System.out.printf("%nOrdre ID: " + activeOrders.get(i).getId() + "%nNavn på kunde: " +
                    activeOrders.get(i).getName() + "%n%nBestilt: %n--------------------------------------");
            for (int j = 0; j < activeOrders.get(i).getOrderList().size(); j++) {
                System.out.printf("%n"+ activeOrders.get(i).getOrderList().get(j));
            }
            System.out.printf("%n%nKlokken " + activeOrders.get(i).getOrderTime() + "%nTotal pris: " +
                    totalOrderListPrice(activeOrders.get(i)) +
                    "%nBetalt: " + activeOrders.get(i).isPaid() +
                    "%n--------------------------------------%n");
        }
    }

}
