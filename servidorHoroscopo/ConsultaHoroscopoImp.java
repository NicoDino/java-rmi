import java.rmi.server.*;
import java.rmi.*;

public class ConsultaHoroscopoImp extends UnicastRemoteObject implements IConsultaHoroscopo {

    ConsultaHoroscopoImp() throws RemoteException {
    }

    public String consultarHoroscopo(String signo) throws RemoteException {
        return PrediccionHoroscopo.getInstance().getPrediccion(signo);
    }
}