public class Main {
    Controller controller = new Controller();

    private void run() {
        System.out.println("------------------------------------------");
        System.out.println("|                                        |");
        System.out.println("|     VELKOMMEN TIL MARIOS PIZZA BAR     |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");

        controller.menuController();

    }
    public static void main(String[] args) {
        new Main().run();
    }
}
