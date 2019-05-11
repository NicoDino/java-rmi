import java.rmi.server.*;
import java.rmi.*;

public class ConsultaImp extends UnicastRemoteObject implements IConsulta {

    ConsultaImp() throws RemoteException {
    }

    public String consultar(String signo, String fechaString) throws RemoteException {
        return "un pronostico";
    }
}