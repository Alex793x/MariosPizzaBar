import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PersonOrder {
    private static int uniqueID = 1;
    private int id = uniqueID++;
    private String name;
    private String phoneNumber;
    private Pizza pizzaChoice;
    private List<Pizza> orderList = new ArrayList<>();
    private boolean paid = false;

    private final LocalDateTime orderTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final String formatOrderTime = orderTime.format(formatter);

    //Constructor ----------------------
    PersonOrder() {
        setName();
        setPhoneNumber();
        setPizzaChoice();
    }

    //GETTER ----------------------
    protected  int getId() {
        return id;
    }
    protected String getName() {
        return name;
    }

    protected Pizza getPizzaChoice() {
        return pizzaChoice;
    }

    protected ArrayList<Pizza> getOrderList(){
        return (ArrayList<Pizza>) orderList;
    }

    protected boolean isPaid() {
        return paid;
    }

    protected String getOrderTime() {
        return formatOrderTime;
    }

    //SETTER -----------------------
    protected void setName() {
        System.out.print("Who is ordering: ");
        this.name = Controller.in.nextLine();
    }

    protected void setPhoneNumber() {
        System.out.print("Phone number on customer: ");
        this.phoneNumber = Controller.in.nextLine();
    }


    protected void setPaid() {
        this.paid = true;
    }


    // Behavior (Methods) -----------------------------------

    protected void setPizzaChoice() {
        System.out.print("Which pizza?: ");
        pizzaChoice = Pizza.values()[Controller.in.nextInt() - 1];    // Choose pizza based on ordinal enum position
        orderList.add(pizzaChoice);                                   // Add pizza to persons Order list.

        Controller.in.nextLine();           //Scanner bug

        System.out.println("Do the customer wants another pizza?: y/n");
        if (Controller.in.nextLine().equalsIgnoreCase("y")) {
            setPizzaChoice();               // Recursive method to add new pizza
        } else {
            System.out.println((orderList.size() > 1) ? "Pizzas " : "Pizza ");
            System.out.println("added! to " + name +
                    ((name.substring(name.length() - 1)).equals("s") ? " list" : "'s list"));
        }
    }



    @Override
    public String toString() {
        return "\nNext Order: " +
                "\nOrder ID: " + id +
                "\nName on customer: " + name +
                "\nOrdered " + pizzaChoice +
                "\nPrice: " + pizzaChoice.getPizzaPrice() +
                " - Paid Status: " + isPaid() +
                "\n--------------------------------------\n";
    }
}
