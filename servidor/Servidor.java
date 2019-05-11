import java.rmi.*;
import java.rmi.server.*;

class Servidor {
    static public void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: Servidor Puerto");
            return;
        }
        if (System.getSecurityManager() == null) {
            // System.setSecurityManager(new RMISecurityManager());
            System.setProperty("java.rmi.server.hostname", "localhost");
        }
        try {
            ConsultaImp consulta = new ConsultaImp();
            Naming.rebind("rmi://localhost:" + args[0] + "/ConsultaImp", consulta);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Excepcion en Servidor: ");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
