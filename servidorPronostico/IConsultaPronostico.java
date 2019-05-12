import java.rmi.*;

interface IConsultaPronostico extends Remote {
    String consultarPronostico(String fecha) throws RemoteException;
}