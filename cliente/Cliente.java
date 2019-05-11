import java.io.BufferedReader;
import java.rmi.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cliente {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: Cliente IP Puerto");
            return;
        }
        try {
            IConsulta consulta = (IConsulta) Naming.lookup("//" + args[0] + ":" + args[1] + "/ConsultaImp");
            System.out.println("Para comenzar, ingrese un signo y presione enter");
            BufferedReader tecladoIn = new BufferedReader(new InputStreamReader(System.in));
            String signo = tecladoIn.readLine();
            System.out.println("Ahora ingrese una fecha y presione enter");
            String fecha = tecladoIn.readLine();
            System.out.println("Resultado:  " + consulta.consultar(signo, fecha));
            System.out.println("Fin del programa");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
