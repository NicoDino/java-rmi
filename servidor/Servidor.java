/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 *
 * @author nico
 */
public class Servidor {

    public static void main(String args[]) {
          if (args.length!=2) {
            System.err.println("Uso: Servidor IP Puerto");
            return;
        }
     
        try {
            ConsultaImp consulta = new ConsultaImp();
            Naming.rebind("rmi://" + args[0] + ":" + args[1] + "/ConsultaImp", consulta);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Excepcion en Servidor:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}