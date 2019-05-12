import java.rmi.server.*;
import java.rmi.*;

public class ConsultaPronosticoImp extends UnicastRemoteObject implements IConsultaPronostico {

    ConsultaPronosticoImp() throws RemoteException {
    }

    public String consultarPronostico(String fecha) throws RemoteException {
        return PrediccionClima.getInstance().getPrediccion(fecha);
    }
}