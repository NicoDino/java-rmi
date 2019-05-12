import java.rmi.*;
import java.rmi.server.*;

class ServidorPronostico {
    static public void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Uso: ServidorPronostico Puerto");
            return;
        }
        if (System.getSecurityManager() == null) {
            // System.setSecurityManager(new RMISecurityManager());
            System.setProperty("java.rmi.server.hostname", "localhost");
        }
        try {
            ConsultaPronosticoImp consultaPronostico = new ConsultaPronosticoImp();
            Naming.rebind("rmi://localhost:" + args[0] + "/ConsultaPronosticoImp", consultaPronostico);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Excepcion en ServidorPronostico: ");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
