import java.rmi.*;
import java.rmi.server.*;

class ServidorHoroscopo {
    static public void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorHoroscopo Puerto");
            return;
        }
        if (System.getSecurityManager() == null) {
            // System.setSecurityManager(new RMISecurityManager());
            System.setProperty("java.rmi.server.hostname", "localhost");
        }
        try {
            ConsultaHoroscopoImp consultaHoroscopo = new ConsultaHoroscopoImp();
            Naming.rebind("rmi://localhost:" + args[0] + "/ConsultaHoroscopoImp", consultaHoroscopo);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Excepcion en ServidorHoroscopo: ");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
