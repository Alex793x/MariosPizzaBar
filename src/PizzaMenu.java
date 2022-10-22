import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaMenu {
    private static final List<Pizza> menu = new ArrayList<>();

    // Constructor -------------------------------
    PizzaMenu() {
        createMenu();
    }

    // Behavior (Methods) -------------------------
    protected void createMenu() {
        menu.addAll(Arrays.asList(Pizza.values()));
    }

    protected void printMenu() {
        int id = 1;
        for (Pizza pizza : Pizza.values()) {
            System.out.printf("%d. " + pizza + " - Ingredientser: " + pizza.getPizzaIngriedients()+"%n", id);
            id++;
        }
    }

}