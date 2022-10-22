public class PizzaMenu {

    // Constructor -------------------------------
    PizzaMenu() {
    }

    // Behavior (Methods) ------------------------
    protected void printMenu() {
        int id = 1;
        for (Pizza pizza : Pizza.values()) {
            System.out.printf("%d. " + pizza + " - Ingredientser: " + pizza.getPizzaIngriedients()+"%n", id);
            id++;
        }
        System.out.println();
    }

}