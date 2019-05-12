import java.rmi.*;

interface IConsultaHoroscopo extends Remote {
    String consultarHoroscopo(String signo) throws RemoteException;
}