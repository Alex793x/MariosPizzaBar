public enum Pizza {
    VESUVIO("Vesuvio","tomatsauce, ost, skinke og oregano" ,57),
    AMERIKANER("Amerikaner","tomatsauce, ost, oksefars og oregano",53),
    CACCIATORE("Cacciatore","tomatsauce, ost, peporoni og oregano",57),
    CARBONA("Carbona","tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano",63),
    DENNIS("Dennis","tomatsauce, ost, skinke, peporoni, cocktailspølser og oregano",65),
    BERTIL("Bertil","tomatsauce, ost, bacon og oregano",57),
    SILVIA("Silvia","tomatsauce, ost, peporoni, rød peber, løg, oliven og oregano",61),
    VICTORIA("Victoria","tomatsauce, ost, skinke, ananas, champignon, løg og oregano",61),
    TORONFO("Toronfo","tomatsauce, ost, skinke, bacon, kebab, chili og oregano",61),
    CAPRICCIOSA("Capricciosa","tomatsauce, ost, skinke, champignong, og oregano",61),
    HAWAI("Hawai","tomatsauce, ost, skinke, ananas og oregano",61),
    LEBLISSOLA("Leblissola","tomatsauce, ost, skinke, rejer og oregano",61),
    VENEZIA("Venezia","tomatsauce, ost, skinke, bacon og oregano",61),
    MARFIA("Marfia","tomatsauce, ost, peporoni, bacon, løg og oregano", 61);


    // ATTRIBUTES ------------------------------
    private final String pizzaName;
    private final String pizzaIngriedients;
    private final int pizzaPrice;

    //Constructor --------------------------------
    Pizza(String pizzaName, String pizzaIngriedients, int pizzaPrice) {
        this.pizzaName = pizzaName;
        this.pizzaIngriedients = pizzaIngriedients;
        this.pizzaPrice = pizzaPrice;
    }

    public String getPizzaIngriedients() {
        return pizzaIngriedients;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }


    @Override
    public String toString() {
        return pizzaName + " - Med " + pizzaIngriedients;
    }
}
