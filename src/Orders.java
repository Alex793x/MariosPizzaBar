import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orders implements Comparable<PersonOrder> {
    private static List<PersonOrder> activeOrders = new ArrayList<>();
    private static List<PersonOrder> finishedOrders = new ArrayList<>();

    private LocalDateTime orderTime = LocalDateTime.now();



    //GETTER ---------------------------------------------------
    protected ArrayList<PersonOrder> getActiveOrders() {
        return (ArrayList<PersonOrder>) activeOrders;
    }

    protected ArrayList<PersonOrder> getFinishedOrders() {
        return (ArrayList<PersonOrder>) finishedOrders;
    }

    public LocalDateTime getDateTime() {
        return orderTime;
    }


    // CONSTRUCTOR ---------------------------------------------
    public Orders() {
    }

    protected void printActiveOrders() {
        for (PersonOrder personOrder : activeOrders) {
            System.out.printf("\nOrder ID: " + personOrder.getId() + "\nName on customer: " + personOrder.getName() +
                    " - Ordered " + personOrder.getPizzaChoice() + " at " + personOrder.getOrderTime() +
                    "\nPrice: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Paid Status: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }

    protected void printFinsihedOrders() {
        for (PersonOrder personOrder : finishedOrders) {
            System.out.printf("%nOrder ID: " + personOrder.getId() + "\nName on customer: " + personOrder.getName() +
                    " - Ordered " + personOrder.getPizzaChoice() + " at " + personOrder.getOrderTime() +
                    "\nPrice: " + personOrder.getPizzaChoice().getPizzaPrice() +
                    " - Paid Status: " + personOrder.isPaid() +
                    "%n--------------------------------------%n");
        }
    }

    @Override
    public int compareTo(PersonOrder o) {
        return getDateTime().compareTo(o.orderTime());
    }
}
