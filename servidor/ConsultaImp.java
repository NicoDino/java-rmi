/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nico
 */
public class ConsultaImp extends UnicastRemoteObject implements ConsultaInterfaceSrv
{
    protected ConsultaImp() throws RemoteException
    { super(); }
   
    @Override
    public String pronosticar(String fechaString) throws RemoteException {
        System.out.println("PRONOSTICANDO GATO");
        return "un pronostico";
    }

    @Override
    public String obtenerPrediccion(String signo) throws RemoteException {
                System.out.println("PRONOSTICANDO GATO");

        return "una prediccion";
    }
}


