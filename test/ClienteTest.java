import java.util.ArrayList;

public class ClienteTest {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: ClienteTest IP Puerto");
            return;
        }
        ArrayList<Thread> clients = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            clients.add(new ThreadClienteTest(i, args[0], args[1]));
        }
        for (Thread thread : clients) {
            thread.start();
        }

    }
}