import java.rmi.*;

interface IConsulta extends Remote {
    String consultar(String signo, String fechaString) throws RemoteException;
}