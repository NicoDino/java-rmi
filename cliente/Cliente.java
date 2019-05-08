package cliente;

import java.rmi.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Cliente {

    private String signo;
    private String fechaString;
    private LocalDateTime fecha = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(String ip, String port) {
        try {
            ConsultaInterface consulta;
            consulta = (ConsultaInterface) Naming.lookup("//" + ip + ":" + port + "/ConsultaImp");
            // suponiendo que pedimos un pronóstico extendido a max. 15 dias
            // generamos un random entre 0 y 15.
            // luego agregamos esa cantidad de días a la fecha actual
            Random rand = new Random();
            int indiceRandom = rand.nextInt(15);
            fecha = fecha.plusDays(indiceRandom);
            fechaString = fecha.format(dateFormatter);
            // obtenemos un signo al azar
            signo = SignosZodiaco.getInstance().getSigno();
            System.out.print("Pronostico para el "+fechaString+" --> ");
            System.out.println(consulta.pronosticar(fechaString));
            System.out.print("Horoscopo de  "+signo+" --> ");
            System.out.println(consulta.obtenerPrediccion(signo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: Cliente IPServidor PuertoServidor ...");
            return;
        }

        new Cliente(args[0], args[1]);
    }

}
