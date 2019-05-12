import java.rmi.server.*;
import java.rmi.*;

public class ConsultaImp extends UnicastRemoteObject implements IConsulta {

    String IP_SERVIDOR_PRONOSTICO = "localhost";
    String PUERTO_SERVIDOR_PRONOSTICO = "7000";
    String IP_SERVIDOR_HOROSCOPO = "localhost";
    String PUERTO_SERVIDOR_HOROSCOPO = "6000";

    ConsultaImp() throws RemoteException {
    }

    public String consultar(String signo, String fechaString) throws RemoteException {

        String resultado = System.lineSeparator() + "-------------------------------------------------------------"
                + System.lineSeparator() + "Resultado de la consulta " + System.lineSeparator()
                + "-------------------------------------------------------------" + System.lineSeparator()
                + System.lineSeparator();
        String pronosticoCacheado = (String) Cache.getInstance().getPronostico(fechaString);
        String horoscopoCacheado = (String) Cache.getInstance().getHoroscopo(signo);

        try {
            if (pronosticoCacheado == null) {
                IConsultaPronostico consultaPronostico = (IConsultaPronostico) Naming.lookup(
                        "//" + IP_SERVIDOR_PRONOSTICO + ":" + PUERTO_SERVIDOR_PRONOSTICO + "/ConsultaPronosticoImp");
                String pronostico = consultaPronostico.consultarPronostico(fechaString);
                resultado = resultado + "Pronostico para " + fechaString + " : " + pronostico + System.lineSeparator()
                        + System.lineSeparator();
                Cache.getInstance().addPronostico(fechaString, pronostico);
            } else {
                resultado = resultado + "Pronostico para " + fechaString + " : " + pronosticoCacheado
                        + System.lineSeparator() + System.lineSeparator();
            }
            if (horoscopoCacheado == null) {
                IConsultaHoroscopo consultaHoroscopo = (IConsultaHoroscopo) Naming.lookup(
                        "//" + IP_SERVIDOR_HOROSCOPO + ":" + PUERTO_SERVIDOR_HOROSCOPO + "/ConsultaHoroscopoImp");
                String horoscopo = consultaHoroscopo.consultarHoroscopo(signo);
                resultado = resultado + "Horoscopo de " + signo + " : " + horoscopo + System.lineSeparator();
                Cache.getInstance().addHoroscopo(signo, horoscopo);
            } else {
                resultado = resultado + "Horoscopo de " + signo + " : " + horoscopoCacheado + System.lineSeparator();
            }
            resultado = resultado + System.lineSeparator()
                    + "-------------------------------------------------------------";
            return resultado;
        } catch (Exception e) {
            System.out.println("ERROR EN SERVIDOR CENTRAL");
            e.printStackTrace();
            return "ERROR EN SERVIDOR CENTRAL";
        }
    }
}