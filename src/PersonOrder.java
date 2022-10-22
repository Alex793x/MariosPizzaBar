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


    //GETTER ----------------------
    protected  int getId() {
        return id;
    }
    protected String getName() {
        return name;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
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

    protected LocalDateTime orderTime() {
        return orderTime;
    }

    //SETTER -----------------------
    protected void setId() {
        this.id = uniqueID++;
    }
    protected void setName() {
        this.name = Controller.in.nextLine();
    }

    protected void setPhoneNumber() {
        this.phoneNumber = Controller.in.nextLine();
    }

    protected void setPizzaChoice() {
        this.pizzaChoice = Pizza.values()[Controller.in.nextInt() - 1];
        Controller.in.nextLine();
    }

    protected void setPaid() {
        this.paid = true;
    }

    //Constructor ----------------------
    PersonOrder() {
        System.out.print("Who is ordering: ");
        setName();
        System.out.print("Phone number on customer: ");
        setPhoneNumber();
        System.out.print("Which pizza: ");
        setPizzaChoice();
        orderList.add(pizzaChoice);
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
