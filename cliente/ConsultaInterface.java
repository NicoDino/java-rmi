/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nico
 */
public interface ConsultaInterface extends Remote {
    public String pronosticar (String fechaString) throws RemoteException;
    public String obtenerPrediccion (String signo) throws RemoteException;

} 
