public class Main {
    static Controller ui = new Controller();
    static Orders orders = new Orders();
    static PizzaMenu mariosMenu = new PizzaMenu();

    private void run(PizzaMenu mariosMenu, Controller ui, Orders orders) {
        System.out.println("------------------------------------------");
        System.out.println("|                                        |");
        System.out.println("|     VELKOMMEN TIL MARIOS PIZZA BAR     |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");

        do {
            System.out.println(ui.toString());
            ui.menuController(mariosMenu, ui, orders);
        } while (ui.isRunning);

    }

    public static void main(String[] args) {
        new Main().run(mariosMenu, ui, orders);
    }
}
