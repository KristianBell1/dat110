package no.hvl.dat110.display;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class DisplayDevice extends Thread {


    private Object temp;

    public void run() {

		System.out.println("Display started...");	
		
		// TODO
		
		// Get a reference to the registry using the port
        Registry registry = null;
		TempSensorInterface tsi;

        try {
            registry = LocateRegistry.getRegistry(TempSensorInterface.SERVER_PORT);
			 tsi = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
        // Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME


		// loop 10 times and read the temp value from the TemperatureSensor each time

		for (int i = 0; i < 10; i++) {
            // get the temperature value by calling the getTemperature remote method via the object of TempSensorInterface
            // print the temperature value to console
            int tmp = 10;
            try {
                tmp = tsi.getTemperatur();
                System.out.printf("Temperatur: %s%n", tmp);
                Thread.sleep(1000);
            } catch (RemoteException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
		
		// throw new RuntimeException("RPC DisplayDevice Client Not yet implemented...");
		
	}
}
