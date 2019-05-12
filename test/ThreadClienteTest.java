import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.logging.*;
import java.rmi.*;

public class ThreadClienteTest extends Thread {

    private final int personaId;
    private final String PORT;
    private final String IP;
    private String signo;
    private String fechaString;
    private LocalDateTime fecha = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ThreadClienteTest(int id, String server, String port) {
        this.personaId = id;
        this.IP = server;
        this.PORT = port;
    }

    @Override
    public void run() {
        try {
            // suponiendo que pedimos un pronóstico extendido a max. 15 dias
            // generamos un random entre 0 y 15.
            // luego agregamos esa cantidad de días a la fecha actual
            Random rand = new Random();
            int indiceRandom = rand.nextInt(15);
            fecha = fecha.plusDays(indiceRandom);
            fechaString = fecha.format(dateFormatter);
            // obtenemos un signo al azar
            signo = SignosZodiaco.getInstance().getSigno();

            IConsulta consulta = (IConsulta) Naming.lookup("//" + IP + ":" + PORT + "/ConsultaImp");

            System.out.println("Cliente numero " + this.personaId + System.lineSeparator()
                    + consulta.consultar(signo, fechaString));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
